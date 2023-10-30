package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * <p>This  class consist of Re-usable helper / utility methods</p>
 * @Author - Subrat Kumar
 * @Version 1.0
 * @See External Reference
 */
public class CommonUtilities {
	public Properties configData;
	public WebDriver driver;
	
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
	public void LunchBrowser() {
		if(configData.getProperty("browser.name").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", configData.getProperty("browser.executable"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else {
			//			For Other Browser
		}
	}
	
	/*
	 * <p>This Method is close the browser</p>
	 */
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) {
		CommonUtilities comm= new CommonUtilities();
		comm.readConfig();
		comm.LunchBrowser();
		comm.closeBrowser();
	}
}	
