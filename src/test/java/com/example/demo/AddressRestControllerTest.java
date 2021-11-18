package com.example.demo;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 
 * @author marco.mangan@gmail.com
 *
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = ApplicationTestConfig.class)
@WebAppConfiguration
public class AddressRestControllerTest {

	@Autowired
	private AddressRestController addressRestController;

	@MockBean
	private AddressRepository addressRepository;

    private MockMvc mockMvc;
    
    private Address address;

    @Before
    public void initOwners() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(addressRestController)
             //   .setControllerAdvice(new ExceptionControllerAdvice())
        		.build();
        address = new Address("90020004", "Rua dos Andradas", "de 0664 a 0834 - lado par",
        		"Centro Histórico", "Porto Alegre", "RS");
    
    }
    
    @Test
    public void testGetAddressSuccess() throws Exception {
        given(this.addressRepository.findByCep("90020004")).willReturn(address);
        this.mockMvc.perform(get("/api/addresses/90020004")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.cep").value("90020004"))
            .andExpect(jsonPath("$.logradouro").value("Rua dos Andradas"));   
    }

    @Test
    public void testGetAddressNotFound() throws Exception {
        given(this.addressRepository.findByCep("90020001")).willReturn(null);
        this.mockMvc.perform(get("/api/addresses/90020001")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }
    
}
