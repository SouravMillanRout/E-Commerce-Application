package com.jsp.ShoppingCart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoppingCart.dto.Orders;

@Repository
public class OrdersDao {
	@Autowired
	EntityManagerFactory emf;

	public void saveOrder(Orders order) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(order);
		et.commit();
	}

	public void updateOrder(Orders o) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(o);
		et.commit();

	}

	public void deleteOrderById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Orders o = em.find(Orders.class, id);
		et.begin();
		em.remove(o);
		et.commit();

	}

	public Orders findOrderById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Orders o = em.find(Orders.class, id);

		if (o != null) {
			return o;

		} else {
			return null;
		}
	}

}
