package com.cgt.trainapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cgt.trainapp.exception.TrainAlreadyExistsException;
import com.cgt.trainapp.exception.TrainNotFoundException;
import com.cgt.trainapp.model.AdminModel;
import com.cgt.trainapp.model.TrainModel;
import com.cgt.trainapp.model.UserModel;
import com.cgt.trainapp.repository.AdminRepository;
import com.cgt.trainapp.repository.TrainRepository;
import com.cgt.trainapp.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/admin")
public class AdminController {
	
	    @Autowired
	    private RestTemplate restTemplate;

		@Autowired
		private AdminRepository adminrepo;
		
		@Autowired
		private TrainRepository trainrepo;
		
		@Autowired
		private UserRepository userrepo;
		
	
		Logger logger = LoggerFactory.getLogger(AdminController.class);
		
		@PostMapping("/registeradmin")
		public String addadmin(@RequestBody AdminModel admin) throws TrainAlreadyExistsException {
			adminrepo.save(admin);
			
		
	        logger.info("[registeradmin] info message added");
	        logger.warn("[registeradmin] warn message added");
	        logger.debug("registeradmin] debug message added");
	        logger.trace("[registeradmin] trace message added");
	        
			return "Admin with Id: "+admin.getId()+" have been Registered Successfully";
		}
		
		
	
		@GetMapping("/viewadminprofile/{id}")
		public Optional<AdminModel> getadmin(@PathVariable("id") String id) throws TrainNotFoundException {
			
		
	        logger.info("[viewadminprofile/id] info message added");
	        logger.debug("[viewadminprofile/id] debug message added");
        
			return adminrepo.findById(id);
		}
		
	
		@PutMapping("/updateprofile/{id}")
		public String updateadmin(@PathVariable("id") String id, @RequestBody AdminModel adminmodel)  throws TrainNotFoundException {
			adminrepo.save(adminmodel);
			
			
	        logger.info("[updateprofile/id] info message added");
	        logger.debug("[updateprofile/id] debug message added");
	        
			return "Admin with id "+id+" have been updated successfully";
		}
		
		
		
		@DeleteMapping("/deleteadmin/{id}")
		public String deleteadmin(@PathVariable String id)  throws TrainNotFoundException {
			adminrepo.deleteById(id);
			
			//logger implementation
	        logger.info("[deleteadmin/id] info message added");
	        logger.debug("[deleteadmin/id] debug message added");
	        
			return "Admin with id "+id+" have been deleted";
		}
		
		
		
	   
		@GetMapping("/viewallusers")
		public List<UserModel>getallusers() {
			
			
	        logger.info("[viewallusers] info message added");
	        logger.debug("[viewallusers] debug message added");
	        
			return Arrays.asList(restTemplate.getForObject("http://UserDetails/user/viewallusers",UserModel[].class));
		}
		
		
	
		@GetMapping("/viewuser/{id}")
		public List<UserModel> getuser(@PathVariable("id") String id){
			

	        logger.info("[viewuser/id] info message added");
	        logger.debug("[viewuser/id] debug message added");
	        
			return Arrays.asList(restTemplate.getForObject("http://UserDetails/user/viewuser/"+id,UserModel[].class));	
		}
		
		
		
		@PutMapping("/updateuser/{id}")
		public String updateuser(@RequestBody UserModel usermodel, @PathVariable("id") String id) {
			this.restTemplate.put("http://UserDetails/user/updateprofile/{id}",id,usermodel);
			
		
	        logger.info("[viewallusers/id] info message added");
	        logger.debug("[viewallusers/id] debug message added");
	        
			return "User with id : "+id+" have been updated";
		}
		
	
	
		@DeleteMapping("/deleteuser/{id}")
		public String deleteuser(@PathVariable String id) {
			this.restTemplate.delete("http://UserDetails/user/deleteprofile/{id}",id);
			
			
	        logger.info("[deleteuser/id] info message added");
	        logger.debug("[deleteuser/id] debug message added");
	        
			return "User with id :"+id+" have been deleted";
		}
		
		
		

		
	  
		@PostMapping("/addtrain")
		public String addtrain(@RequestBody TrainModel trainmodel) {
			this.restTemplate.postForObject("http://TrainDetails/train/addtrain", trainmodel, TrainModel.class);
			
	
	        logger.info("[addtrain] info message added");
	        logger.debug("[addtrain] debug message added");
	        
			return "Train with No: "+trainmodel.getTrainNo()+" have been added Successfully";
		}
		
		
	   
		@GetMapping("/viewalltrains")
		public List<TrainModel> getAllTrains(){
			
	
	        logger.info("[viewalltrains] info message added");
	        logger.debug("[viewalltrains] debug message added");
	        
			return Arrays.asList(restTemplate.getForObject("http://TrainDetails/train/viewalltrains",TrainModel[].class));
		}

		
		
		@GetMapping("/viewalltrains/{trainNo}")
		public TrainModel getTrains(@PathVariable("trainNo") String trainNo){
			
	        logger.info("[viewalltrains/id] info message added");
	        logger.debug("[viewalltrains/id] debug message added");
	        
			return restTemplate.getForObject("http://TrainDetails/train/viewtrainbyno/"+trainNo,TrainModel.class);	
		}
		
		
		//Rest API to get User details by Name
		@GetMapping("/viewtrainbyname/{trainName}")
		public TrainModel getTrainsbyname(@PathVariable("trainName") String trainName){

			//logger implementation
	        logger.info("[viewtrainbyname/Name] info message added");
	        logger.debug("[viewtrainbyname/Name] debug message added");
			
			return restTemplate.getForObject("http://TrainDetails/train/viewtrainbyname/"+trainName,TrainModel.class);	
		}
		
		

		@PutMapping("/updatetrain/{trainNo}")
		public String updatetrain(@RequestBody TrainModel trainmodel, @PathVariable String trainNo) {
			this.restTemplate.put("http://TrainDetails/train/updatetrain/{trainNo}",trainmodel,trainNo,TrainModel.class);
			
			
	        logger.info("[updatetrain/id] info message added");
	        logger.debug("[updatetrain/id] debug message added");
			
			return "Train with no. : "+trainNo+" have been updated";
		}
		
	

		@DeleteMapping("/deletetrain/{trainNo}")
		public String deletetrain(@PathVariable String trainNo) {
			this.restTemplate.delete("http://TrainDetails/train/deletetrain/"+trainNo,TrainModel.class);
			

	        logger.info("[deletetrain/id] info message added");
	        logger.debug("[deletetrain/id] debug message added");
	        
			return "Train with no. :"+trainNo+" have been deleted";
		}
		
}
