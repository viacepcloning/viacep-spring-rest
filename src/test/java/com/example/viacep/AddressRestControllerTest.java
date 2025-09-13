package com.example.viacep;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

/**
 * 
 * @author marco.mangan@gmail.com
 *
 */
@WebMvcTest(controllers = AddressRestController.class)
public class AddressRestControllerTest {

	@MockitoBean
	private AddressRepository addressRepository;

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testGetAddressSuccess() throws Exception {
        Address address = new Address("90020004", "Rua dos Andradas", "de 0664 a 0834 - lado par",
        		"Centro Histórico", "Porto Alegre", "RS");
 
        when(this.addressRepository.findByCep("90020004")).thenReturn(address);
        this.mockMvc.perform(get("/api/addresses/90020004")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.cep").value("90020004"))
            .andExpect(jsonPath("$.logradouro").value("Rua dos Andradas"));   
    }

    @Test
    public void testGetAddressNotFound() throws Exception {
        when(this.addressRepository.findByCep("90020001")).thenReturn(null);
        this.mockMvc.perform(get("/api/addresses/90020001")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }
    
}
