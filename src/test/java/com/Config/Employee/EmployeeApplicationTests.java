package com.Config.Employee;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmployeeApplicationTests {

	@Test
	void contextLoads() {

		String user;
		user = "abcd";
		assertEquals("abcd", user);
	}

}
