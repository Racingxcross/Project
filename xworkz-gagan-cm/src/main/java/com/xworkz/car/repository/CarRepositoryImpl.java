package com.xworkz.car.repository;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.car.entity.CarEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CarRepositoryImpl implements CarRepository {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public CarRepositoryImpl() {
		log.info("created:" + getClass().getSimpleName());
	}

	@Override
	public boolean save(CarEntity entity) {
		log.info("Running save in CarEntity" + entity);
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			return true;
		} finally {
			manager.close();
		}
	}

	@Override
	public CarEntity userSignIn(String userName) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("user");
			query.setParameter("ui", userName);
			Object object = query.getSingleResult();
			CarEntity entity = (CarEntity) object;
			log.info("Entity" + entity);
			return entity;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public List<CarEntity> findAll() {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("find");
			List<CarEntity> list = query.getResultList();
			log.info("Total list size found in repo" + list.size());
			return list;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Long findByEmail(String email) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("emailId");
			query.setParameter("emailBy", email);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;

		} finally {
			entityManager.close();
		}

	}

	@Override
	public Long findByuserName(String name) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("userName");
			query.setParameter("userBy", name);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;

		} finally {
			entityManager.close();
		}
	}

	@Override
	public Long findByMobile(Long number) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("mobileId");
			query.setParameter("mobileBy", number);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;

		} finally {
			entityManager.close();
		}
	}

	@Override
	public boolean loginCount(String userName, int count) {
		log.info("count:" + count);
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createNamedQuery("updateLoginCount");
			query.setParameter("userName", userName);
			query.setParameter("count", count);
			query.executeUpdate();
			entityTransaction.commit();
			return true;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public CarEntity resetPassword(String emailid) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("emailid");
			query.setParameter("email", emailid);
			Object object = query.getSingleResult();
			CarEntity entity = (CarEntity) object;
			log.info("" + entity);
			return entity;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public boolean update(CarEntity carEntity) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(carEntity);
			entityTransaction.commit();
			return true;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public boolean updatePassword(String userName, String password, Boolean resetPassword,
			LocalTime passwordChangedTime) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createNamedQuery("updatePassword");
			query.setParameter("uu", userName);
			query.setParameter("up", password);
			query.setParameter("urp", resetPassword);
			query.setParameter("pct", passwordChangedTime);
			query.executeUpdate();
			entityTransaction.commit();
			return true;
		} finally {
			entityManager.close();
		}
	}

}
