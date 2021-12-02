package com.java.model.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.java.model.command.login.LoginCommand;
import com.java.model.command.login.LogoutCommand;

public class ActionFactoryTest {
	ActionFactory actionFactory;
	HttpServletRequest request;

	@Before
	public void setUp() {
		request = mock(HttpServletRequest.class);
		actionFactory = new ActionFactory();
	}

	@Test
	public void givenEmptyCommandParam__whenActionCommand_thenEmptyCommand() {
		when(request.getParameter("command")).thenReturn("");
		IActionCommand actual = actionFactory.defineCommand(request);
		Assert.assertTrue(actual instanceof EmptyCommand);
	}

	@Test
	public void givenLoginCommandParam__whenActionCommand_thenLoginCommand() {
		when(request.getParameter("command")).thenReturn("login");
		IActionCommand actual = actionFactory.defineCommand(request);
		Assert.assertTrue(actual instanceof LoginCommand);
	}

	@Test
	public void givenLogoutCommandParam__whenActionCommand_thenLogoutCommand() {
		when(request.getParameter("command")).thenReturn("logout");
		IActionCommand actual = actionFactory.defineCommand(request);
		Assert.assertTrue(actual instanceof LogoutCommand);
	}
}
