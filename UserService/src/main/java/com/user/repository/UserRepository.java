package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


	@Query(value = "SELECT u FROM User u where u.username=?1 and u.password=?2")
	User findUserByuserNameAndpassword(String username, String password);
	
//	@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2") 
//	User findUserByStatusAndName(Integer status, String name);
}
