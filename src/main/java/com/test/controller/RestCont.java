package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.bean.Employee;
import com.test.bean.User;
import com.test.repository.UserRepository;



@RestController
public class RestCont {
	
	@Autowired
	UserRepository uRep;
	
	@RequestMapping(value="/sample" , method = RequestMethod.GET ,produces = { "application/json", "text/json" }, consumes = MediaType.ALL_VALUE )
	public Employee Smaple(){
		
		Employee e= new Employee(22);
		//return new ResponseEntity<Employee>(e, HttpStatus.OK);
		return e;
		
		}
	
	
	@RequestMapping(value="/sampleID" , method = RequestMethod.GET ,produces = { "application/json", "text/json" }, consumes = MediaType.ALL_VALUE )
	public Employee SmapleID(@org.springframework.web.bind.annotation.RequestParam(value = "ID", required = false) int companyID){
		
		Employee e= new Employee(1222);
		//return new ResponseEntity<Employee>(e, HttpStatus.OK);
		return e;
		
		}
	

	@RequestMapping(value="/sampleKey/{key}/value/{value1}" , method = RequestMethod.GET ,produces = { "application/json", "text/json" }, consumes = MediaType.ALL_VALUE )
	public Employee SmapleKey(@PathVariable("key") int key,@RequestParam(value = "ID", required = false) int id,@PathVariable("value1") int value){
		
		Employee e= new Employee(value);
		//return new ResponseEntity<Employee>(e, HttpStatus.OK);
		return e;
		
		}

	@org.springframework.transaction.annotation.Transactional
	@RequestMapping(value="/add" , method = RequestMethod.POST , consumes = MediaType.ALL_VALUE )
	public void addNewUser (@RequestParam String name
			, @RequestParam String email) {
		
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		uRep.save(n);
		
		
	}
	
	@org.springframework.transaction.annotation.Transactional
	@RequestMapping(value="/update" , method = RequestMethod.PUT , consumes = MediaType.ALL_VALUE )
	public void addupdateUser (@RequestParam String name
			, @RequestParam String email) {
		
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		uRep.save(n);
		
		
	}
	

	@RequestMapping(value="/addFromAngular" , method = RequestMethod.POST )
	public void addNewUserFromAngular (@RequestBody User user) {
		
		User n= new User();
		n.setName(user.getName());
		n.setEmail(user.getEmail());
		uRep.save(n);
		
		
	}
	
	@RequestMapping(value="/getUser" , method = RequestMethod.GET ,produces = { "application/json", "text/json" }, consumes = MediaType.ALL_VALUE )
	public User getUser (@RequestParam String name) {
		User n = new User();
		
		n=uRep.findOne(name);
		return n;
	}

	
	@RequestMapping(value="/deleteUser" , method = RequestMethod.DELETE ,produces = { "application/json", "text/json" }, consumes = MediaType.ALL_VALUE )
	public String deleteUser (@RequestParam String name) {
		
		
		uRep.delete(new User(name));
		return "Delete";
	
	}
	
	@RequestMapping(value="/getUserALL" , method = RequestMethod.GET ,produces = { "application/json", "text/json" }, consumes = MediaType.ALL_VALUE )
	public List<User> getUser () {
		List<User> n = new ArrayList<User>();
		
		n=(List<User>) uRep.findAll();
		return n;
	}
}