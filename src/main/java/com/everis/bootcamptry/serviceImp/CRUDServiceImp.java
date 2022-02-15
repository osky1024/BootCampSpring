package com.everis.bootcamptry.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.everis.bootcamptry.model.User;
import com.everis.bootcamptry.model.UserRepository;

@Service
public class CRUDServiceImp {
	
	private UserRepository repo;

	
	public Optional<User> findById(Long id) {
		return repo.findById(id);
	}

	
	public List<User> findAll() {
		return repo.findAll();
	}

	
	public User save(User u) {
		return repo.save(u);
	}

}
