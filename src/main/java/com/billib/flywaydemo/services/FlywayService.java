package com.billib.flywaydemo.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class FlywayService implements CommandLineRunner {
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.flyway.schemas}")
	private String[] schemas;
	
	@Override
	public void run(String... args) throws Exception {
		Map<String,String> placeholders = new HashMap<>();
		Flyway flyway = new Flyway();
    	flyway.setDataSource(url, username, password);
    	Arrays.stream(schemas).forEach(x -> {
        	placeholders.put("schema",x);
        	flyway.setSchemas(x);
        	flyway.setPlaceholders(placeholders);
        	flyway.migrate();
    	});
	}

}
