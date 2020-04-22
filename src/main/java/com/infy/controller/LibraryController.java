package com.infy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.exception.NotFoundException;
import com.infy.model.Address;
import com.infy.model.Book;
import com.infy.model.Library;
import com.infy.repository.BookRepository;
import com.infy.repository.LibraryRepository;
import com.infy.service.AddressService;
import com.infy.service.BookService;
import com.infy.service.LibraryService;

@RestController
@RequestMapping("/api")
public class LibraryController {
	@Autowired
	LibraryService libraryService;
	@Autowired
	BookService bookService;
	@Autowired
	AddressService addressService;

	
	@GetMapping(value = "/library")
	public List<Library> getAllLibraries(){
		return libraryService.getAllLibrary();
	}
	
	@PostMapping(value="/library")
    public Library createLibrary(@Valid @RequestBody Library library) {
		System.out.println("******* "+library.getBooks());
        return libraryService.createLibrary(library);
    }
	
	@PutMapping(value="/library/{libraryId}")
	    public Library updateLibrary(@PathVariable int libraryId, @Valid @RequestBody Library libraryUpdated) {
	      return libraryService.updateLibrary(libraryId, libraryUpdated);
	    }
	
	@DeleteMapping(value="/library/{libraryId}")
	    public String deleteLibrary(@PathVariable int libraryId) {
	       return libraryService.deletelibrary(libraryId);
	    }
	
	//-----------------------------Book APIs-------------------------------
	
	
	  @GetMapping(value= "library/{libraryId}/books") 
	  public List<Book> getAllBooks(@PathVariable int libraryId){ 
		  return bookService.getAllBooks(libraryId);
	  }
	 
	
	@PostMapping(value="/library/{libraryId}/books")
	    public Book addBook(@PathVariable int libraryId, @Valid @RequestBody Book bookData) {
	        return bookService.addBook(libraryId, bookData);
	    }
	
	
	@PutMapping(value="/library/{libraryId}/book/{bookId}")
	    public Book updateBook(@PathVariable int libraryId, @PathVariable int bookId , @RequestBody Book bookUpdated) {
		return bookService.updateBook(libraryId, bookId, bookUpdated);
	}
	
	@DeleteMapping(value="/library/{libraryId}/book/{bookId}")
	public String deleteBook (@PathVariable int libraryId, @PathVariable int bookId) {
		return bookService.deleteBook(libraryId, bookId);
	}
	
	//-------------------Inserting library address(City, State)----------------
	
	@PostMapping(value = "/library/{libraryId}")
	public Address insertAddress(@PathVariable int libraryId,@RequestBody Address address ) {
		return addressService.insertAddress(libraryId, address);
	}
}
