package com.cgt.trainapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cgt.trainapp.model.UserModel;

class UserModelTest {

	UserModel admin;

	@BeforeEach
	public void before() {
		admin = new UserModel("124", "prasad", "123");
	}

	@AfterEach
	public void after() {
		admin = null;
	}

	@Test
	void testGetId() {
		assertEquals("124", admin.getId());
	}

	@Test
	void testgetUsername() {
		assertEquals("prasad", admin.getUsername());
	}

	@Test
	void testgetPassword() {
		assertEquals("123", admin.getPassword());
	}

	@Test
	void testsetId() {
		admin.setId("125");
		assertEquals("125", admin.getId());
	}

	@Test
	void testsetUsername() {
		admin.setUsername("prasad1");
		assertEquals("prasad1", admin.getUsername());
	}

	@Test
	void testsetPassword() {
		admin.setPassword("124");
		assertEquals("124", admin.getPassword());
	}

}