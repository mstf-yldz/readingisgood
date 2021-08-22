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
import com.getir.readingisgood.data.AuthorRepository;
import com.getir.readingisgood.modal.Author;

@SpringBootTest
@AutoConfigureMockMvc(addFilters=false)
public class AuthorControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Test
	public void addAuthor() throws Exception{
		Author author = new Author("yazar", "siler");
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/author/add")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(author));
		
		mockMvc.perform(mockRequest)
        .andExpect(status().isCreated());
	}
}
