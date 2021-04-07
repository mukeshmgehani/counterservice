package com.mukesh.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mukesh.service.CounterService;

/**
 * @author Mukesh
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CounterControllerTest {


	@MockBean
	private CounterService counterService;

	
	@InjectMocks
	private CounterController counterController;

	private MockMvc mockMvc;
	
	@BeforeEach
    public void setup() {
		 MockitoAnnotations.openMocks(this);
        this.mockMvc =  MockMvcBuilders.standaloneSetup(counterController).build();
    }

	@Test
	public void whenCounterControllerInjected_thenNotNull() throws Exception {
		assertThat(counterController).isNotNull();
	}

	@Test
	public void testIncreaseCouner() throws Exception {
		 mockMvc.perform(get("/counter/increase")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse()
	            .getContentAsString();
	}

	@Test
	void testDecreaseCouner() throws Exception {
		mockMvc.perform(get("/counter/decrease")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
	            .andReturn()
	            .getResponse()
	            .getContentAsString();
	}

	@Test
	void testGetCounter() throws Exception {
		mockMvc.perform(get("/counter")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

	}

}
