package com.xworkz.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.dto.BigBasketDTO;

public interface BigBasketService {
	Set<ConstraintViolation<BigBasketDTO>> validateAndSave(BigBasketDTO dto);

}
