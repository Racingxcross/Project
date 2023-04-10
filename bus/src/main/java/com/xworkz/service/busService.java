package com.xworkz.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.dto.busDTO;

public interface busService {
	Set<ConstraintViolation<busDTO>> validateAndSave(busDTO dto);

}
