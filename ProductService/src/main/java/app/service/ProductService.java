package app.service;

import java.util.List;

import org.springframework.stereotype.Service;


import app.entity.Product;

@Service
public interface ProductService {
	Product getProductById(String id);
	void deleteProductById(String id);
	List<Product> getAllProduct();
	Product addProduct(Product product);
	Product updateProduct(Product product);
	
}
