package com.neosoft.msproj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.neosoft.msproj.model.UserInfo;
import com.neosoft.msproj.repo.IUserRepo;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepo repo;
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserInfo> opt=repo.findByUserName(username);
		if(opt.isPresent()) {
			UserInfo info=opt.get();
			return new User(info.getUsername(),info.getPassword(),new ArrayList<>());
		}else {
			throw new UsernameNotFoundException(" username not found");
		}
	}
	
	public String saveUser(UserInfo info) {
		info.setPassword(encoder.encode(info.getPassword()));
		 repo.save(info);
		 return info.getUnId()+" is saved";
	}
	
	
	

}
