package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Hooks {
	public Properties configData;
	public WebDriver driver;
	
	
	
	@BeforeSuite
	public void beforeSuite() {
		readConfig();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		lunchBrowser();
	}
	
	@AfterMethod
	public void afterMethod() {
		closeBrowser();
	}
	
	public void afterSuit() {
		
	}
	
	
	/*
	 * <p>This Method is close the browser</p>
	 */
	public void closeBrowser() {
		driver.quit();
	}
	
	/*
	 * <p>This Method reads the config and parses the same into key value pairs</p>
	 */
	public void readConfig() {
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File("./src/test/resources/config.properties"));
			configData = new Properties();
			configData.load(fis);
						System.out.println(configData.getProperty("browser.name"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//			e.printStackTrace();
			System.out.println("Unable to read Config"+e.getMessage());
		}
	}
	/*
	 * <p>This Method Lunch the browser depending the configuration</p>
	 */
	public void lunchBrowser() {
		if(configData.getProperty("browser.name").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", configData.getProperty("browser.executable"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else {
			//			For Other Browser
		}
	}
	
}
