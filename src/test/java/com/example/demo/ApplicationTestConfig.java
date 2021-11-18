package com.example.demo;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.TestConfiguration;

/**
 * 
 * @author marco.mangan@gmail.com
 *
 */
@TestConfiguration
public class ApplicationTestConfig {

	public ApplicationTestConfig(){
		//MockitoAnnotations.initMocks(this);
		MockitoAnnotations.openMocks(this);

	}

}