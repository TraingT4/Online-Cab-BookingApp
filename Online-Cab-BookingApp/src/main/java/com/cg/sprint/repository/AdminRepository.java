package com.cg.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{

	  Admin findUserByadminId(int adminid);

	

}
