package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "carts")
@Getter@Setter
public class Cart {
	@Id
	@Column(name = "CartId",columnDefinition = "varchar(9)")
	private String id;
	private String ProductId;
}
