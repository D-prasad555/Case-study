package com.cgt.trainapp.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cgt.trainapp.model.AuthenticationRequest;
import com.cgt.trainapp.model.AuthenticationResponse;
import com.cgt.trainapp.model.UserModel;
import com.cgt.trainapp.repository.UserRepository;
import com.cgt.trainapp.service.JwtUtil;
import com.cgt.trainapp.service.UserInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/user")
public class AuthController {
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	AuthenticationManager authenticationmanager;
	
	@Autowired
	UserInfoService userinfoservice;
	
	@Autowired
	JwtUtil jwtutil;
	
	@Autowired
	RestTemplate restTemplate;
	

	Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	
	
	
	@PostMapping("/register")
	private ResponseEntity<AuthenticationResponse>registerClientToken(@RequestBody AuthenticationRequest authrequest){
		
	
        logger.info("[register] info message added");
        logger.debug("[register] debug message added");
        
		UserModel usermodel =new UserModel();
		usermodel.setUsername(authrequest.getUsername());
		usermodel.setPassword(authrequest.getPassword());
		
		List<UserModel> usermodellist = Arrays.asList(restTemplate.getForObject("http://UserDetails/user/viewallusers",UserModel[].class));
		System.out.println(usermodellist);
		System.out.println(usermodel.getUsername());
		int count = 0;
		
		for(int i=0;i<usermodellist.size();i++)
		{
			System.out.println(usermodellist.get(i).getUsername());
			if(usermodel.getUsername().equals(usermodellist.get(i).getUsername())) {
				count++;
				break;
			}
		}
		
		 if (count==0) {
			    userrepo.save(usermodel);
		        return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
				   (authrequest.getUsername()+" registered Successfully ","1"), HttpStatus.OK);
	     }
	     else {
				System.out.println("Invalid Credentials");
				return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse
					("Registration Failed","0") , HttpStatus.OK);
		 }
    }
     
	

	@PostMapping("/authenticate")
	private ResponseEntity<?> authenticateClientToken(@RequestBody AuthenticationRequest authrequest) throws Exception{

		try {
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUsername(), authrequest.getPassword()));
		}
		
		catch(Exception e) {
			String success = "false";
			return ResponseEntity.ok(new AuthenticationResponse("no",success));
		}
		
		UserDetails userdetails= userinfoservice.loadUserByUsername(authrequest.getUsername());
		
		String jwt = jwtutil.generateToken(userdetails);
		String success = "true";
		
		//logger implementation
        logger.info("[authenticate] info message added");
        logger.debug("[authenticate] debug message added");
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt ,success));
	}
	
	
	
	@GetMapping("/viewprofile")
	public List<UserModel> getuser(){
		
		
        logger.info("[viewprofile] info message added");
        logger.debug("[viewprofile] debug message added");
        
		return userrepo.findAll();
	}
	
	
	
	
	
	
	
	
	@GetMapping("/hello")
	public String firstPage() {
		return "Hello World";
	}
	
	@PostMapping("/reg")
	public String adduser(@RequestBody UserModel usermodel) {
		userrepo.save(usermodel);
		return "User with Id: "+usermodel.getId()+" have been Registered Successfully";

	}
}
