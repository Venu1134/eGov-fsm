package com.fsm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmployeeHomePage {

	WebDriver driver;
	public EmployeeHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getHomePageURL(String expectedURL) {
		boolean actualStatus = false;
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equals(expectedURL)) {
			actualStatus =  true;
		}
		return actualStatus;
	}
}
