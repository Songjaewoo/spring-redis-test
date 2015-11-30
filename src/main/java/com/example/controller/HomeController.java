package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

@RestController
public class HomeController {

	@Autowired
	private UserRepository repository;
	
	@Cacheable(value = "redis")
	@RequestMapping(value = "/redis", method = RequestMethod.GET)
	public List<User> redis() {
		return repository.findAll();
	}
	
	@CacheEvict(value = "redis")
	@RequestMapping(value = "/redis", method = RequestMethod.DELETE)
	public boolean deleteCache() {
		return true;
	}
}
