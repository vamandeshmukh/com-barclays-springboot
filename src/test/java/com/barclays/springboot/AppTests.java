package com.barclays.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTests {

	@Test
	public void testTest() {
		assertEquals(10, 5 + 5);
	}

}
