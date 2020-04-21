package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	//public List<Book> findByLibraryId(int id);
	
}
