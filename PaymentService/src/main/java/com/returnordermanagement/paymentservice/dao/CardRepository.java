package com.returnordermanagement.paymentservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.returnordermanagement.paymentservice.model.CreditCard;

public interface CardRepository extends JpaRepository<CreditCard, Long>{

	

	CreditCard findByCardNumber(long cardNumber) ;
    //Call findByCardNumber from card service
	

}