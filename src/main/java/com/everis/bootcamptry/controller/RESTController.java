package com.everis.bootcamptry.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.everis.bootcamptry.model.User;
import com.everis.bootcamptry.model.UserRepository;
import com.everis.bootcamptry.serviceImp.CRUDServiceImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value="bootApi")
@RestController
@Validated
public class RESTController {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e){
		return new ResponseEntity<>("Not valid due to validation error:"+e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@Autowired
	private CRUDServiceImp service;
	
	@RequestMapping( method=RequestMethod.GET,value="/userid/{id}")
	@ResponseBody
	public Optional<User> findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	
	@RequestMapping( method=RequestMethod.GET,value="/users")
	@ResponseBody
	public List<User> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/save/{User}")
	@ResponseBody
	public User save(@PathVariable("User") User user) {
		return service.save(user);
	}
	
	@ApiOperation(value= "Delete a role binding")
	@ApiResponse(value= {
			@ApiResponse(code= 200, message="Success"),
			@ApiResponse(code= 404, message="Server not found"),
			@ApiResponse(code= 500, message="Internal server error") })
	
}
