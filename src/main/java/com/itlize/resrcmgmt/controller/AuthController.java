package com.itlize.resrcmgmt.controller;

import com.itlize.resrcmgmt.entity.User;
import com.itlize.resrcmgmt.model.CustomUserDetails;
import com.itlize.resrcmgmt.model.JwtRequest;
import com.itlize.resrcmgmt.model.JwtResponse;
import com.itlize.resrcmgmt.service.JpaUserDetailsService;
import com.itlize.resrcmgmt.service.JwtTokenBlacklistService;
import com.itlize.resrcmgmt.service.UserService;
import com.itlize.resrcmgmt.util.JwtUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtTokenBlacklistService jwtBlacklist;
    
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		logger.info(SecurityContextHolder.getContext().getAuthentication() == null ? "Security Context is not updated!" : "Security Context has been updated!");

		final CustomUserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(jwt));
    }
    
	@GetMapping("/logoff")
    public ResponseEntity<?> deleteAuthenticationToken(@RequestHeader("Authorization") String token) {
			String jwt = token.substring(7);
			jwtBlacklist.add(jwt);
			return ResponseEntity.ok("Logout Done!");
	}
	
	@PostMapping("/signup") 
	public ResponseEntity<?> register(@RequestBody User user) {
		userService.register(user, false);
		return ResponseEntity.ok("Successfully Registered!");
	}
}
