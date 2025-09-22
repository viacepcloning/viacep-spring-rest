package com.example.viacep;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@code AddressRestController} retrieves a postal address by zip code.
 * 
 * Zip is a 8-digit string.
 * 
 * @author marco.mangan@gmail.com
 *
 */
@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/addresses")
public class AddressRestController {

	private Logger logger = Logger.getLogger(AddressRestController.class.getCanonicalName());

	private AddressRepository addressRepository;

	@Autowired
	public AddressRestController(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	/**
	 * Gets a postal address by zip code.
	 * 
	 * @param zip an 8-digit string
	 * @return an postal address,
	 *         as HTTP status,
	 *         if zip was found, 200 OK,
	 *         if zip was not found, 404 NOT FOUND,
	 *         if bad request, 500.
	 */
	@GetMapping(value = "/{zip}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> getAddress(final @PathVariable String zip) {

		final Address address = addressRepository.findByCep(zip);
		if (address == null) {
			logger.log(Level.INFO, "getAddress not found.");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		logger.log(Level.INFO, "getAddress ok.");
		return new ResponseEntity<>(address, HttpStatus.OK);
	}
}
