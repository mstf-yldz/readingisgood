package com.getir.readingisgood;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.getir.readingisgood.data.BookRepository;
import com.getir.readingisgood.modal.Author;
import com.getir.readingisgood.modal.Book;
import com.getir.readingisgood.modal.Publisher;


@SpringBootTest
@AutoConfigureMockMvc(addFilters=false)
public class BookControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void addBook() throws Exception{
		Book book = new Book("test", new Author("yazar", "siler"), new Publisher("can yayinlari", "1234567890"), 150, 1);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/book/add")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(book));
		
		mockMvc.perform(mockRequest)
        .andExpect(status().isCreated());
	}
}
