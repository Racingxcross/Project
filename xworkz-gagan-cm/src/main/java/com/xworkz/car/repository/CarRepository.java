package com.xworkz.car.repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.car.entity.CarEntity;

public interface CarRepository {

	boolean save(CarEntity entity);

	default List<CarEntity> findAll() {
		return Collections.emptyList();
	}

	default CarEntity userSignIn(String userName) {
		return null;
	}

	default Long findByuserName(String name) {
		return null;
	}

	default Long findByEmail(String email) {
		return null;
	}

	default Long findByMobile(Long number) {
		return null;
	}

	default CarEntity resetPassword(String emailid) {
		return null;
	}

	boolean update(CarEntity carEntity);

	boolean updatePassword(String userName, String password, Boolean resetPassword);

	boolean loginCount(String userName, int count);

}
