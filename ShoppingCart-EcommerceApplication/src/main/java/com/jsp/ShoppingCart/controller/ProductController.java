package com.jsp.ShoppingCart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.MerchantDao;
import com.jsp.ShoppingCart.dao.ProductDao;
import com.jsp.ShoppingCart.dto.Merchant;
import com.jsp.ShoppingCart.dto.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao dao;

	@Autowired
	MerchantDao mdao;

	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {

		Product p = new Product();

		ModelAndView mav = new ModelAndView();
		mav.addObject("productobj", p);
		mav.setViewName("productform");
		return mav;
	}

	@RequestMapping("/saveproduct")
	public ModelAndView saveproduct(@ModelAttribute("productobj") Product p, HttpSession session) {
		Merchant m = (Merchant) session.getAttribute("merchantinfo");
		List<Product> products = m.getProducts();

		if (products.size() > 0) {
			products.add(p);
			m.setProducts(products);
		} else {
			List<Product> products1 = new ArrayList<Product>();
			products1.add(p);
			m.setProducts(products1);
		}

		dao.saveProduct(p);
		mdao.updateMerchant(m);
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "product added successfully");
		mav.setViewName("merchantoption");
		return mav;

	}

	@RequestMapping("/viewallproduct")
	public ModelAndView ViewAllProduct(HttpSession session) {
		Merchant m = (Merchant) session.getAttribute("merchantinfo");
		Merchant merchant = mdao.findmerchantById(m.getId());
		List<Product> product = merchant.getProducts();
		ModelAndView mav = new ModelAndView();
		mav.addObject("productlist", product);
		mav.setViewName("viewallproductmerchant");
		return mav;
	}
 	@RequestMapping("/delete")
	public ModelAndView deleteProduct(@RequestParam("id") int pid, HttpSession session) {
		Merchant merchant = (Merchant) session.getAttribute("merchantinfo");


		Merchant m=dao.removeProductFromMerchant(merchant.getId(), pid);
		mdao.updateMerchant(m);

		dao.deleteProductById(pid);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect://viewallproduct");
		return mav;
	}
 	
 	@RequestMapping("/displayproductsbybrand")
	public ModelAndView displayProductsByBrand(ServletRequest req) {
		String brand = req.getParameter("brand");
		List<Product> products = dao.findProductByBrand(brand);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productslist", products);
		mav.setViewName("viewallproductstocustomer");
		return mav;
	}



	
	@RequestMapping("/fetchallproduct")
	public ModelAndView FetchAllProduct() {
		List<Product> product = dao.fetchAllProducts();
		ModelAndView mav = new ModelAndView();
		mav.addObject("productlist", product);
		mav.setViewName("displayallproduct");
		return mav;
}
	@RequestMapping("/update")
	public ModelAndView updateProduct() {

		Product p = new Product();

		ModelAndView mav = new ModelAndView();
		mav.addObject("productobj", p);
		mav.setViewName("productform");
		return mav;
	}
}
