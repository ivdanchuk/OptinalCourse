package com.java.model.command.login;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.java.model.constant.Path;
import com.java.model.service.UserService;

public class LoginCommandTest {
	HttpServletRequest request;
	HttpSession session;
	LoginCommand loginCommand;
	UserService userService;

	@Before
	public void setUp() {
		session = mock(HttpSession.class);
		loginCommand = new LoginCommand();

		request = mock(HttpServletRequest.class);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("login")).thenReturn("tutor111@gmail.com");
		when(request.getParameter("password")).thenReturn("1");

		userService = mock(UserService.class);
		when(userService.getValidUser(anyString(), anyString(), Mockito.any(StringBuilder.class))).thenReturn(null);
	}

	@Test
	public void givenLogoutCommand__whenLogoutCommand_thenPage() {
		String actualPage = loginCommand.executeWithUserService(request, userService);
		String expectedPage = Path.PAGE__ERROR_PAGE;
		Assert.assertEquals(actualPage, expectedPage);
	}
}
