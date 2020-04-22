package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.exception.NotFoundException;
import com.infy.model.Address;
import com.infy.repository.AddressReository;
import com.infy.repository.LibraryRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	LibraryRepository libraryRepository;
	@Autowired
	AddressReository addressRepository;
	
	@Override
	public Address insertAddress(int libraryId, Address addressData) {
		
		return libraryRepository.findById(libraryId).map(library -> {
			addressData.setLibrary(library);
			return addressRepository.save(addressData);
		}).orElseThrow(() -> new NotFoundException("Library not found!"));
		
	}

}
