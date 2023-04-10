package com.xworkz.beeda.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.beeda.entity.BeedaEntity;

@Repository
public class BeedaRepositoryImpl implements BeedaRepository {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public BeedaRepositoryImpl() {
		System.out.println("created:" + getClass().getSimpleName());

	}

	@Override
	public boolean save(BeedaEntity entity) {
		System.out.println("Running save in BeedaEntity" + entity);
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public BeedaEntity findById(int id) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		BeedaEntity entity = manager.find(BeedaEntity.class, id);
		manager.close();
		return entity;
	}

	@Override
	public List<BeedaEntity> findByStallName(String stallName) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByStallName");
			query.setParameter("stallName", stallName);
			List<BeedaEntity> list = query.getResultList();
			System.out.println("created findByStallName.. ");
			return list;

		} finally {
			manager.close();
		}

	}

	@Override
	public boolean update(BeedaEntity entity) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(entity);
			transaction.commit();
			return true;
		} finally {
			manager.close();
		}
	}

	@Override
	public boolean delete(int id) {
		System.out.println("Running delete");
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			BeedaEntity delete = entityManager.find(BeedaEntity.class, id);
			transaction.begin();
			entityManager.remove(delete);
			transaction.commit();
			return true;
		} finally {
			entityManager.close();
		}

	}
}
