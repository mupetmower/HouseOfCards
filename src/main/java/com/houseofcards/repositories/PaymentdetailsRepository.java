package com.houseofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houseofcards.entities.generated.Paymentdetails;

public interface PaymentdetailsRepository extends JpaRepository<Paymentdetails, Integer> {

}
