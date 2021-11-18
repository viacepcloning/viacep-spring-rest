package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
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
