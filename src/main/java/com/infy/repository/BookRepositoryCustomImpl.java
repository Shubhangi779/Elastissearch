package com.infy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infy.model.Book;

@PersistenceContext	
public class BookRepositoryCustomImpl implements BookRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Book> findByLibraryId(int id) {
		return null;
	}

}
