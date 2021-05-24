package br.com.supera.game.store.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.supera.game.store.model.Cart;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.User;
import br.com.supera.game.store.repository.CartRepository;
import br.com.supera.game.store.repository.ProductRepository;

public class CartDao {

	@Autowired
	private CartRepository cartRepository;
	

	@Autowired
	private ProductRepository productRepository;
	

	private Long id;
	private User user;
	private static List<Product> productsInCart = new ArrayList();
	private static BigDecimal shippingCost = BigDecimal.ZERO;
	private static BigDecimal totalProductsCost = BigDecimal.ZERO;

	private BigDecimal freeShipingPrice = new BigDecimal("250.00");
	private BigDecimal shippingBaseCost = new BigDecimal("10.00");
	
	
	
	
	// Adiciona produtos ao carrinho
	public void addInCart(Product p) {
		
		CartDao.productsInCart.add(p);		
		CartDao.totalProductsCost.add(p.getPrice());
		
		// Frete Grátis acima de R$ 250.00
		if(((totalProductsPrice().compareTo(freeShipingPrice)) >= 1)) {			
			CartDao.shippingCost = BigDecimal.ZERO;
		}else if (((totalProductsPrice().compareTo(freeShipingPrice)) < 1)){			
			CartDao.shippingCost = CartDao.shippingCost.add(shippingBaseCost);
		}	
	}

	public static BigDecimal totalProductsPrice() {		
		BigDecimal total = BigDecimal.ZERO;		
			for(Product p : getProductsInCart()) {
				total = total.add(p.getPrice());
			} 		
		return total;
	}
	
	// Retorna a quantidade de itens no carrinho
	public Integer sizeItensInCart() {
		return CartDao.productsInCart.size();
	}

	// Busca item dentro do carrinho por ID
	public boolean findById(long id, List<Product> listOfProducts) {		
		for(Product p : listOfProducts) {
			if(p.getId() == id) {
				return true;
			}}
		return false;		
	}
	
	// Remove item do carrinho por ID
	public void removeItem(long id) {
				
		for(Iterator<Product> i = productsInCart.iterator(); i.hasNext(); ) {
				Product p = i.next();			
				if(p.getId() == id) {
					i.remove();
					shippingCost = shippingCost.subtract(shippingBaseCost);
				}				
		}

		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static List<Product> getProductsInCart() {
		return productsInCart;
	}

	public static void setProductsInCart(List<Product> productsInCart) {
		CartDao.productsInCart = productsInCart;
	}

	public Long getId() {
		return id;
	}

	public static BigDecimal getShippingCost() {
		return shippingCost;
	}

	public static void setShippingCost(BigDecimal shippingCost) {
		CartDao.shippingCost = shippingCost;
	}

	public static BigDecimal getTotalProductsCost() {
		return totalProductsCost;
	}

	public static void setTotalProductsCost(BigDecimal total) {
		totalProductsCost = total;
	}
	
	
	
	
}
