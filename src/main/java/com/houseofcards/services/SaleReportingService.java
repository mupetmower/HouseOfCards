package com.houseofcards.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.houseofcards.repositories.SaleRepository;

@Service
public class SaleReportingService {
	
	@Autowired
	private SaleRepository saleRepo;
	
	
	public void saleByUser() {
		
	}
	
	
}
