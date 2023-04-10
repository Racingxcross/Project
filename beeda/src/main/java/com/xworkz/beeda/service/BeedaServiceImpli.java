package com.xworkz.beeda.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.beeda.dto.BeedaDTO;
import com.xworkz.beeda.entity.BeedaEntity;
import com.xworkz.beeda.repository.BeedaRepository;
@Service
public class BeedaServiceImpli implements BeedaService {
	@Autowired
	private BeedaRepository repository;

	public BeedaServiceImpli() {
		System.out.println("created:" + getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<BeedaDTO>> validateAndSave(BeedaDTO dto) {
		System.out.println("Running validateAndSave in serviceImpli");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<BeedaDTO>> violations = validator.validate(dto);
		if (violations != null && !violations.isEmpty()) {
			System.err.println("violations in dto");
			return violations;
		} else {
			System.out.println("violations is not there,can save");
			BeedaEntity entity = new BeedaEntity();
			entity.setOwnerName(dto.getOwnerName());
			entity.setId(dto.getId());
			entity.setPrice(dto.getPrice());
			entity.setQuantity(dto.getQuantity());
			entity.setStallName(dto.getStallName());
			entity.setType(dto.getType());
			boolean saved = this.repository.save(entity);
			System.out.println(saved);
			return Collections.emptySet();

		}

	}

	@Override
	public BeedaDTO findById(int id) {
		System.out.println("created  findbyid");
		if (id > 0) {
			BeedaEntity entity = this.repository.findById(id);
			if (entity != null) {
				System.out.println("entity is found in service for id");
				BeedaDTO dto = new BeedaDTO();
				dto.setStallName(entity.getStallName());
				dto.setOwnerName(entity.getOwnerName());
				dto.setType(entity.getType());
				dto.setPrice(entity.getPrice());
				dto.setQuantity(entity.getQuantity());
				dto.setId(entity.getId());
				return dto;
			}
		}

		return BeedaService.super.findById(id);
	}

	@Override
	public List<BeedaDTO> findByStallName(String stallName) {
		System.out.println("created findByStallName ");
		if (stallName != null && !stallName.isEmpty()) {
			List<BeedaEntity> entities = this.repository.findByStallName(stallName);

			List<BeedaDTO> dtos = new ArrayList<BeedaDTO>();

			for (BeedaEntity beedaEntity : entities) {
				BeedaDTO dto = new BeedaDTO();
				dto.setStallName(beedaEntity.getStallName());
				dto.setOwnerName(beedaEntity.getOwnerName());
				dto.setType(beedaEntity.getType());
				dto.setPrice(beedaEntity.getPrice());
				dto.setQuantity(beedaEntity.getQuantity());
				dto.setId(beedaEntity.getId());
				dtos.add(dto);
			}
			System.out.println("size of dtos" + dtos.size());
			System.out.println("size of entities" + entities.size());
			return dtos;

		} else {
			System.err.println("stallName is invalid");
		}

		return BeedaService.super.findByStallName(stallName);
	}

	@Override
	public Set<ConstraintViolation<BeedaDTO>> validateAndUpdate(BeedaDTO dto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<BeedaDTO>> violations = validator.validate(dto);
		if (violations != null && !violations.isEmpty()) {
			System.err.println("violations in dto");
			return violations;
		} else {
			System.out.println("violations is not there,can save");
			BeedaEntity entity = new BeedaEntity();
			entity.setId(dto.getId());
			entity.setPrice(dto.getPrice());
			entity.setQuantity(dto.getQuantity());
			entity.setStallName(dto.getStallName());
			entity.setType(dto.getType());

			boolean saved = this.repository.update(entity);
			System.out.println(saved);
			return Collections.emptySet();

		}
	}

	@Override
	public boolean validateAndDelete(int id) {

		System.out.println("Running validateAndDelete");
		if (id < 0) {
			return false;
		} else {
			boolean deleted = this.repository.delete(id);
			System.out.println("delete" + deleted);
			return deleted;
		}

	}

}
