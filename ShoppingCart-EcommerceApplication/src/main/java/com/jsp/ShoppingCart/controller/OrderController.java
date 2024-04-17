package com.jsp.ShoppingCart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.CartDao;
import com.jsp.ShoppingCart.dao.CustomerDao;
import com.jsp.ShoppingCart.dao.OrdersDao;
import com.jsp.ShoppingCart.dao.ProductDao;
import com.jsp.ShoppingCart.dto.Cart;
import com.jsp.ShoppingCart.dto.Customer;
import com.jsp.ShoppingCart.dto.Item;
import com.jsp.ShoppingCart.dto.Orders;
import com.jsp.ShoppingCart.dto.Product;


@Controller
public class OrderController {

	@Autowired
	OrdersDao odao;
	
	@Autowired
	CustomerDao cdao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	CartDao cartdao;
	
	@RequestMapping("/addorder")
	public ModelAndView addOrder() {
		Orders order=new Orders();
		ModelAndView mav=new ModelAndView();
		mav.addObject("ordersobj",order);
		mav.setViewName("ordersform");
		return mav;
	}
	@RequestMapping("/saveorder")
	public ModelAndView saveOrder(@ModelAttribute("ordersobj") Orders o, HttpSession session) {
	
		Customer customer=(Customer) session.getAttribute("customerinfo");
		Customer c=cdao.findcustomerById(customer.getId());
		
		Cart cart=c.getCart();
		
		List<Item> items=cart.getItems();
		
		List<Item>cartitems=new ArrayList<Item>();
		
		List<Item> orderitems=new ArrayList<Item>();
		
		for(Item i:items) {
			Product p=pdao.findProductById(i.getPid());
			if(i.getQuantity()< p.getStock()) {
				orderitems.add(i);
				p.setStock(p.getStock()-i.getQuantity());
				pdao.updateProduct(p);
				
			}
			else {
				cartitems.add(i);
			}
		}
		
		double cartTotalprice=0;
		double orderTotalprice=0;
		
		for(Item i:cartitems) {
			cartTotalprice+=i.getPrice();
		}
		for(Item i:orderitems) {
			orderTotalprice+=i.getPrice();
		}
		cart.setItems(cartitems);
		cart.setTotalprice(cartTotalprice);
		
		o.setItems(orderitems);
		o.setTotalprice(orderTotalprice);
		
		List<Orders>orders=c.getOrders();
		
		if(orders.size()>0) {
			orders.add(o);
			c.setOrders(orders);
		}else {
			List<Orders>orders1=new ArrayList<Orders>();
			orders1.add(o);
			c.setOrders(orders1);
		}
		
		cartdao.updateCart(cart);
		odao.saveOrder(o);
		cdao.updateCustomer(c);
		
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("payoption");
		return mav;
	}
	@RequestMapping("/upi")
	public ModelAndView makeupi() {
		
		
		ModelAndView mav=new ModelAndView();		
		mav.setViewName("upiform");
		return mav;
}
	@RequestMapping("/customerbilldetails")
	public ModelAndView customerBilldetails(HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerinfo");

		Cart cart = customer.getCart();
		List<Item> items = cart.getItems();
		ModelAndView mav=new ModelAndView();
		mav.addObject("itemslist", items);
		mav.addObject("totalprice",cart.getTotalprice());
		mav.addObject("msg","order placed successfully");
		mav.setViewName("customerbill");
		return mav;
}
}
