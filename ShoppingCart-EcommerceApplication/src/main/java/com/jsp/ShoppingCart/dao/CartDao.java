package com.jsp.ShoppingCart.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoppingCart.dto.Cart;
import com.jsp.ShoppingCart.dto.Customer;
import com.jsp.ShoppingCart.dto.Merchant;
import com.jsp.ShoppingCart.dto.Orders;
import com.jsp.ShoppingCart.dto.Product;

@Repository
public class CartDao {
	@Autowired
	EntityManagerFactory emf;
	
	@Autowired
	CustomerDao cdao;

	public void saveCart(Cart cart) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(cart);
		et.commit();
	}

	public void updateCart(Cart ca) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(ca);
		et.commit();

	}

	public void deleteCartById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Cart ca = em.find(Cart.class, id);
		et.begin();
		em.remove(ca);
		et.commit();

	}

	public Cart findCartById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Cart ca = em.find(Cart.class, id);

		if (ca != null) {
			return ca;

		} else {
			return null;
		}
	}

	public void removeAllItemsFromCart(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Cart ca = em.find(Cart.class, id);
		ca.setItems(null);
		ca.setTotalprice(0);
		et.begin();
		em.remove(ca);
		et.commit();

	}
	public Customer removeItemFromCart(int mid, int oid) {
		Customer c = cdao.findcustomerById(mid);
		List<Orders> orders = c.getOrders();

		List<Orders> orderlist = new ArrayList<Orders>();

		for (Orders o : orders) {
			if (o.getId() != oid) {
				orderlist.add(o);
			}
		}
		c.setOrders(orderlist);
		return c;
	}

	 

}
