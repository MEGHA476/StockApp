package com.stock.repo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stock.entity.UserEntity;

@Repository
public interface userrepo extends JpaRepository<UserEntity,Long> {
	
	@Query("select u from UserEntity where username= :username")
	public UserEntity findByUsername(@Param("username") String username);

}
