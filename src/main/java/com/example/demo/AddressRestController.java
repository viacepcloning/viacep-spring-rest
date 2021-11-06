package com.example.demo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController retrieves a postal address by zip code.
 * 
 * Zip is a 8-digit string. 
 * 
 * @author marco.mangan@gmail.com
 *
 */
@RestController
@RequestMapping("/api/addresses")
public class AddressRestController {

	private Logger logger = Logger.getLogger(AddressRestController.class.getCanonicalName());
	
	@Autowired
	private AddressRepository addressRepository;

	/**
	 * Gets a postal address by zip code.
	 * 
	 * @param zip an 8-digit string
	 * @return an postal address, 
	 * 			as HTTP status,
	 * 			if zip was found, 200 OK, 
	 * 			if zip was not found, 404 NOT FOUND,
	 * 			if bad request, 500.
	 */
	@RequestMapping(value = "/{zip}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Address> getAddress(final @PathVariable String zip) {
		logger.info(String.format("getAddress on: [%s]", zip));
		final Address address = addressRepository.findByCep(zip);
		if (address == null) {
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}
}
