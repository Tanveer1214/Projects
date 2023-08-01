package com.thk.test;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends CrudRepository<User,Integer>{
	
	public List<User> findByName(String name);
	
	public List<User> findByCity(String city);
	
	public List<User> findByNameAndCity(String name, String city);
	
	public List<User> findByCityStartingWith(String s);
	
	public List<User> findByIdLessThan(int n);
	
	@Query("select u FROM User u")
	public List<User> getAllTeachers();
	
	@Query("select u FROM User u WHERE u.city=:n")
	public List<User> getAllTeachersByCity(@Param("n") String name);
	
	@Query(value = "select * from teachers", nativeQuery = true)
	public List<User> getAllUser();
	
}