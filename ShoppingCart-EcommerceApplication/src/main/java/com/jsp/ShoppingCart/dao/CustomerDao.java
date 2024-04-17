package com.jsp.ShoppingCart.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoppingCart.dto.Customer;
import com.jsp.ShoppingCart.dto.Item;
import com.jsp.ShoppingCart.dto.Merchant;
import com.jsp.ShoppingCart.dto.Orders;
import com.jsp.ShoppingCart.dto.Product;


@Repository
public class CustomerDao {
	@Autowired
	EntityManagerFactory emf;

	public void saveCustomer(Customer customer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(customer);
		et.commit();
	}

	public Customer findCustomerByEmailAndPassword(String email, String password) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select c from Customer c where c.email=?1 and c.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		try {
			Customer customer = (Customer) query.getSingleResult();
			return customer;
		} catch (NoResultException e) {
			return null;
		}
	}

	public void updateCustomer(Customer c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(c);
		et.commit();
	}

	public void deleteCustomerById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Customer c = em.find(Customer.class, id);
		et.begin();
		em.remove(c);
		et.commit();

	}

	public Customer findcustomerById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Customer c = em.find(Customer.class, id);

		if (c != null) {
			return c;

		} else {
			return null;
		}
	}
	public Customer deleteItemFromCart(int customer_id, int order_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Customer customer = em.find(Customer.class, customer_id);
		List<Orders> orders = customer.getOrders();

		List<Orders> ordersList = new ArrayList<>();

		for (Orders o : orders) {
			
			if (o.getId() != order_id)
				ordersList.add(o);
		}

		customer.setOrders(ordersList);
		

		return customer;

	}
}
