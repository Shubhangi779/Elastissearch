package com.infy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer>{

	//public Library findLibraryById(int id);

}
