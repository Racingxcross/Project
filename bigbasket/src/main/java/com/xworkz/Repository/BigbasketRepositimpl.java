package com.xworkz.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.Entity.BigBasketEntity;

@Repository
public class BigbasketRepositimpl implements BigBasketRepos {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public BigbasketRepositimpl() {
		System.out.println("creating" + this.getClass().getSimpleName());
	}
	@Override
	public boolean save(BigBasketEntity entity) {

		System.out.println("running save in dao");
		EntityManager em = this.entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(entity);
		et.commit();
		em.close();

		return false;
	}
}
