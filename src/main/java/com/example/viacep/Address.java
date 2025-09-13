package com.example.viacep;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
// FIXME import javax.validation.constraints.NotEmpty;

/**
 * The {@code Address} class represents a postal address.
 * 
 * @author marco.mangan@gmail.com
 *
 */
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// FIXME: @NotEmpty
	private String cep;

	// FIXME:@NotEmpty
	private String logradouro;

	private String complemento;
	private String bairro;
	private String localidade;

	// FIXME:@NotEmpty
	private String uf;

	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;

	/**
	 * Creates a new {@code Address} that contains a {@code cep} and postal
	 * information.
	 * 
	 * @param cep
	 * @param logradouro
	 * @param complemento
	 * @param bairro
	 * @param localidade
	 * @param uf
	 */
// FIXME:	public Address(@NotEmpty String cep, @NotEmpty String logradouro, String complemento, String bairro,
//			String localidade, @NotEmpty String uf) {
	public Address( String cep,  String logradouro, String complemento, String bairro,
			String localidade,  String uf) {
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
	protected Address() {
		
	}

	/**
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @return
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * 
	 * @return
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * 
	 * @return
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * 
	 * @return
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * 
	 * @return
	 */
	public String getLocalidade() {
		return localidade;
	}

	/**
	 * 
	 * @return
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * 
	 * @return
	 */
	public String getIbge() {
		return ibge;
	}

	/**
	 * 
	 * @return
	 */
	public String getGia() {
		return gia;
	}

	/**
	 * 
	 * @return
	 */
	public String getDdd() {
		return ddd;
	}

	/**
	 * 
	 * @return
	 */
	public String getSiafi() {
		return siafi;
	}

}
