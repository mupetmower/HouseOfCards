package com.houseofcards.controllers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.houseofcards.entities.SalesByUser;
import com.houseofcards.repositories.SaleRepository;
import com.houseofcards.repositories.UserRepository;

@Controller
public class TestingController {
		
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SaleRepository saleRepo;
	
		
	@RequestMapping("/testing")
	public String mockup(Model model) throws ParseException {
				
		model.addAttribute("users", userRepo.findAll());
		
		//- NOTE - for date comparisons, must either use the Date(String s) constructor (deprecated) in
		//this format: new Date("2018/01/30"); The other Date constructors and parsers are broken and
		//store the year incorrectly..
		//- OR - you must use SimpleDateFormat, define your format and use it to parse a string.
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date test1 = df.parse("01/02/2016");
		Date test2 = df.parse("01/02/2018");
		
		model.addAttribute("sales", saleRepo.findByDateTimeBetween(new Date("2016/1/2"), new Date("2018/1/2")));
		System.out.println("Date as 2018, 1, 2: " + new Date("2018/1/2"));
		System.out.println("SimpleDateFormat as 01/02/2018: " + test2);
		
		
		//saleRepo.findByF("Customer").forEach(s -> System.out.println(s));
		
		SalesByUser sbu = saleRepo.findSalesByUserByFirst("Customer");
		System.out.println(sbu.getUser().getFirstName() + " " + sbu.getSaleTotal());
		
		
		
		
		return "testpage";		
	}
		
	
	@RequestMapping("/allpagestemp")
	public String temp() {
		return "allpagestemplate";		
	}
	
}
