package com.devsayan.springsecurity;

import com.devsayan.springsecurity.entities.User;
import com.devsayan.springsecurity.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurity2ApplicationTests {
	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {

		User user = new User(4l,"sayan456@gmail","tyty");
		String token = jwtService.generateToken(user);
		System.out.println(token);
		Long userId = jwtService.getUserIdFromToken(token);
		System.out.println(userId.equals(user.getId()));
	}

}
