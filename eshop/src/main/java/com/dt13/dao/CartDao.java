package com.dt13.dao;

import java.util.List;

import com.dt13.model.Cart;

public interface CartDao
{
boolean addToCart(Cart c);
List<Cart> getAllCartItems();
}
