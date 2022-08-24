package com.orderservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.entity.User;
import com.orderservice.service.UserService;

@RestController
@RequestMapping("/user")
public class OrderController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity saveUser(@Valid @RequestBody User user) {
			userService.saveUser(user);
			MultiValueMap<String,String> map=new LinkedMultiValueMap<String,String>();
			map.add("header", "success");
			ResponseEntity res=new ResponseEntity(map,HttpStatus.CREATED);
			return res;
	}
	
	@GetMapping("/get")
	public List<User> getAllUser(){
			return userService.getAllUser();		
	}
	
//	@PutMapping("/updateuser")
//	public User updateUser(@RequestParam int id) {
//		userService.updateUser(id);
//	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleException(MethodArgumentNotValidException ex){
		
		Map<String,String> error =new HashMap<String,String>();
		ex.getBindingResult().getAllErrors().forEach(e->{
			String fieldName=((FieldError) e).getField();
			String message=((FieldError) e).getDefaultMessage();
			error.put(fieldName, message);
		});
		return error;
	}

}
