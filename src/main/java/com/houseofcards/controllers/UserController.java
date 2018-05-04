package com.houseofcards.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.houseofcards.entities.generated.Logininfo;
import com.houseofcards.entities.generated.Paymentdetails;
import com.houseofcards.entities.generated.Premiumcustomerdetails;
import com.houseofcards.entities.generated.User;
import com.houseofcards.repositories.LoginInfoRepository;
import com.houseofcards.repositories.PaymentdetailsRepository;
import com.houseofcards.repositories.PremiumCustomerDetailsRepository;
import com.houseofcards.repositories.RoleRepository;
import com.houseofcards.repositories.UserRoleRepository;
import com.houseofcards.services.SecurityService;
import com.houseofcards.services.UserService;
import com.houseofcards.validation.UserValidator;

@Controller
public class UserController {

	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
	private PaymentdetailsRepository paymentDetailsRepo;
    
    @Autowired
   	private LoginInfoRepository loginRepo;
    
    @Autowired
    private RoleRepository roleRepo;
    
    @Autowired
    private UserRoleRepository userRoleRepo;
    
    @Autowired
    private PremiumCustomerDetailsRepository premiumRepo;
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model model, HttpServletRequest request) {
        model.addAttribute("newUser", new User());
        
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(User newUser, String premiumUser, String fName, String lName, 
    		String emailIn, String usernameIn, String passwordIn, BindingResult bindingResult, 
    		Model model, final RedirectAttributes redirectAttributes) {
        
    	
        try {
	    	newUser.setFirstName(fName);
	        newUser.setLastName(lName);
	        newUser.setPhoneNumber("(555)555-5555");
	        newUser.setEmail(emailIn);
	        
	        Logininfo l = new Logininfo();
	        l.setUsername(usernameIn);
	        l.setPassword(passwordIn);
	        
	        newUser.setRole(roleRepo.findByRole("ROLE_USER"));
			newUser.setUserrole(userRoleRepo.findByPosRole("Customer"));
	        
	        newUser.setLogininfo(l);
	        
	        userValidator.validate(newUser, bindingResult);
	        if (bindingResult.hasErrors()) {
	        	model.addAttribute("error", bindingResult.getAllErrors());
	        	return "redirect:/register?error";
	        }
	        
	        
	        loginRepo.save(l);
	        userService.save(newUser);
	        
	        
	    	
	    	boolean prem = false;
	        
	    	if (premiumUser != null && premiumUser.equals("on")) {
	    		prem = true;
	    		newUser.setIsPremium(prem);
	
	        	newUser.setRole(roleRepo.findByRole("ROLE_USER"));
	    		newUser.setUserrole(userRoleRepo.findByPosRole("Premium"));
	    		
	    		Premiumcustomerdetails premiumDetails = new Premiumcustomerdetails();
	    		premiumDetails.setRewardPoints(0);
	    		premiumDetails.setUser(newUser);
	    		premiumRepo.save(premiumDetails);
	    		
	    		//newUser.getPremiumcustomerdetailses().add(premiumDetails);
	    		
	    		userService.save(newUser);
	    		redirectAttributes.addFlashAttribute("newUserId", newUser.getPkUserId());
	    		
	    		
	    		return "redirect:/premiumpayment";
	    	}
	    	
	        
	    	newUser.setIsPremium(prem);
	    	
	    	
	    	
	        userService.save(newUser);
	
	        Logininfo login = newUser.getLogininfo();
	        
	        securityService.autologin(login.getUsername(), login.getPassword());
        } catch (Exception ex) {
        	if (bindingResult.hasErrors()) {
            	model.addAttribute("error", bindingResult.getAllErrors());
                
            } 
        	return "redirect:/register?error";
        }
        return "registrationsuccess";
    }
    
    @RequestMapping(value = "/premiumpayment")
    public String premiumPaymentDetailsForm(Model model, @ModelAttribute("newUserId") Integer newUserId,
    		final RedirectAttributes redirectAttributes) {
    	 	
    	
    	Paymentdetails payment = new Paymentdetails();
    	
    	if (!userService.findById(newUserId).getPaymentdetailses().isEmpty()) {
    		payment = userService.findById(newUserId).getPaymentdetailses().iterator().next();
    	}
    	
    	
    	
    	model.addAttribute("paymentdetails", payment);
    	
    	
    	
    	model.addAttribute("newUserId", newUserId);
	    return "registrationpaymentdetails";
    }
    
    @RequestMapping(value = "/premiumpayment", method = RequestMethod.POST)
    public String premiumPaymentDetailsResult(Paymentdetails paymentdetails, String cardExp, 
    		String radCardType, Integer newUserId, Model model) throws ParseException {
    	
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(cardExp);
		paymentdetails.setCardExpiration(date);
		paymentdetails.setCardType(radCardType);
		
				
		//userService.save(newUser);
		
		User newUser = userService.findById(newUserId);
		
		
		paymentdetails.setUser(newUser);
		
		paymentDetailsRepo.save(paymentdetails);
    	
    	
    	//newUser.getPaymentdetailses().add(paymentdetails);
    	//userService.save(newUser);
    	
    	
    	model.addAttribute("newUser", newUser);
    	
    	Logininfo login = newUser.getLogininfo();
        
        securityService.autologin(login.getUsername(), login.getPassword());

    	
    	
	    return "registrationsuccess";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("login-error", true);

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfullyff.");
        
        
        
        return "/login";
    }
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Model model, HttpSession session, String username) {
    	User user = userService.findByUsername(username);
	    session.setAttribute("user", user);
	    return "redirect:/login?success";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
    
    

//    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
//    public String welcome(Model model) {
//        return "welcome";
//    }
    
    
    
	
}
