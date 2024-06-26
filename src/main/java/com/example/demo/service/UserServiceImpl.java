package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepo;
@Service
public class UserServiceImpl implements UserService {

@Autowired 
UserRepo userRepo;

	@Override
	public UserDetailsService userDetailsService() {

		return new UserDetailsService() {
		
	@Override 
	public UserDetails loadUserByUsername(String username){
		return userRepo.findByEmail(username)
				
				.orElseThrow(()-> new UsernameNotFoundException("Username Not Found"+username));
	      }
		};
	}

}
