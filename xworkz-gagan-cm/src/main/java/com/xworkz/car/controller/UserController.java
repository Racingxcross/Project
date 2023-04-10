package com.xworkz.car.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.car.dto.userDTO;
import com.xworkz.car.service.CarService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class UserController {

	@Autowired
	private CarService carService;

	public UserController() {
		log.info("" + this.getClass().getSimpleName());
	}

	@PostMapping("/Save")
	public String userInfo(userDTO dto, Model model) {
		Set<ConstraintViolation<userDTO>> violations = this.carService.validateandsave(dto);

		if (violations != null && violations.isEmpty() && dto != null) {
			model.addAttribute("message", "Registration sucessfull");
			log.info("" + dto);
			return "SignUp";
		}
		model.addAttribute("errors", violations);
		model.addAttribute("message", "Registration failed");

		return "SignUp";

	}

	@PostMapping("/signin")
	public String userSignIn(String userName, String password, Model model) {
		log.info("" + userName);
		log.info("" + password);
		try {
			userDTO dto = this.carService.userSignIn(userName, password);
			if (dto != null) {
				log.info("userName and password is matched");
				model.addAttribute("userName", dto.getUserName());
				return "loginSuccess";
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		model.addAttribute("match", "userName OR Password is not matching");
		return "SignIn";

	}

	@PostMapping("/reset")
	public String resetPassword(String email, Model model) {
		userDTO dto = this.carService.resetPassword(email);
		if (dto.getResetPassword() == true) {
			model.addAttribute("msg", "Password reset sucessful plz login");
			return "resetpassword";
		}
		return "resetpassword";
	}

	@PostMapping("/passwordUpdate")
	public String updatePassword(String userName, String password, String confirmPassword) {
		this.carService.updatePassword(userName, password, confirmPassword);
		return "success";
	}

}
