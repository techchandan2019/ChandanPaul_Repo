package com.neosoft.msproj.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.msproj.exception.UserDetailsNotFoundException;
import com.neosoft.msproj.model.UserInfo;
import com.neosoft.msproj.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	private static Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private IUserRepository userRepo;
	
	@Override
	public String registerUser(UserInfo user) {
		
		logger.info("register user method of service class");
		UserInfo userDetails=userRepo.save(user);
		return "User is saved with id :"+userDetails.getUnId();
	}//close method
	@Override
	public List<UserInfo> fetchAllUser() {
		logger.info("get all user method of service class");
		return (List<UserInfo>) userRepo.findAll();
	}
	@Override
	public UserInfo getUserById(Integer unid)throws Exception {
		
		logger.info("get user by Id method of service class");
		 Optional<UserInfo> opt=userRepo.findById(unid);
		 if(opt.isPresent())
			 return opt.get();
		 else {
			 logger.error("problem in get user by Id method of service class ");
			 throw new UserDetailsNotFoundException("User unid not found");
		 }
		 
		
	}//close 
	@Override
	public String updatePassword(Integer unid,String pwd)throws Exception {
		logger.info("update password  method of service class");
		 Optional<UserInfo> opt=userRepo.findById(unid);
		 if(opt.isPresent()) {
			 
			 UserInfo unInfo=opt.get();
			 //set Password to the UserInfo Object
			unInfo.setPassword(pwd);;
			//save the product object(partial update) 
			userRepo.save(unInfo);
			 return opt.get().getUnId()+" is updated successfully"; 
		 }//if
		 else {
			 logger.error("problem in update password  method of service class ");
			 throw new UserDetailsNotFoundException("User unid not found");
			 
		 }
		 
	
	}//close method
	@Override
	public String deleteUserById(Integer unid)throws Exception {
		logger.info("delete user by Id method of service class");
		 Optional<UserInfo> opt=userRepo.findById(unid);
		 if(opt.isPresent()) {
			 //delete User details by Id
			userRepo.deleteById(unid);
			 return opt.get().getUnId()+" is deleted successfully";
		 }//if
		 else {
			 logger.error("problem in delete user by Id method of service class ");
			 throw new UserDetailsNotFoundException("User unid not found");
		 }
		 
		
	}//close
	
	
	@Override
	public String validateUserByUserDetails1(String usn, String pwd) throws Exception {
		
		logger.info("validate user by UserDetails method of service class");
		Optional<UserInfo> opt=userRepo.findByUserName1(usn);
		
		if(opt.isPresent()) {
			UserInfo info=opt.get();
			if(info.getPassword().equals(pwd))
				return "password is correct";
			else {
				
				logger.error("problem in validate user by UserDetails method of service class=>Invalid Credential");
				throw new UserDetailsNotFoundException("Invalid credential ");
			}
		}else {
			 logger.error("problem in validate user by UserDetails method of service class=>UserName not found");
			throw new UserDetailsNotFoundException("username not found");
		}

	}
	
}
