package com.cg.sprint.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long>{
}
