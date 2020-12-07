package com.itlize.resrcmgmt.service;

import java.util.Arrays;

import com.itlize.resrcmgmt.entity.Profile;
import com.itlize.resrcmgmt.entity.User;
import com.itlize.resrcmgmt.repository.UserRepository;
import com.itlize.resrcmgmt.util.DateUtil;

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
