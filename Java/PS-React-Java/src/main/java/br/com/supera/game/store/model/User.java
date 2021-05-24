package br.com.supera.game.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String cpf;
	private String address;
	private String creditCardNumer;
	
	public User() {
		
	}
	
	public User(String name, String cpf, String address, String creditCardNumber) {
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.creditCardNumer = creditCardNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreditCardNumer() {
		return creditCardNumer;
	}

	public void setCreditCardNumer(String creditCardNumer) {
		this.creditCardNumer = creditCardNumer;
	}

	public Long getId() {
		return id;
	}
	
	
}
