package com.infy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(indexName = "library", type= "library")
@Entity
@JsonIgnoreProperties 
public class Book {

	@Id
	@GeneratedValue
	private int bookId;
	private String bookName;
	private String author;
	
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name= "libraryId")
	private Library library;
	
	
	public Book() {
	}

	public Book(int bookId, String bookName,String author) {
		this.bookId= bookId;
		this.bookName = bookName;
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
	
	
}
