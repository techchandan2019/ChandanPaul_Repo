package com.neosoft.msproj.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neosoft.msproj.model.UserInfo;

public interface IUserRepo extends CrudRepository<UserInfo, Integer> {

	@Query("from UserInfo where username=?1")
	public Optional<UserInfo> findByUserName(String username);
	

}
