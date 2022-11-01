package com.cg.sprint.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.Driver;

public interface CabRepository extends JpaRepository<Cab, Long>{
}
