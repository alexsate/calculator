package com.calculator.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.calculator.CalculatorController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CalculatorIntegrationTests {

	@Autowired
	CalculatorController controller;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
    public void OK200Test() {
        ResponseEntity<String> entity = this.restTemplate.getForEntity(
            "/operation", String.class);
        
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        
    }
	
	@Test
    public void OK404Test() {
        ResponseEntity<String> entity = this.restTemplate.getForEntity(
            "/operationX", String.class);
        
        assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
        
    }
	
	@Test
    public void calcOperationTest() {
		
		
        ResponseEntity<String> entity = this.restTemplate.getForEntity(
            "/operation/2/2", String.class);
        
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(" Result: 4.0", entity.getBody());
        
    }
	
	@Test
    public void invalidNumberTest() {
		
		
        ResponseEntity<String> entity = this.restTemplate.getForEntity(
            "/operation/2/-2", String.class);
        
        assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());
        
    }


}
