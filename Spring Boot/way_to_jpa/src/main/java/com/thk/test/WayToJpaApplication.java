package com.thk.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WayToJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WayToJpaApplication.class, args);
		
		UserRepo userRepo = context.getBean(UserRepo.class);
		// add user in database
		
		User user = new User();
		user.setName("Tanveer Ali");
		user.setCity("Mehrabpur");
		User user2 = userRepo.save(user);
		System.out.println(user2);
		
		
		//update user in database
		/*
		Optional<User> optional = userRepo.findById(2);
		User user = optional.get();
		user.setName("Roshan");
		userRepo.save(user);*/
		
		// getting data from database
		/*
		Iterable<User> it = userRepo.findAll();
		it.forEach(user->System.out.println(user));
		*/
		
		// delete elements in database
		/*
		userRepo.deleteById(2); // this will delete single user
		Iterable<User> itr = userRepo.findAll();
		itr.forEach(user->System.out.println(user));
		userRepo.deleteAll(itr); // this will delete all users
		*/
		
		// custom finder methods
		//List<User> user5 = userRepo.findByCity("Mehrabpur");
		//List<User> user6 = userRepo.findByName("Tanveer");
		//List<User> user7 = userRepo.findByNameAndCity("Tanveer", "Mehrabpur");
		//List<User> user8 = userRepo.findByCityStartingWith("K");
		//List<User> user9 = userRepo.findByIdLessThan(161);
		//List<User> user10 = userRepo.getAllTeachers();
		//List<User> user11 = userRepo.getAllTeachersByCity("Mehrabpur");
		List<User> user12 = userRepo.getAllUser();
		user12.forEach(e -> System.out.println(e));
		
		//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	}

}
