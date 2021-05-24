package br.com.supera.game.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supera.game.store.model.Cart;
import br.com.supera.game.store.model.Product;

public interface CartRepository extends JpaRepository<Cart, Long>{}
