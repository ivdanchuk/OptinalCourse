package com.java.model.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ValidatorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void givenValidEmail_whenValidate_True() {
		String email = "email@ok.ok";
		Validator.isValidEmailAddress(email);
		Assert.assertTrue(Validator.isValidEmailAddress(email));

		email = "email@ok.okok";
		Validator.isValidEmailAddress(email);
		Assert.assertTrue(Validator.isValidEmailAddress(email));

		// 32 local part
		email = "email67890email67890email67890__@ok.okok";
		Validator.isValidEmailAddress(email);
		Assert.assertTrue(Validator.isValidEmailAddress(email));
	}

	@Test
	public void givenNotValidEmail1_whenValidate_False() {
		String email = ".email@ok.ok";
		Validator.isValidEmailAddress(email);
		Assert.assertFalse(Validator.isValidEmailAddress(email));

		email = "email.@ok.ok";
		Validator.isValidEmailAddress(email);
		Assert.assertFalse(Validator.isValidEmailAddress(email));

		email = "email.@ok.o";
		Validator.isValidEmailAddress(email);
		Assert.assertFalse(Validator.isValidEmailAddress(email));

		email = "email.@ok.okokk";
		Validator.isValidEmailAddress(email);
		Assert.assertFalse(Validator.isValidEmailAddress(email));

		email = null;
		Validator.isValidEmailAddress(email);
		Assert.assertFalse(Validator.isValidEmailAddress(email));
	}

	@Test
	public void givenNotValidRole_whenValidate_False() {
		String paramId = "email.@ok.ok";
		Validator.isValidEmailAddress(paramId);
		Assert.assertFalse(Validator.isValidRoleID("5"));
		Assert.assertFalse(Validator.isValidRoleID("0"));
		Assert.assertFalse(Validator.isValidRoleID(null));
		Assert.assertFalse(Validator.isValidRoleID("wqdqwdq"));
	}

	@Test
	public void givenNotValidName_whenValidate_False() {
		String name = "1Name";
		Assert.assertFalse(Validator.isValidName(name));
		name = ".Name";
		Assert.assertFalse(Validator.isValidName(name));
	}

	@Test
	public void givenValidName_whenValidate_False() {
		String name = "N1d";
		Assert.assertTrue(Validator.isValidName(name));

		name = "Name-1";
		Assert.assertTrue(Validator.isValidName(name));

		name = "Name-12";
		Assert.assertTrue(Validator.isValidName(name));

	}

}
