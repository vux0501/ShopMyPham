package app.service;

import java.util.List;

import app.dto.CartDto;
import app.entity.Cart;

public interface CartService {
		Cart save(Cart cart);
		CartDto getOne(String id);
		List<Cart> getAll();
}
