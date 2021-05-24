package br.com.supera.game.store.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import br.com.supera.game.store.dao.CartDao;
import br.com.supera.game.store.model.Cart;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.User;
import br.com.supera.game.store.repository.CartRepository;
import br.com.supera.game.store.repository.ProductRepository;
import br.com.supera.game.store.repository.UserRepository;

@Controller
public class BuyController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	
	@Autowired
	private UserRepository userRepository;
	
	// Redireciona para a página passada como parâmetro
	public RedirectView redirect(String address) {
		RedirectView rv = new RedirectView();
		rv.setUrl("http://localhost:3000/" + address);	
		return rv;		
	}
	
	
	// Adiciona item ao carrinho
	@RequestMapping(value = "/comprar/{id}", method = RequestMethod.POST)
	@ResponseBody
	public RedirectView addCart(@PathVariable("id") long id, Product product) {
	
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Product p = optional.get();
			CartDao cart = new CartDao();
			cart.addInCart(p);
			return this.redirect("");
		}else {
			return this.redirect("");
		}
	}
	
	// Retorna o valor total do carrinho
	@RequestMapping("/carrinho/total-value")
	@ResponseBody
	public BigDecimal totalCartValue() {
		CartDao cartDao = new CartDao();
		return cartDao.totalProductsPrice();
	}
	
	// Retorna o valor total do frete
	@RequestMapping("/carrinho/total-frete")
	@ResponseBody
	public BigDecimal shippingValue() {
		CartDao cartDao = new CartDao();
		return cartDao.getShippingCost();
	}
	
	
	// Finaliza compra: recebe todos os parametros da request e cria novo usuário, carrinho e limpa List de CartDao
	@RequestMapping(value = "/carrinho/finalizar-compra", method = RequestMethod.POST)
	public RedirectView finishShopping(@RequestParam("name")String name, 
							@RequestParam("cpf") String CPF,
							@RequestParam("address")String Adress,
							@RequestParam("complement") String complement,
							@RequestParam("city") String city,
							@RequestParam("state") String state,
							@RequestParam("creditcardnumber")String creditCardNumber,
							@RequestParam("creditcardexpiry") String creditCardExpiry,
							@RequestParam("creditcardcvv") String creditCardCvv) {
		
		// Concatenando parametros da requisição para salvar no banco de dados de forma padronizada
		String addressString = Adress +" | "+ complement +" | "+ city +" | "+ state;
		String creditCardString = creditCardNumber +" | "+ creditCardExpiry +" | "+ creditCardCvv;
		
		// Criando novo usuário
		User user = new User();
		user.setName(name);
		user.setCpf(CPF);
		user.setAddress(addressString);
		user.setCreditCardNumer(creditCardString);			
		this.userRepository.save(user);		
		
		CartDao cartDao = new CartDao();		
		
		// Para cada produto p na lista de produtos, crie um novo carrinho, set os dados e armazene no banco de dados
		for(Product p : cartDao.getProductsInCart()) {
			Cart cart = new Cart();	
			cart.setUser(user);			
			cart.setProductsInCart(Arrays.asList(p));
			cart.setShippingCost(cartDao.getShippingCost());	
			
			this.cartRepository.save(cart);			
		}
		
		
		List<Product> empty = new ArrayList();		
		cartDao.setProductsInCart(empty);
		cartDao.setShippingCost(BigDecimal.ZERO);	
		
		return this.redirect("");
	}
	
	// Remover item do carrinho
	@RequestMapping(value = "/carrinho/remover/{id}", method = RequestMethod.POST)
	public RedirectView removeCartItem(@PathVariable("id") long id) {
			
		CartDao cartDao = new CartDao();	
		cartDao.removeItem(id);
		return this.redirect("carrinho");
	}
	
	
	
	
}
 