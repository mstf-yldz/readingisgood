package com.getir.readingisgood;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.getir.readingisgood.data.OrderRepository;
import com.getir.readingisgood.modal.Author;
import com.getir.readingisgood.modal.Book;
import com.getir.readingisgood.modal.Customer;
import com.getir.readingisgood.modal.Order;
import com.getir.readingisgood.modal.OrderBookCount;
import com.getir.readingisgood.modal.Publisher;

@SpringBootTest
@AutoConfigureMockMvc(addFilters=false)
public class OrderControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	OrderRepository orderRepository;
	
	@Test
	public void addOrder() throws Exception{
		Customer customer1 = new Customer("test", "test", "test@getir.com", "5551112233", "just address");
		OrderBookCount orderBookCount = new OrderBookCount(1, new Book("test", new Author("yazar", "siler"), new Publisher("can yayinlari", "1234567890"), 150, 1));
		List<OrderBookCount> orderBooks = new ArrayList<OrderBookCount>(Arrays.asList(orderBookCount));
		Order order = new Order(customer1, LocalDateTime.now(), orderBooks, 150);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/order/add")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(order));
		
		mockMvc.perform(mockRequest)
        .andExpect(status().isCreated());
	}
}
