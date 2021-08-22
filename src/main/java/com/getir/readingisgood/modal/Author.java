package com.getir.readingisgood.modal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class Author {
	public static final String SEQUENCE_NAME = "author_sequence";

	@Id
	private long id;
	@NotNull(message="author firstname should not be null!")
	@Size(min=3, max=50,message="author firstname length should be between 3 and 50")
	private String firstName;
	@NotNull(message="author lastname should not be null!")
	@Size(min=3, max=50,message="author lastname length should be between 3 and 50")
	private String lastName;
	
	public Author() {}
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//TODO toString override
}
