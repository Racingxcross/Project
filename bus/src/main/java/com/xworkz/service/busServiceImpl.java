package com.xworkz.service;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.mysql.cj.xdevapi.Schema.Validation;
import com.xworkz.dto.busDTO;

@Service
public class busServiceImpl implements busService {
	public busServiceImpl() {
		System.out.println("created service...");
	}

	@Override
	public Set<ConstraintViolation<busDTO>> validateAndSave(busDTO dto) {
		System.out.println("running validate and save");
		ValidatorFactory factory = javax.validation.Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<busDTO>> violation = validator.validate(dto);
		if (violation != null && !violation.isEmpty()) {
			System.out.println("violation exist...");
			return violation;
		}

		else {
			System.out.println("there is no violations.....");
			return new HashSet<ConstraintViolation<busDTO>>();
		}

	}

}
