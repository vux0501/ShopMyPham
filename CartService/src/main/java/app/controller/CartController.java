package app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import app.dto.CartDto;

import app.entity.Cart;
import app.service.CartService;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CartController {
	@Autowired
	private CartService service;
	
	
	
	@PostMapping("/cart")
	public Cart addCart(@RequestBody Cart cart) {
		return service.save(cart);
	}
	@GetMapping("/cart")
	public List<Cart> getAll(){
		return service.getAll();
	}
	@GetMapping("cart/{id}")
	@Retry(name = "product")
	public CartDto getOne(@PathVariable String id) {
		
					
		return service.getOne(id);
	}
}