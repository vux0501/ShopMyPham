package app.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import app.dto.CartDto;
import app.dto.ProductDto;
import app.entity.Cart;
import app.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Cart save(Cart cart) {
		return repo.save(cart);
	}

	@Override
	public CartDto getOne(String id) {
		
		HttpHeaders headers = new HttpHeaders();
		
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		Cart cart = repo.findById(id).get();
		String productId = cart.getProductId();
		ProductDto productDto = restTemplate.exchange("http://localhost:4000/product".concat("/").concat(productId), 
				 HttpMethod.GET, 
				 entity, 
				 ProductDto.class
				).getBody();
		CartDto carts = CartDto.builder()
			.id(cart.getId())
			.product(productDto).build();
		return carts;
	}

	@Override
	public List<Cart> getAll() {
		return repo.findAll();
	}

}
