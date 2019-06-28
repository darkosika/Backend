package com.okaplan.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okaplan.demo.entity.User;
import com.okaplan.demo.rest.ApplicationRestController;
import com.okaplan.demo.service.UserService;



@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoApplicationTests {

	protected MockMvc mvc;
	   @Autowired
	   WebApplicationContext webApplicationContext;

	   protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	   protected String mapToJson(Object obj) throws JsonProcessingException {
		      ObjectMapper objectMapper = new ObjectMapper();
		      return objectMapper.writeValueAsString(obj);
		   }
	
	@Test
	public void contextLoads() throws Exception {
		   String uri = "/api/register";
		   User user = new User();
		   user.setId(3);
		   user.setFullName("Osman");
		   user.setPassword("1234");
		   
		   //String inputJson = super.mapToJson(user);
		   String requestBodyJson = "{ \"fullName\":\"Osman\", \"password\":\"2\" }";

		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBodyJson)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   String content = mvcResult.getResponse().getContentAsString();
		   assertEquals(content, "Successfull");
	}

}
