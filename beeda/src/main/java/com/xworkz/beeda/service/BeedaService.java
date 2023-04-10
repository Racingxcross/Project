package com.xworkz.beeda.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.beeda.dto.BeedaDTO;

public interface BeedaService {
	Set<ConstraintViolation<BeedaDTO>> validateAndSave(BeedaDTO dto);

	default BeedaDTO findById(int id) {
		return null;
	}

	default List<BeedaDTO> findByStallName(String stallName) {
		return Collections.emptyList();
	}

	Set<ConstraintViolation<BeedaDTO>> validateAndUpdate(BeedaDTO dto);

	default boolean validateAndDelete(int id) {
		return true;
	}
 
}
