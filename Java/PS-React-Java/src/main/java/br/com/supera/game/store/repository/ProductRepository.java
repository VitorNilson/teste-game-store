package br.com.supera.game.store.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.supera.game.store.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	public Page<Product> findByName(String name, Pageable pageable);
	public List<Product> findAll();
	
}
