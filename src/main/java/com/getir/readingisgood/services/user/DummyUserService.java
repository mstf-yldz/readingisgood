package com.getir.readingisgood.services.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.getir.readingisgood.modal.user.User;

@Service
public class DummyUserService {
	 private Map<String, User> users = new HashMap<>();

	    @PostConstruct
	    public void initialize() {
	        users.put("user", new User("user", "user"));
	        users.put("admin", new User("admin", "admin"));
	        users.put("getir", new User("getir", "gotur"));
	    }

	    public User getUserByUsername(String username) {
	        return users.get(username);
	    }
}
