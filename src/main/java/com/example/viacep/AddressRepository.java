package com.example.viacep;

import org.springframework.data.repository.Repository;

/**
 * Interface {@code AddressRepository} is a repository to retrieve postal addresses by zip code.
 * 
 * @author marco.mangan@gmail.com
 *
 */
public interface AddressRepository extends Repository<Address, Long> {
	Address findByCep(String cep);
	void save(Address address);
}
