package com.neosoft.msproj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.neosoft.msproj.exception.UserDetailsNotFoundException;
import com.neosoft.msproj.model.UserInfo;
import com.neosoft.msproj.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public String registerUser(UserInfo user) {
		user.setPassword(encoder.encode(user.getPassword()));
		UserInfo userDetails=userRepo.save(user);
	
		return "User is saved with id :"+userDetails.getUnId();
	}//close method
	@Override
	public List<UserInfo> fetchAllUser() {
		
		return (List<UserInfo>) userRepo.findAll();
	}

	
}
