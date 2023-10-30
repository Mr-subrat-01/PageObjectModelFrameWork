package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*
 * <p>This  class consist of Re-usable helper / utility methods</p>
 * @Author - Subrat Kumar
 * @Version 1.0
 * @See External Reference
 */
public class CommonUtilities {

	WebDriver driver;
	
	public CommonUtilities(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	
	/*
	 * <p>This Method is Click the element on browser</p>
	 */
	public void click(By locaterType) {
		driver.findElement(locaterType).click();
	}
	
	/*
	 * <p>This Method is Send Text or Type something on browser</p>
	 */
	public void typeText(By locaterType,String text) {
		driver.findElement(locaterType).sendKeys(text);
	}
	
	/*
	 * <p>This Method is used to Set the url of the browser</p>
	 */
	public void navigate(String url) {
		driver.get(url);
	}
	
//	public static void main(String[] args) {
//		CommonUtilities comm= new CommonUtilities();
//		comm.readConfig();
//		comm.LunchBrowser();
//		comm.navigate("https://demo.guru99.com/v2/");
//		comm.typeText(By.name("uid") , "mngr47659");
//		comm.typeText(By.name("password") , "12345@123");
//		comm.click(By.name("btnLogin"));
//		comm.closeBrowser();
//	}
}	
