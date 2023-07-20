package com.fabrick.colmi.davidemaria;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabrick.colmi.davidemaria.dto.AccountDetail;
import com.fabrick.colmi.davidemaria.service.FabrickApiService;


@SpringBootApplication
public class Application {
	
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.debug("prova debug");
		logger.error("prova error");
		logger.info("prova info");
		logger.warn("prova trace");
	}

}
