package com.cg.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long>{

<<<<<<< HEAD
	  Admin findUserByadminId(Long i);
=======
	  Admin findUserByadminId(int adminid);
>>>>>>> 76abbb80cfa605372b42da3bb927491eae3c5750

	

}
