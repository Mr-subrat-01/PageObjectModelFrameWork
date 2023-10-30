package com.tests;

import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.Hooks;

public class LoginTest extends Hooks{
	@Test
	public void loginWithValidCredential() {
		LoginPage page = new LoginPage(driver);
		page.loginIntoApp("https://demo.guru99.com/v2/", "mngr47659", "12345@123");
	}
}
