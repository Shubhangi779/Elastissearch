package com.infy.repository;

import java.util.List;

import com.infy.model.Book;

public interface BookRepositoryCustom {

	public List<Book> findByLibraryId(int id);
}
