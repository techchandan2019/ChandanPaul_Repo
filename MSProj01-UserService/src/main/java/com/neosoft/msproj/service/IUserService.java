package com.neosoft.msproj.service;

import java.util.List;

import com.neosoft.msproj.model.UserInfo;

public interface IUserService {

	public String registerUser(UserInfo user);
	public List<UserInfo> fetchAllUser();
	public UserInfo getUserById(Integer unid)throws Exception;
	public String updatePassword(Integer unid,String pwd)throws Exception;
	public String deleteUserById(Integer unid)throws Exception;
//	public String validateUserByUserDetails(String usn,String pwd)throws Exception;
	public String validateUserByUserDetails1(String usn,String pwd)throws Exception;
}
