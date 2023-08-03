package com.fsm.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fsm.baseClass.BaseClass;
import com.fsm.pageObjects.EmployeeHomePage;
import com.fsm.pageObjects.EmployeeLoginPage;

public class EmployeeLoginPageTest extends BaseClass {

	public EmployeeLoginPageTest() {
		super();
	}
	
	public WebDriver driver;
	EmployeeLoginPage employeeLoginPage;
	EmployeeHomePage employeehomePage;
	
	@BeforeMethod
	public void setUp() {
		driver = initilizeBrowser(prop.getProperty("Browser"));
		employeeLoginPage = new EmployeeLoginPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void FSM_TC_Login_002(){
		employeeLoginPage.enterLoginCredentials(prop.getProperty("Username"), prop.getProperty("Password"), prop.getProperty("City"));
		employeehomePage = employeeLoginPage.clickOnContinueButton();
		Assert.assertEquals(employeehomePage.getHomePageURL(), testDataProp.getProperty("EmployeeHomePageURL"));
	}

	
}
