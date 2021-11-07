package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * Class {code}Address{code} is a postal address.
 * 
 * @author marco.mangan@gmail.com
 *
 */
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(unique=true)
    @NotEmpty
	String cep;
	
    @NotEmpty
	String logradouro;

    String complemento;
	String bairro;
	String localidade;
	
    @NotEmpty
	String uf;
	
	String ibge;
	String gia;
	String ddd;
	String siafi;
	
	/**
	 * 
	 * @param cep
	 * @param logradouro
	 * @param complemento
	 * @param bairro
	 * @param localidade
	 * @param uf
	 */
	public Address(@NotEmpty String cep, @NotEmpty String logradouro, String complemento, String bairro,
			String localidade, @NotEmpty String uf) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}
	
	/**
	 * 
	 */
	protected Address() {}

	public Long getId() {
		return id;
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getUf() {
		return uf;
	}

	public String getIbge() {
		return ibge;
	}

	public String getGia() {
		return gia;
	}

	public String getDdd() {
		return ddd;
	}

	public String getSiafi() {
		return siafi;
	}
		
}
