package com.xworkz.bike.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data

public class bikeDTO {
	private int id;
	@NotBlank
	@Size(min = 3, max = 25, message = "name cannot be less than 3 or greater than 20")
	private String name;
	@NotNull
	private int cc;
	@NotNull
	private double price;
	@NotNull
	private double topSpeed;

}
