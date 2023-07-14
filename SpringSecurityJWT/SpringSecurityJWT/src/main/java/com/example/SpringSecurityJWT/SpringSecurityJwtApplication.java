package com.example.SpringSecurityJWT;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.SpringSecurityJWT.entity.UserClass;
import com.example.SpringSecurityJWT.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtApplication {
	
	@Autowired
	private UserRepository repository;

	@PostConstruct
    public void initUsers() {
        List<UserClass> users = Stream.of(
                new UserClass(101, "javatechie", "password", "javatechie@gmail.com"),
                new UserClass(102, "muskan", "muskan", "user1@gmail.com"),
                new UserClass(103, "user2", "pwd2", "user2@gmail.com"),
                new UserClass(104, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
		System.out.println("Hello from JWT-- ");
	}

}
