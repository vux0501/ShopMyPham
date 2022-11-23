package app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Product;
import app.repository.ProductRepository;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repo;
	@Override
	public Product getProductById(String id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	@Override
	public void deleteProductById(String id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
	}

	@Override
	public Product updateProduct(Product product) {
		return repo.save(product);
	}
	




}
