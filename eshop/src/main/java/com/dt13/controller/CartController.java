package com.dt13.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dt13.dao.CartDao;
import com.dt13.dao.ProductDao;
import com.dt13.model.Cart;
import com.dt13.model.Product;

@Controller
public class CartController {

	@Autowired
	CartDao cartDao;
	@Autowired
	ProductDao pdao;
	
	
	@RequestMapping("cart")
	public ModelAndView goCart(@RequestParam("proId") int productId , HttpSession session )
	{
		Product product=pdao.getProduct(productId);
		Cart c=new Cart();
		String loginUser=(String)session.getAttribute("uname");
		c.setCartId((int)(Math.random()*10000));
		c.setProductName(product.getProductName());
		c.setProductPrice(product.getProductPrice());
		c.setTotalPrice(1*product.getProductPrice());
		c.setCartUser(loginUser);
		c.setQuantity(1);
		cartDao.addToCart(c);
	List<Cart> cartList =	cartDao.getAllCartItems();
		ModelAndView  mv=new ModelAndView("cart");
		mv.addObject("cartList",cartList);
		
		return mv;
	}
	
	
}
