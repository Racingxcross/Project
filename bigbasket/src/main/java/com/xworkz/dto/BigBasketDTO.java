package com.xworkz.dto;

import javax.validation.constraints.Size;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class BigBasketDTO {
	@Size(min = 3, max = 20, message = "BigBasket name should be more than 3 and less than 20")
	private String name;
	private Double phoneNumber;
		private String email;
	private Double noOfWorkers;
	private Boolean cod;
	private Boolean delivery;
	@Size(min = 8, max = 8, message = "BigBasket password should be more than 3 and less than 20")
	private String passWord;
	@Size(min = 3, max = 20, message = "BigBasket storelocation should be more than 3 and less than 20")
	private String storeLocation;
	@NotBlank(message = "area should be selectd")
	private String areas;
	@NotBlank(message = "items should be selectd")
	private String items;

	public BigBasketDTO() {
		System.out.println("created"+this.getClass().getSimpleName());
	}

	public BigBasketDTO(
			@Size(min = 3, max = 20, message = "BigBasket name should be more than 3 and less than 20") String name,
			Double phoneNumber, String email, Double noOfWorkers, Boolean cod, Boolean delivery,
			@Size(min = 8, max = 8, message = "BigBasket password should be more than 3 and less than 20") String passWord,
			@Size(min = 3, max = 20, message = "BigBasket storelocation should be more than 3 and less than 20") String storeLocation,
			@NotBlank(message = "area should be selectd") String areas,
			@NotBlank(message = "items should be selectd") String items) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.noOfWorkers = noOfWorkers;
		this.cod = cod;
		this.delivery = delivery;
		this.passWord = passWord;
		this.storeLocation = storeLocation;
		this.areas = areas;
		this.items = items;
	}

	@Override
	public String toString() {
		return "BigBasketDTO [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", noOfWorkers="
				+ noOfWorkers + ", cod=" + cod + ", delivery=" + delivery + ", passWord=" + passWord
				+ ", storeLocation=" + storeLocation + ", areas=" + areas + ", items=" + items + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getNoOfWorkers() {
		return noOfWorkers;
	}

	public void setNoOfWorkers(Double noOfWorkers) {
		this.noOfWorkers = noOfWorkers;
	}

	public Boolean getCod() {
		return cod;
	}

	public void setCod(Boolean cod) {
		this.cod = cod;
	}

	public Boolean getDelivery() {
		return delivery;
	}

	public void setDelivery(Boolean delivery) {
		this.delivery = delivery;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}

	public String getAreas() {
		return areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}
	
}