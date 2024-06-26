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

import com.jsp.ShoppingCart.dto.Merchant;
import com.jsp.ShoppingCart.dto.Product;

@Repository
public class ProductDao {
	@Autowired
	EntityManagerFactory emf;

	@Autowired
	MerchantDao mdao;

	public void saveProduct(Product product) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(product);
		et.commit();
	}

	public void updateProduct(Product p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(p);
		et.commit();

	}

	public void deleteProductById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Product p = em.find(Product.class, id);
		et.begin();
		em.remove(p);
		et.commit();

	}

	public Product findProductById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Product p = em.find(Product.class, id);

		if (p != null) {
			return p;

		} else {
			return null;
		}
	}

	public List<Product> fetchAllProducts() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p");
		return query.getResultList();
	}

	public List<Product> findProductByBrand(String brand) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p where p.brand=?1");
		query.setParameter(1, brand);
		try {
			Product product = (Product) query.getResultList();
			return (List<Product>) product;
		} catch (NoResultException e) {
			return null;
		}

	}

	public Merchant removeProductFromMerchant(int mid, int pid) {
		Merchant m = mdao.findmerchantById(mid);
		List<Product> products = m.getProducts();

		List<Product> productlist = new ArrayList<Product>();

		for (Product p : products) {
			if (p.getId() != pid) {
				productlist.add(p);
			}
		}
		m.setProducts(productlist);
		return m;
	}

}
