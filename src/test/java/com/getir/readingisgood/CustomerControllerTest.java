package com.getir.readingisgood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.getir.readingisgood.controllers.CustomerController;
import com.getir.readingisgood.data.CustomerRepository;
import com.getir.readingisgood.modal.Customer;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	CustomerRepository customerRepository;
	
	Customer customer1 = new Customer("test", "test", "test@getir.com", "5551112233", "just address");
	Customer customer2 = new Customer("test 2", "test 2", "test2@getir.com", "5551112244", "just another address");
	
	@Test
	public void addCustomer() throws Exception {
		List<Customer> customers = new ArrayList<>(Arrays.asList(customer1,customer2));
		Customer customer = new Customer("test3", "test3", "test3@getir.com", "5551112255", "just address 3");
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/add")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(customer));
		
		mockMvc.perform(mockRequest)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", notNullValue()))
        .andExpect(jsonPath("$.firstName", is("test3")));
	}
}
