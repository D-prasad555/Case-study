package com.cgt.trainapp.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cgt.trainapp.model.BookingModel;
import com.cgt.trainapp.repository.BookingRepository;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class BookingRepositoryTest {

	//Object of TrainDetailRepositoryTest to communicate with Repository
	@Autowired
	private BookingRepository repository;
	
	
	private BookingModel book1;
    private BookingModel book2;
    List<BookingModel> BookingList;
    LocalDate myDate1;
    
    @BeforeEach
    public void setUp() {
    BookingList=new ArrayList<>(); 
    myDate1 =LocalDate.parse("2022-05-14");
    book1= new BookingModel("123","prasad","durgaprasad","9894546655","durgaprasad123@gmail.com","15011","Godavari Exp","Hyderabad","Vizag","2022-07-19","18:50",1,1245); //user input
    book2= new BookingModel("124","sai","Shiram","9578546658","sai@gmail.com","15012","Enp Exp","Vizag","Hyderabad","2022-07-18","19:40",2,4125);  //user input 
    BookingList.add(book1);
    BookingList.add(book2);
    }
    
    @AfterEach
    public void tearDown() {
    	book1 = book2 = null;
    	BookingList = null;
    }
	
	
    LocalDate myDate;
	@Test
	public void givenBookingShouldReturnBookingObject() {
		repository.save(book1);  
		BookingModel p2= repository.findById(book1.getPnrId()).get(); 
		assertNotNull(p2);  //To check if it returning the Passenger Object
		assertEquals(book1.getTrainName(),p2.getTrainName());		
	}
	
	@Test
	public void getAllMustReturnAllBooking() {
		repository.save(book1);                             
		repository.save(book2);                            
		List<BookingModel> passLis=(List<BookingModel>)repository.findAll(); 
		assertEquals("GKP Exp",passLis.get(0).getTrainName());
	}
	


	@Test
	public void cancelBooking()  {
		repository.save(book1);                             // Data is saved in Database
		repository.deleteById(book1.getTrainNo());
		Optional<BookingModel> optional = repository.findById(book1.getTrainNo());
	     assertEquals(Optional.empty(), optional);
		}
	
	//Test Case for getByIdTrainDetail Implementation
	@Test
	public void givenIdThenShouldReturnTrainOfThatId() {
		repository.save(book2);
	     Optional<BookingModel> optional =  repository.findById(book2.getPnrId());
	     assertEquals(book2.getPnrId(), optional.get().getPnrId());
	     assertEquals(book2.getTrainName(), optional.get().getTrainName());
	}
	
	//updateTrainDetail Implementation
	@Test
	public void updateTrainDetailById()  {
		 repository.save(book1);
	     String name2="LKO Exp";
	     book1= new BookingModel("321","jai","jayesh","8254546655","jai@gmail.com","14011","Ltt Exp","Mumbai","vizag","2021-07-19","20:50",2,1745); //user input
	     repository.save(book1);
	     assertEquals(book1.getTrainName(), name2);
	     
	}

}
