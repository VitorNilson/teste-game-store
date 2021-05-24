package br.com.supera.game.store.controller;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import br.com.supera.game.store.dao.CartDao;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.repository.CartRepository;
import br.com.supera.game.store.repository.ProductRepository;

@RestController
public class IndexController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	//Retorno de todos os produtos + paginação
	@RequestMapping("/produtos")
	@ResponseBody
	public Page<Product> index(
			
				@RequestParam Optional<Integer> page,
				@RequestParam Optional<String> sortBy
			){
				
		return productRepository.findAll(
						PageRequest.of(
						page.orElse(0), 10,
						Sort.Direction.ASC, sortBy.orElse("id")
						));
	}
	
	//Retorno do carrinho
	@RequestMapping("/produtos/carrinho")
	@ResponseBody
	public List<Product> cart(){
		CartDao cartDao = new CartDao();	
		return cartDao.getProductsInCart();
	}
	
	// Retorna a quantidade de itens no carrinho
	@RequestMapping("/produtos/carrinho/size")
	@ResponseBody
	public Integer size() {
		
		CartDao cartDao = new CartDao();	
		return cartDao.sizeItensInCart();
	}
	
	// Cria um novo produto
//	@RequestMapping(value = "/novo-produto", method = RequestMethod.POST)
//	public RedirectView	 products(@ModelAttribute("name") String name){
//		
//		Product prod = new Product(name);
//		
//		productRepository.save(prod);
//		
//		RedirectView rv = new RedirectView();
//		rv.setUrl("http://localhost:3000/");
//		return rv;
//	}
	
}
