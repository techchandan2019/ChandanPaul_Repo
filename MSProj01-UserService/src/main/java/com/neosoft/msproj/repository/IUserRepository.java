package com.neosoft.msproj.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neosoft.msproj.model.UserInfo;

public interface IUserRepository extends CrudRepository<UserInfo, Integer> {

	/*	@Query("select password from UserInfo where username=?1")
		public Optional<String> findByUserName(String usn);*/
	
	@Query("from UserInfo where username=?1")
	public Optional<UserInfo> findByUserName1(String usn);
}
