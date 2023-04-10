package com.xworkz.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class busDTO {
	@Size(min = 3, max = 20, message = "error")
	private String name;
	@Size(min = 2, max = 15, message = "enter crt company")
	private String busCompany;
	@NotBlank
	private double ticket;

}
