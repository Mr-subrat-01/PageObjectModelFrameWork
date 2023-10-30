package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.CommonUtilities;

public class LoginPage extends CommonUtilities{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	public By userIdTextbox = By.name("uid");
	public By passwordTextbox = By.name("password");
	public By loginButton = By.name("btnLogin");
	
	
	public void loginIntoApp(String url,String userid, String password) {
		navigate(url);
		typeText(userIdTextbox, userid);
		typeText(passwordTextbox, password);
		click(loginButton);
	}
	
}
