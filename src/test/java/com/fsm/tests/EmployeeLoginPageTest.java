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
	String testcase;
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
		testcase = "Check Employee is able to login with valid username, valid password and valid city";
		employeeLoginPage.enterLoginCredentials(prop.getProperty("Username"), prop.getProperty("Password"), prop.getProperty("City"));
		employeehomePage = employeeLoginPage.clickOnContinueButton();
		Assert.assertEquals(employeehomePage.getHomePageURL(), testDataProp.getProperty("EmployeeHomePageURL"));
	}
	
	@Test
	public void FSM_TC_Login_003() {
		testcase = "Check Employee is able to login with valid username, valid password and invalid city";
		employeeLoginPage.enterLoginCredentials(prop.getProperty("Username"), prop.getProperty("Password"), testDataProp.getProperty("InvalidCity"));
		employeeLoginPage.clickOnContinueButton();
		Assert.assertEquals(employeeLoginPage.validateErrorMessage(), testDataProp.getProperty("InvalidErrorMessage"));
	}
	
	@Test
	public void FSM_TC_Login_004() {
		testcase = "Check Employee is able to login with valid username, invalid password and valid city";
		employeeLoginPage.enterLoginCredentials(prop.getProperty("Username"), testDataProp.getProperty("InvalidPassword"), prop.getProperty("City"));
		employeeLoginPage.clickOnContinueButton();
		Assert.assertEquals(employeeLoginPage.validateErrorMessage(), testDataProp.getProperty("InvalidErrorMessage"));
	}
	
	@Test
	public void FSM_TC_Login_005() {
		testcase = "Check Employee is able to login with invalid username, valid password and valid city";
		employeeLoginPage.enterLoginCredentials(testDataProp.getProperty("InvalidUsername"), prop.getProperty("Password"), prop.getProperty("City"));
		employeeLoginPage.clickOnContinueButton();
		Assert.assertEquals(employeeLoginPage.validateErrorMessage(), testDataProp.getProperty("InvalidErrorMessage"));
	}
	
	@Test
	public void FSM_TC_Login_006() {
		testcase = "Check Employee is able to login with invalid username, invalid password and valid city";
		employeeLoginPage.enterLoginCredentials(testDataProp.getProperty("InvalidUsername"), testDataProp.getProperty("InvalidPassword"), prop.getProperty("City"));
		employeeLoginPage.clickOnContinueButton();
		Assert.assertEquals(employeeLoginPage.validateErrorMessage(), testDataProp.getProperty("InvalidErrorMessage"));
	}
	
	@Test
	public void FSM_TC_Login_007() {
		testcase = "Check Employee is able to login with invalid username, invalid password and invalid city";
		employeeLoginPage.enterLoginCredentials(testDataProp.getProperty("InvalidUsername"), testDataProp.getProperty("InvalidPassword"), testDataProp.getProperty("InvalidCity"));
		employeeLoginPage.clickOnContinueButton();
		Assert.assertEquals(employeeLoginPage.validateErrorMessage(), testDataProp.getProperty("InvalidErrorMessage"));
	}
}
