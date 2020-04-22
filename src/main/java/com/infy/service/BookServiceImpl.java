package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.exception.NotFoundException;
import com.infy.model.Book;
import com.infy.repository.BookRepository;
import com.infy.repository.LibraryRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	LibraryRepository libraryRepository;

	@Autowired
	BookRepository  bookRepository;

        public List<Book> getAllBooks(int libraryId){
		
		if(!libraryRepository.existsById(libraryId)) throw new
		NotFoundException("Library Not Found!");
		return bookRepository.findByLibraryId(libraryId); 
		}

	@Override
	public Book addBook(int libraryId, Book bookUpdated) {

		return libraryRepository.findById(libraryId).map(library -> {
			bookUpdated.setLibrary(library);
			return bookRepository.save(bookUpdated);
		}).orElseThrow(() -> new NotFoundException("Library not found!"));
	}

	@Override
	public Book updateBook(int libraryId, int bookId, Book bookUpdated) {
		if(!libraryRepository.existsById(libraryId))
			throw new NotFoundException("Library not found!");
		return bookRepository.findById(bookId).map(book->{
			book.setBookName(bookUpdated.getBookName());
			book.setAuthor(bookUpdated.getAuthor());
			return bookRepository.save(book);
		}).orElseThrow(()->new NotFoundException("Book not found"));
	}

	@Override
	public String deleteBook(int libraryId, int bookId) {
		if(!libraryRepository.existsById(libraryId))
			throw new NotFoundException("Library not found ");
		return bookRepository.findById(bookId).map(book->{
			bookRepository.delete(book);
			return "Book Deleted successfully";
		}).orElseThrow(()->new NotFoundException("Book not Found"));
	}

}
