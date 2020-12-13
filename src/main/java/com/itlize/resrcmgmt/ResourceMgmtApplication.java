package com.itlize.resrcmgmt;

import javax.annotation.PostConstruct;

import com.itlize.resrcmgmt.entity.User;
import com.itlize.resrcmgmt.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResourceMgmtApplication {

	private static final Logger logger = LoggerFactory.getLogger(ResourceMgmtApplication.class);

	@Autowired
	private UserService userService;

	@PostConstruct
	private void init() {

		User admin = new User();
		admin.setUsername("Roy");
		admin.setPassword("Roy");
		userService.register(admin, true);

		logger.info("Create the Administrator!");

	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceMgmtApplication.class, args);
	}

}
