package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.model.Library;
import com.infy.repository.LibraryRepository;


public interface LibraryService {

	public List<Library> getAllLibrary();
	public Library createLibrary(Library library);
	public Library updateLibrary(int libraryId,Library library);
	public String deletelibrary(int libraryId);
}
