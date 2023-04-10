package com.xworkz.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "big_basket_table")
public class BigBasketEntity {
	@Id
	@Column(name = "B_id")
	private int id;
	@Column(name = "B_Name")
	private String name;
	@Column(name = "B_Phone_Number")
	private Double phoneNumber;
	@Column(name = "B_Email")
	private String email;
	@Column(name = "B_Noofworkers")
	private Double noOfWorkers;
	@Column(name = "B_Cod")
	private Boolean cod;
	@Column(name = "B_Delivery")
	private Boolean delivery;
	@Column(name = "B_Password")
	private String passWord;
	@Column(name = "B_StoreLocation")
	private String storeLocation;
	@Column(name = "B_Area")
	private String areas;
	@Column(name = "B_Item")
	private String items;
	public BigBasketEntity() {
		super();
		
	}
	@Override
	public String toString() {
		return "BigBasketEntity [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", noOfWorkers=" + noOfWorkers + ", cod=" + cod + ", delivery=" + delivery + ", passWord=" + passWord
				+ ", storeLocation=" + storeLocation + ", areas=" + areas + ", items=" + items + "]";
	}
	public BigBasketEntity(int id, String name, Double phoneNumber, String email, Double noOfWorkers, Boolean cod,
			Boolean delivery, String passWord, String storeLocation, String areas, String items) {
		super();
		this.id = id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
