package com.houseofcards.controllers;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;

import org.h2.command.dml.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.houseofcards.entities.Tables;
import com.houseofcards.entities.generated.Products;
import com.houseofcards.repositories.SaleRepository;
import com.houseofcards.repositories.UserRepository;
import com.houseofcards.services.GeneratePdfReport;
import com.houseofcards.services.ProductService;
import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping("/new")
	public String newReport(Model model) {
		model.addAttribute("tables", new Tables());
		
		
		return "reportform";
	}
	
	@RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> generateReport(Model model, String[] chkTables) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, IntrospectionException {
		
		
		
		ByteArrayInputStream bis = GeneratePdfReport.productReport(productService.listAll());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}
	
	
	
}
