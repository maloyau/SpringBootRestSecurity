package com.serhii.springbootrestsecurity;

import com.serhii.springbootrestsecurity.entity.CustomUserDetails;
import com.serhii.springbootrestsecurity.entity.Role;
import com.serhii.springbootrestsecurity.entity.User;
import com.serhii.springbootrestsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class SpringbootrestsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestsecurityApplication.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository) throws Exception {
		if(userRepository.count() == 0){
			userRepository.save(new User(1, "user", "pass", new HashSet<>(Arrays.asList(new Role(1, "USER"), new Role(2, "ACTUATOR")))));
			userRepository.save(new User(2, "admin", "pass", new HashSet<>(Arrays.asList(new Role(3, "ADMIN")))));
		}
		builder.userDetailsService(s -> new CustomUserDetails(userRepository.findByUsername(s)));
	}
}
