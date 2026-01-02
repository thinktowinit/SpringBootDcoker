package com.springbootdcoker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.spring.cloud.feature.management.FeatureManager;

@RequestMapping("/product")
@RestController
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private MyProperties properties;

	@Autowired
	private org.springframework.core.env.Environment env;

	@GetMapping("/getValuesFromAzureAppConfig")
	public String debug() {
		String value = env.getProperty("sbd-db.url");
		logger.info("value from azure app config {}", value);
		return "sbd-db.url = " +value;
	}

	@GetMapping("/getDbDetails")
	public String getMessage() {
		logger.info("db detailsss {}", properties.getMessage());
		return "Message: " + properties.getMessage();
	}

	@GetMapping("/status")
	public ResponseEntity<String> getStatus() {
		return new ResponseEntity<>("spring boot application Deploying in Azure through git - Version3", HttpStatus.OK);
	}

}
