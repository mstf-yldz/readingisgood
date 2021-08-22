package com.getir.readingisgood.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.getir.readingisgood.modal.user.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private DummyUserService dummyUserService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = dummyUserService.getUserByUsername(username);
		if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
	}
}
