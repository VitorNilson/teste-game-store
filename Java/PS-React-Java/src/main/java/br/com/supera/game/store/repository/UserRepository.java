package br.com.supera.game.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supera.game.store.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}
