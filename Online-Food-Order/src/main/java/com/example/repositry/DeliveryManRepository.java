package com.example.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.DeliveryMan;

public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Integer> {
	
}
