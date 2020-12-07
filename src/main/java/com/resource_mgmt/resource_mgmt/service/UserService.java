package com.resource_mgmt.resource_mgmt.service;

import java.util.Arrays;

import com.resource_mgmt.resource_mgmt.entity.Profile;
import com.resource_mgmt.resource_mgmt.entity.User;
import com.resource_mgmt.resource_mgmt.repository.UserRepository;
import com.resource_mgmt.resource_mgmt.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void register(User user, boolean isAdmin) {
		// encode password
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		// set profile
		if (!isAdmin)
			user.setProfiles(Arrays.asList(new Profile(2, "USER")));
		else
			user.setProfiles(Arrays.asList(new Profile(1, "ADMIN")));

		// set title
		user.setTitle("Undecided");

		// set creationdate & updatedate
		String cur = DateUtil.getDate();
		user.setCreationTime(cur);
		user.setUpdateTime(cur);

		userRepository.save(user);
	}

	public User getCurUserInfo() {
		return userRepository.findCurrentUserInformation();
	}

}
