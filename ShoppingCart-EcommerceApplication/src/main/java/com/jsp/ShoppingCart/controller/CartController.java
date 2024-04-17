package com.jsp.ShoppingCart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.CartDao;
import com.jsp.ShoppingCart.dao.CustomerDao;
import com.jsp.ShoppingCart.dao.OrdersDao;
import com.jsp.ShoppingCart.dao.ProductDao;
import com.jsp.ShoppingCart.dto.Cart;
import com.jsp.ShoppingCart.dto.Customer;
import com.jsp.ShoppingCart.dto.Item;
import com.jsp.ShoppingCart.dto.Merchant;

@Controller
public class CartController {
	
	@Autowired
	CartDao cadao;
	
	@Autowired
	CustomerDao cdao;

	@RequestMapping("/viewitemsfromcart")
	public ModelAndView viewItemsFromCart(HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerinfo");

		Cart cart = customer.getCart();
		List<Item> items = cart.getItems();

		ModelAndView mav = new ModelAndView();
		mav.addObject("itemslist", items);
		mav.addObject("totalprice",cart.getTotalprice());
		mav.setViewName("displayallitemsfromcart");
		return mav;
	}
	@RequestMapping("/deleteitem")
	public ModelAndView deleteItemFromCart(@RequestParam("id") int iid, HttpSession session) {
		Customer customer=(Customer) session.getAttribute("customerinfo");
		Customer c=cadao.removeItemFromCart(customer.getId(), iid);
		cdao.updateCustomer(c);

		cadao.deleteCartById(iid);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect://viewitemsfromcart");
		return mav;
	}
	
}
