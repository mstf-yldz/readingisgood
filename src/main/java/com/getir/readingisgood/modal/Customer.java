package com.getir.readingisgood.modal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Customer {
	
    public static final String SEQUENCE_NAME = "customer_sequence";
	@Id
	private Long id;
	
	@NotNull(message="Firstname cannot be null!")
	@Size(min=3, max=100, message="firstname size must be between 3 and 100")
	private String firstName;
	
	@NotNull(message="Lastname cannot be null!")
	@Size(min=3, max=100, message="lastname size must be between 3 and 100")
	private String lastName;
	
	@Email(message="EMail should be valid!")
	@Indexed(unique=true)
	private String eMail;
	
	@NotNull(message="Phone should not be null")
	@Size(min=10, max=10, message="Phone should be 10 characters")
	private String tel;
	
	@NotNull(message="address can not be null")
	@Size(min=20, max=200,message="Address size must be between 20 and 200")
	private String address;
	
	public Customer() {}
	
	public Customer(String firstName, String lastName, String eMail, String tel, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.tel = tel;
		this.address = address;
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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
