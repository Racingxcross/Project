package com.xworkz.car.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.car.dto.userDTO;

public interface CarService {

	Set<ConstraintViolation<userDTO>> validateandsave(userDTO dto);

	default userDTO userSignIn(String userName, String password) {
		return null;
	}

	default List<userDTO> findAll() {
		return Collections.emptyList();
	}

	default Long findByuserName(String name) {
		return null;
	}

	default Long findByEmail(String email) {
		return null;
	}

	default Long findByMobile(Long mobile) {
		return null;
	}

	default Long findByUserName(String user) {
		return null;
	}

	default userDTO resetPassword(String email) {
		return null;
	}

	default userDTO updatePassword(String userName, String password, String confirmPassword) {
		return null;
	}

	default userDTO updateProfile(String userName, String email, Long mobile, String path) {
		return null;
	}

	boolean sendMail(String email, String text);

}
