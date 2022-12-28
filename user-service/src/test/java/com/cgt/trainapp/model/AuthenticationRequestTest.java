package com.cgt.trainapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cgt.trainapp.model.AuthenticationRequest;

class AuthenticationRequestTest {

	AuthenticationRequest admin;

	@BeforeEach
	public void before() {
		admin = new AuthenticationRequest("prasad", "123");
	}

	@AfterEach
	public void after() {
		admin = null;
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