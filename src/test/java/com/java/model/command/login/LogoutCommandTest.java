package com.java.model.command.login;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogoutCommandTest {
	HttpServletRequest request;
	HttpSession session;
	LogoutCommand logoutCommand;

	@Before
	public void setUp() {
		request = mock(HttpServletRequest.class);
		session = mock(HttpSession.class);
		logoutCommand = new LogoutCommand();
		when(request.getSession()).thenReturn(session);
	}

	@Test
	public void givenLogoutCommand__whenLogoutCommand_thenPage() {
		String actualPage = logoutCommand.execute(request);
		String expectedPage = "index.jsp";
		Assert.assertEquals(actualPage, expectedPage);
	}
}
