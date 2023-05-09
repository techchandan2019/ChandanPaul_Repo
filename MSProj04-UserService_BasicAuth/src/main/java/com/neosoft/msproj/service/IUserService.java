package com.neosoft.msproj.service;

import java.util.List;

import com.neosoft.msproj.model.UserInfo;

public interface IUserService {

	public String registerUser(UserInfo user);
	public List<UserInfo> fetchAllUser();
	
}
