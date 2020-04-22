package com.infy.service;

import java.util.List;

import com.infy.model.Book;

public interface BookService {

	public List<Book> getAllBooks(int libraryId);
	public Book addBook(int libraryId, Book bookUpdated);
	public Book updateBook(int libraryId, int bookId, Book bookUpdated);
	public String deleteBook(int libraryId, int bookId);
}
