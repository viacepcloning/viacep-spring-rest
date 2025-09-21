package com.example.viacep;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressRepositoryTest {

	@Autowired
	private AddressRepository addressRepository;

	@Test
	public void shouldFindAddressByCep() {
		String cep = "90110170";
		Address address = this.addressRepository.findByCep(cep);
		assertThat(address.getCep()).isEqualTo("90110170");
		assertThat(address.getLogradouro()).isEqualTo("Rua Dezessete de Junho");
	}

}
