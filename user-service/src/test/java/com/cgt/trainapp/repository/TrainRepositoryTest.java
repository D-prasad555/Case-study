package com.cgt.trainapp.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cgt.trainapp.model.BookingModel;
import com.cgt.trainapp.model.TrainModel;
import com.cgt.trainapp.repository.TrainRepository;



@SpringBootTest
@ExtendWith(SpringExtension.class)
class TrainRepositoryTest {

	//Object of TrainDetailRepositoryTest to communicate with Repository
	@Autowired
	private TrainRepository repository;
	
	//Attributes
	Map<String, Integer> seats = new HashMap<String, Integer>(); 
    LocalDate myDate;
    List<TrainModel> TrainList;
    private TrainModel train1;
    private TrainModel train2;
    
    @BeforeEach
    public void setUp() {
    TrainList=new ArrayList<>(); 
    seats.put("D1", 45);
    myDate =LocalDate.parse("2022-05-14");
    train1= new TrainModel("15043","Ltt Exp","Mumbai","Hyderabad",1345,110,"21:23"); //user input
    train2= new TrainModel("16043","Enp Exp","Vizag","Hyderabad",1845,130,"13:46");  //user input 
    TrainList.add(train1);
    TrainList.add(train2);
    }
    @AfterEach
    public void tearDown() {
    	train1 = train2 = null;
    	TrainList = null;
    }
    
    //Test Case for AddTrain
	@Test
	public void givenTrainShouldReturnTrainObject() {
		repository.save(train1);  // Data is saved in Database
		TrainModel p2= repository.findById(train1.getTrainNo()).get(); //Fetching the data from DataBase
		assertNotNull(p2);  //To check if it returning the Passenger Object
		assertEquals(train1.getTrainName(),p2.getTrainName());		
	}
	
	//Test Case For getAllPassenger 
	@Test
	public void getAllMustReturnAllPassenger() {
		repository.save(train1);                             // Data is saved in Database
		repository.save(train2);                             // Data is saved in Database
		List<TrainModel> passLis=(List<TrainModel>)repository.findAll(); 
		//assertEquals("LKO Exp",passLis.get(0).getTrainName());
	}

	//Test Case for deleteTrainDetailBypid Implementation
	@Test
	public void deleteTrain(){
		repository.save(train1);                             // Data is saved in Database
		repository.deleteById(train1.getTrainNo());
		Optional<TrainModel> optional = repository.findById(train1.getTrainNo());
	     assertEquals(Optional.empty(), optional);
		}
	
	//Test Case for getByIdTrainDetail Implementation
	@Test
	public void givenIdThenShouldReturnTrainOfThatId() {
	     Optional<TrainModel> optional =  repository.findById(train2.getTrainNo());
	     assertEquals(train2.getTrainNo(), optional.get().getTrainNo());
	     assertEquals(train2.getTrainName(), optional.get().getTrainName());
	}
	
	//updateTrainDetail Implementation
	@Test
	public void updateTrainDetailById(){
		 repository.save(train1);
	     String name2="Enp Exp";
	     train1= new TrainModel("17078","Enp Exp","Vizag","Hyderabad",1945,170,"05:00"); //user input
	     repository.save(train1);
	     assertEquals(train1.getTrainName(), name2);
	     
	}
}

