package com.xworkz.car.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class userDTO {
	private int id;
	@NotBlank
	@Size(min = 4, max = 30, message = "userName should not be less than 4 and greater than 30")
	private String userName;
	@NotBlank
	@Size(min = 4, max = 40, message = "email should be greater then 4 and less then 40")
	private String email;
	@NotNull
	private Long mobile;
	@NotBlank
	@Size(min = 4, max = 12, message = "password should be greater then 4 and less then 12")
	private String password;
	@NotNull
	@NotBlank
	private String confirmPassword;
	@NotNull
	private Boolean agreement;
	private int loginCount;

	private Boolean resetPassword;
}
