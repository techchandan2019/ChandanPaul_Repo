package com.neosoft.msproj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.msproj.exception.UserDetailsNotFoundException;
import com.neosoft.msproj.model.UserInfo;
import com.neosoft.msproj.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepo;
	
	@Override
	public String registerUser(UserInfo user) {
		/*//null checking 
		if(user.getUsername()!=null||user.getPassword()!=null) {
			
			UserInfo userDetails=userRepo.save(user);
			return "User is saved with id :"+userDetails.getUnId();
		}else {
			throw new RuntimeException("username or password should not be null");
		}*/
		
		UserInfo userDetails=userRepo.save(user);
		return "User is saved with id :"+userDetails.getUnId();
	}//close method
	@Override
	public List<UserInfo> fetchAllUser() {
		
		return (List<UserInfo>) userRepo.findAll();
	}
	@Override
	public UserInfo getUserById(Integer unid)throws Exception {
		//fetch User by id
		 Optional<UserInfo> opt=userRepo.findById(unid);
		 if(opt.isPresent())
			 return opt.get();
		 else
			 throw new UserDetailsNotFoundException("User unid not found");
		 
		
	}//close 
	@Override
	public String updatePassword(Integer unid,String pwd)throws Exception {
		//fetch User by id
		 Optional<UserInfo> opt=userRepo.findById(unid);
		 if(opt.isPresent()) {
			 
			 UserInfo unInfo=opt.get();
			 //set Password to the UserInfo Object
			unInfo.setPassword(pwd);;
			//save the product object(partial update) 
			userRepo.save(unInfo);
			 return opt.get().getUnId()+" is updated successfully"; 
		 }//if
		 else
			 throw new UserDetailsNotFoundException("User unid not found");
		 
	
	}//close method
	@Override
	public String deleteUserById(Integer unid)throws Exception {
		//fetch User by id
		 Optional<UserInfo> opt=userRepo.findById(unid);
		 if(opt.isPresent()) {
			 //delete User details by Id
			userRepo.deleteById(unid);
			 return opt.get().getUnId()+" is deleted successfully";
		 }//if
		 else
			 throw new UserDetailsNotFoundException("User unid not found");
		 
		
	}//close
	
	/*@Override
	public String validateUserByUserDetails(String usn, String pwd) throws Exception {
			Optional<String> opt=userRepo.findByUserName(usn);
			
			if(opt.isPresent()) {
				String passwords=opt.get();
				//validate user credential
				if(passwords.equals(pwd))
					return "password is correct";
				else
					throw new UserDetailsNotFoundException("Invalid credential ");
			}else {
				throw new UserDetailsNotFoundException("username not found");
			}
	
	
	}*/
	@Override
	public String validateUserByUserDetails1(String usn, String pwd) throws Exception {
		Optional<UserInfo> opt=userRepo.findByUserName1(usn);
		
		if(opt.isPresent()) {
			UserInfo info=opt.get();
			//validate user credential
			if(info.getPassword().equals(pwd))
				return "password is correct";
			else
				throw new UserDetailsNotFoundException("Invalid credential ");
		}else {
			throw new UserDetailsNotFoundException("username not found");
		}

	}
	
}
