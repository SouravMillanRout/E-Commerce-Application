package com.jsp.ShoppingCart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.CartDao;
import com.jsp.ShoppingCart.dao.ItemDao;
import com.jsp.ShoppingCart.dao.ProductDao;
import com.jsp.ShoppingCart.dto.Cart;
import com.jsp.ShoppingCart.dto.Customer;
import com.jsp.ShoppingCart.dto.Item;
import com.jsp.ShoppingCart.dto.Product;

@Controller
public class ItemController {

	@Autowired
	ProductDao pdao;

	@Autowired
	ItemDao idao;

	@Autowired
	CartDao cdao;

	@RequestMapping("/additem")
	public ModelAndView addItem(@RequestParam("id") int id) {
		Product product = pdao.findProductById(id);

		Item item = new Item();
		item.setBrand(product.getBrand());
		item.setCategory(product.getCategory());
		item.setModel(product.getModel());
		item.setPrice(product.getPrice());
		item.setPid(product.getId());

		ModelAndView mav = new ModelAndView();
		mav.addObject("itemobj", item);
		mav.setViewName("itemform");
		return mav;
	}

	@RequestMapping("/additemtocart")
	public ModelAndView addItemToCart(@ModelAttribute("itemobj") Item i, HttpSession session) {
		i.setPrice(i.getQuantity() * i.getPrice());

		Customer customer = (Customer) session.getAttribute("customerinfo");
		Cart cart = customer.getCart();
		cart.setName(customer.getName());

		List<Item> items = cart.getItems();

		if (items.size() > 0) {
			items.add(i);
			cart.setItems(items);
			cart.setTotalprice(cart.getTotalprice()+i.getPrice());
		} else {
			List<Item> items1 = new ArrayList<Item>();
			items1.add(i);

			cart.setTotalprice(i.getPrice());
			cart.setItems(items1);
		}

		idao.saveItem(i);
		cdao.updateCart(cart);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect://fetchallproduct");
		return mav;

	}

}
