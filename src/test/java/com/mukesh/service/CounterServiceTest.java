package com.mukesh.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * @author Mukesh
 *
 */
@SpringBootTest
class CounterServiceTest {

	@Autowired
	private CounterService counterService;
	
	
	@BeforeEach
	void setUp() throws Exception {
		ReflectionTestUtils.setField(counterService, "counter", 0);
	}

	@Test
	void testIncreaseCouner() {
		String response =counterService.increaseCouner();
		String expected="Counter has been Increased by one";
		assertEquals(expected, response);
	}

	@Test
	void testGetCounter() {
		counterService.increaseCouner();
		Integer response =counterService.getCounter();
		Integer expected=1;
		assertEquals(expected, response);
	}
	
	@Test
	void testDecreaseCouner() {
		String response =counterService.decreaseCouner();
		String expected="Counter has been Decreased by one";
		assertEquals(expected, response);
	}

	
	
	@Test
	void testCompleteCounterService() {
		Integer response =counterService.getCounter();
		Integer expected=0;
		assertEquals(expected, response);
		
		counterService.increaseCouner();
		response =counterService.getCounter();
		Integer expectedAfterIncreasing=1;
		assertEquals(expectedAfterIncreasing, response);
		
		counterService.decreaseCouner();
		response =counterService.getCounter();
		assertEquals(expected, response);
		
	}

}
