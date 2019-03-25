package com.dt13.dao;

import java.util.List;

import com.dt13.model.Product;

public interface ProductDao {
void addProduct(Product product);
List<Product> getProducts();
Product getProduct(int productId);
void testSessionFactory();
}
