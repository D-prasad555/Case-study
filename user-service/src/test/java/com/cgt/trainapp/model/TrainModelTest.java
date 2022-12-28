package com.cgt.trainapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cgt.trainapp.model.TrainModel;

class TrainModelTest {

	TrainModel admin;

	@BeforeEach
	public void before() {
		admin = new TrainModel("15015", "Ltt Exp", "Mumbai", "Hyderabad", 1324, 110, "20:10");
	}

	@AfterEach
	public void after() {
		admin = null;
	}

	@Test
	void testGetTrainNo() {
		assertEquals("15015", admin.getTrainNo());
	}

	@Test
	void testGetTrainName() {
		assertEquals("Ltt Exp", admin.getTrainName());
	}

	@Test
	void testGetTrainFrom() {
		assertEquals("Mumbai", admin.getTrainFrom());
	}

	@Test
	void testGetTrainTo() {
		assertEquals("Hyderabad", admin.getTrainTo());
	}

	@Test
	void testGetFare() {
		assertEquals(1324, admin.getFare());
	}

	@Test
	void testGetSeats() {
		assertEquals(110, admin.getSeats());
	}

	@Test
	void testGetTime() {
		assertEquals("20:10", admin.getTime());
	}

	@Test
	void testsetTrainNo() {
		admin.setTrainNo("15016");
		assertEquals("15016", admin.getTrainNo());
	}

	@Test
	void testsetTrainName() {
		admin.setTrainName("Godavari Exp");
		assertEquals("Godavari Exp", admin.getTrainName());
	}

	@Test
	void testsetTrainFrom() {
		admin.setTrainFrom("Hyderabad");
		assertEquals("Gorakhpur", admin.getTrainFrom());
	}

	@Test
	void testsetTrainTo() {
		admin.setTrainTo("Mumbai");
		assertEquals("Mumbai", admin.getTrainTo());
	}

	@Test
	void testsetFare() {
		admin.setFare(1501);
		assertEquals(1501, admin.getFare());
	}

	@Test
	void testsetSeats() {
		admin.setSeats(120);
		assertEquals(120, admin.getSeats());
	}

	@Test
	void testsetTime() {
		admin.setTime("15:16");
		assertEquals("15:16", admin.getTime());
	}

}