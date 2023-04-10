package com.xworkz.beeda.repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.beeda.entity.BeedaEntity;

public interface BeedaRepository {

	boolean save(BeedaEntity entity);

	boolean update(BeedaEntity entity);

	boolean delete(int id);

	default BeedaEntity findById(int id) {
		return null;
	}

	default List<BeedaEntity> findByStallName(String stallName) {
		return Collections.emptyList();
	}

}
