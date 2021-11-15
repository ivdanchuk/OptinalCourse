package com.java.test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java.model.DBCPDataSource;
import com.java.model.DaoException;
import com.java.model.dao.UserDaoImpl;
import com.java.model.entity.User;

public class UserDaoImplTest {
	private static Connection connection = DBCPDataSource.getConnection();
	private static UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
	private static List<User> users;
	private static User user;
	private static User testUser;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			connection = DBCPDataSource.getConnection();
			userDaoImpl = UserDaoImpl.getInstance();
			users = new ArrayList<>();
			user = new User();
			testUser = new User(-1, "test_fname", "test_lname", "test_email", "test_pass", 1l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		connection.close();
	}

	@Before
	public void setUp() throws Exception {
		users.clear();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void whenFindEntity_then_User() {
		try {
			user = userDaoImpl.findEntityById(connection, 4l);
			user = userDaoImpl.findEntity(connection, user);
			System.out.println(user);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void whenFindEntityById_then_User() {
		try {
			user = userDaoImpl.findEntityById(connection, 1l);
			System.out.println(user);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void givenEmptyList_whenFindAll_thenGetAllUsersFromDB() {
		try {
			users = userDaoImpl.findAll(connection);
			System.out.println(users);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void givenUserId_whenDeleteById_thenDeleteUser() {
		try {
			users = userDaoImpl.findAll(connection);
			System.out.println(users);
			userDaoImpl.deleteById(connection, 1l);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
			users = userDaoImpl.findAll(connection);
			System.out.println(users);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void givenUser_whenCreate_thenCreatedUser() {
		try {
			userDaoImpl.create(connection, testUser);
			long id = testUser.getId();
			user = userDaoImpl.findEntityById(connection, id);
			System.out.println(user);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
	public void givenUserO_whenUpdate_thenUpdatedUser() {
		try {
			user = userDaoImpl.findEntityById(connection, 2l);
			System.out.println(user);

			user.setF_name(user.getF_name() + " updated");
			userDaoImpl.update(connection, user);
			user = userDaoImpl.findEntityById(connection, 2l);
			System.out.println(user);

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
