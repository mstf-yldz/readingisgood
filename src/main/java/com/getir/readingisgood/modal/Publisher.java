package com.getir.readingisgood.modal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class Publisher {
	public static final String SEQUENCE_NAME = "publisher_sequence";

	@Id
	private long id;
	@NotNull(message="publisher name should not be null!")
	@Size(min=10, max=250,message="publisher name length should be between 10 and 250")
	private String name;
	@NotNull(message="ssn name should not be null!")
	@Size(min=11, max=11,message="ssn length should be 11")
	private String ssn;
	
	public Publisher(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
	public Publisher() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	// TODO toString override
}
