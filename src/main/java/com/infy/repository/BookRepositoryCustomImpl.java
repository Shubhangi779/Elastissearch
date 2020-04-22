package com.infy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.infy.model.Book;

public class BookRepositoryCustomImpl implements BookRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByLibraryId(int id) {
		return this.entityManager.createQuery("select b.bookName from Book b, Library l where  l.libraryId = "+id).getResultList();
	}

}
