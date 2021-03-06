package com.houseofcards.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.houseofcards.entities.generated.Logininfo;
import com.houseofcards.entities.generated.User;
import com.houseofcards.repositories.UserRepository;
import com.houseofcards.services.UserService;

@Component
public class UserValidator implements Validator {
	
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user =	(User) o;
        
        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "logininfo.username", "NotEmpty");
        if (user.getLogininfo().getUsername().length() < 6 || user.getLogininfo().getUsername().length() > 32) {
            errors.rejectValue("logininfo.username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getLogininfo().getUsername()) != null) {
            errors.rejectValue("logininfo.username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "logininfo.password", "NotEmpty");
        if (user.getLogininfo().getPassword().length() < 8 || user.getLogininfo().getPassword().length() > 32) {
            errors.rejectValue("logininfo.password", "Size.userForm.password");
        }

//        if (!user.getPasswordConfirm().equals(user.getPassword())) {
//            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
//        }
    }
}