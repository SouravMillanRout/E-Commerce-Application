package com.jsp.ShoppingCart.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.CartDao;
import com.jsp.ShoppingCart.dao.CustomerDao;
import com.jsp.ShoppingCart.dto.Cart;
import com.jsp.ShoppingCart.dto.Customer;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao cdao;
	@Autowired
	CartDao cartdao;

	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer() {

		Customer customer = new Customer();

		ModelAndView mav = new ModelAndView();
		mav.addObject("customerobj", customer);
		mav.setViewName("customerform");
		return mav;
	}

	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj") Customer customer) {
		Cart cart=new Cart();
		customer.setCart(cart);
		
		cartdao.saveCart(cart);
		cdao.saveCustomer(customer);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "registered successfully");
		mav.setViewName("customerloginform");
		return mav;

	}

	@RequestMapping("/validatecustomer")
	public ModelAndView login(ServletRequest req, HttpSession session) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Customer customer = cdao.findCustomerByEmailAndPassword(email, password);
		if (customer != null) {
			ModelAndView mav = new ModelAndView();
			session.setAttribute("customerinfo", customer);
			mav.setViewName("customeroption");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("msg", "invalid credetials");
			mav.setViewName("customerloginform");
			return mav;
		}

	}
	}


