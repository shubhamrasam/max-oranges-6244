package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	// shubham rasam
	
	
}
