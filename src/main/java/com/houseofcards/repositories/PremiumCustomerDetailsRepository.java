package com.houseofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houseofcards.entities.generated.Customercardinventory;
import com.houseofcards.entities.generated.Premiumcustomerdetails;

public interface PremiumCustomerDetailsRepository extends JpaRepository<Premiumcustomerdetails, Integer> {
	
	Customercardinventory findCustomercardinventoryByCustomercardinventories_products_pkProductId(Integer productId);
	
}
