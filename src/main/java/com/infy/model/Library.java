package com.infy.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "library")
@JsonIgnoreProperties
public class Library  {
	
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int libraryId;
	
	private String libraryName;
	@JsonManagedReference
	@OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
	private Set<Book> books;
	
	public Library() {
		
	}
	
	public Library(int libraryId, String libraryName) {
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		
	}

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
}
