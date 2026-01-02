package com.springbootdocker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductController {
	@GetMapping("/status")
	public ResponseEntity<String> getStatus() {
		return new ResponseEntity("Deploying in azure through git" , HttpStatus.OK);

	}

}
