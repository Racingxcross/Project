package com.xworkz.beeda.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data

public class BeedaDTO {
	private int id;
	@NotBlank
	@Size(min = 3, max = 20, message = "company cannot be less than 3 or greater than 20")
	private String stallName;
	@NotBlank
	@Size(min = 3, max = 20, message = "company cannot be less than 3 or greater than 20")
	private String ownerName;
	@NotBlank
	private String type;
	@NotNull
	private Double price;
	@NotNull
	private int quantity;

}
