package com.xworkz.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.dto.CmDTO;

public interface CmService {
	Set<ConstraintViolation<CmDTO>> validateAndSave(CmDTO dto);
}
