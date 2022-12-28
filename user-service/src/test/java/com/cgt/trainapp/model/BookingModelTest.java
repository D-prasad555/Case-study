package com.cgt.trainapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cgt.trainapp.model.BookingModel;

class BookingModelTest {

	BookingModel admin;

	@BeforeEach
	public void before() {
		admin = new BookingModel("62d61a94b3ca796335496acc", "prasad", "durgaprasad", "9905854194", "prasad123@gmail.com",
				"15015", "Godavari Exp", "Hyderabad", "Vizag", "2022-07-19", "18:15", 1, 1245);
	}

	@AfterEach
	public void after() {
		admin = null;
	}

	@Test
	void testGetPnrId() {
		assertEquals("62d61a94b3ca796335496acc", admin.getPnrId());
	}

	@Test
	void testGetUserId() {
		assertEquals("prasad", admin.getUserId());
	}

	@Test
	void testGetName() {
		assertEquals("durgaprasad", admin.getName());
	}

	@Test
	void testGetPhnnumber() {
		assertEquals("9905854194", admin.getPhnnumber());
	}

	@Test
	void testGetEmail() {
		assertEquals("prasad123@gmail.com", admin.getEmail());
	}

	@Test
	void testGetTrainNo() {
		assertEquals("15015", admin.getTrainNo());
	}

	@Test
	void testGetTrainName() {
		assertEquals("Godavari Exp", admin.getTrainName());
	}

	@Test
	void testGetTrainFrom() {
		assertEquals("Hyderabad", admin.getTrainFrom());
	}

	@Test
	void testGetTrainTo() {
		assertEquals("Vizag", admin.getTrainTo());
	}

	@Test
	void testGetDate() {
		assertEquals("2022-07-19", admin.getDate());
	}

	@Test
	void testGetTime() {
		assertEquals("18:15", admin.getTime());
	}

	@Test
	void testGetTotalseats() {
		assertEquals(1, admin.getTotalseats());
	}

	@Test
	void testGetFare() {
		assertEquals(1245, admin.getFare());
	}

	@Test
	void testsetPnrId() {
		admin.setPnrId("62d61a94b3ca796335496qww");
		assertEquals("62d61a94b3ca796335496qww", admin.getPnrId());
	}

	@Test
	void testsetUserId() {
		admin.setUserId("prasad1");
		assertEquals("prasad1", admin.getUserId());
	}

	@Test
	void testsetName() {
		admin.setName("durgaprasad1");
		assertEquals("durgaprasad1", admin.getName());
	}

	@Test
	void testsetPhnnumber() {
		admin.setPhnnumber("9845123265");
		assertEquals("9845123265", admin.getPhnnumber());
	}

	@Test
	void testsetEmail() {
		admin.setEmail("prasad123@gmail.com");
		assertEquals("prasad123@gmail.com", admin.getEmail());
	}

	@Test
	void testsetTrainNo() {
		admin.setTrainNo("15016");
		assertEquals("15016", admin.getTrainNo());
	}

	@Test
	void testsetTrainName() {
		admin.setTrainName("Ltt Exp");
		assertEquals("Ltt Exp", admin.getTrainName());
	}

	@Test
	void testsetTrainFrom() {
		admin.setTrainFrom("Vizag");
		assertEquals("Vizag", admin.getTrainFrom());
	}

	@Test
	void testsetTrainTo() {
		admin.setTrainTo("Mumbai");
		assertEquals("Mumbai", admin.getTrainTo());
	}

	@Test
	void testsetDate() {
		admin.setDate("12:43");
		assertEquals("12:43", admin.getDate());
	}

	@Test
	void testsetTime() {
		admin.setTime("15:16");
		assertEquals("15:16", admin.getTime());
	}

	@Test
	void testsetTotalseats() {
		admin.setTotalseats(120);
		assertEquals(120, admin.getTotalseats());
	}

	@Test
	void testsetFare() {
		admin.setFare(1501);
		assertEquals(1501, admin.getFare());
	}

}