package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.model.Address;

public interface AddressReository extends JpaRepository<Address, Integer> {

}
