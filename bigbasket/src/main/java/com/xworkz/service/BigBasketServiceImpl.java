package com.xworkz.service;


import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.Entity.BigBasketEntity;
import com.xworkz.Repository.BigBasketRepos;
import com.xworkz.dto.BigBasketDTO;


@Service
public class BigBasketServiceImpl implements BigBasketService {
	@Autowired
	private BigBasketRepos dao;

	public BigBasketServiceImpl() {
		System.out.println("creating" + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<BigBasketDTO>> validateAndSave(BigBasketDTO dto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<BigBasketDTO>> constraintViolations = validator.validate(dto);
		if (constraintViolations != null && !constraintViolations.isEmpty()) {
			System.err.println("constraintViolations in dto" + dto);
			return constraintViolations;
		} else {
			System.out.println("constraintViolations does not exist data is good" + dto);
			BigBasketEntity entity = new BigBasketEntity();
			entity.setName(dto.getName());
			entity.setAreas(dto.getAreas());
			entity.setCod(dto.getCod());
			entity.setDelivery(dto.getDelivery());
			entity.setEmail(dto.getEmail());
			entity.setItems(dto.getItems());
			entity.setNoOfWorkers(dto.getNoOfWorkers());
			entity.setPassWord(dto.getPassWord());
			entity.setStoreLocation(dto.getStoreLocation());
			entity.setPhoneNumber(dto.getPhoneNumber());
			this.dao.save(entity);
			return Collections.emptySet();
		}
	}
}