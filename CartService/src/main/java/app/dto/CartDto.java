package app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartDto {
	private String id;
	private ProductDto product;
}
