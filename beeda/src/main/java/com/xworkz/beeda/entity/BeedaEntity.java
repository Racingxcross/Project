package com.xworkz.beeda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "beeda_table")
@NamedQuery(name="findByStallName",query="select x from BeedaEntity x where x.stallName=:stallName ")

public class BeedaEntity {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="stallName")
	private String stallName;
	@Column(name="ownerName")
	private String ownerName;
	@Column(name="type")
	private String type;
	@Column(name="price")
	private Double price;
 	@Column(name="quantity")
	private int quantity;

}
