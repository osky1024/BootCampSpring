package com.everis.bootcamptry.model;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories 
@EntityScan 
public interface UserRepository extends JpaRepository<User,Long>{
	
	Optional<User> findById(Long id);
	
	List<User> findAll();
	
	User save(User u);
	

}
