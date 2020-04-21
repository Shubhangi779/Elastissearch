package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.exception.NotFoundException;
import com.infy.model.Library;
import com.infy.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public List<Library> getAllLibrary() {
		return libraryRepository.findAll() ;
	}

	@Override
	public Library createLibrary(Library library) {
		return libraryRepository.save(library);
	}

	@Override
	public Library updateLibrary(int libraryId,Library libraryUpdated) {
		
		return libraryRepository.findById(libraryId).map(library -> {
        	library.setLibraryName(libraryUpdated.getLibraryName());
            return libraryRepository.save(library);
        }).orElseThrow(() -> new NotFoundException("Library not found with id " + libraryId ));
	}

	@Override
	public String deletelibrary(int libraryId) {
		
		 return libraryRepository.findById(libraryId).map(library -> {
         	libraryRepository.delete(library);
             return "Delete Successfully!";
         }).orElseThrow(() -> new NotFoundException("Library not found with id " + libraryId));
	}

}
