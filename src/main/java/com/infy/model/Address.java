package com.infy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties 
public class Address {
	
	@Id
	@GeneratedValue
	private int addressId;
	private String city;
	private String state;
	
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name= "libraryId")
	private Library library;
	
	public Address() {}
	
	public Address(int addressId,String city,String state) {
		this.addressId = addressId;
		this.city = city;
		this.state = state;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

}
