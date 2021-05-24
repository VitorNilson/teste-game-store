package br.com.supera.game.store.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "cart")
public class Cart {



	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	
	@ManyToOne(cascade =CascadeType.PERSIST)
	@JoinColumn(name = "id_user")
	private User user;
	
	@ManyToMany
	@Column(name = "product_in_cart")
	private List<Product> productsInCart;
	
	private BigDecimal shippingCost;
	
	
	
	public Cart() {
		
	}
	
	public Cart(User user, Product product, BigDecimal shippingCost) {
		this.user = user;
		this.productsInCart = Arrays.asList(product);
		this.shippingCost = shippingCost;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public BigDecimal getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(BigDecimal shippingCost) {
		this.shippingCost = shippingCost;
	}

	public List<Product> getProductsInCart() {
		return productsInCart;
	}

	public void setProductsInCart(List<Product> productsInCart) {
		this.productsInCart = productsInCart;
	}

	public Long getId() {
		return id;
	}


	
	

	

	
}
