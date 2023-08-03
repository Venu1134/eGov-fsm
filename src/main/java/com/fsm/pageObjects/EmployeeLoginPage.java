package com.fsm.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeLoginPage {

	WebDriver driver;

	public EmployeeLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "employee-phone")
	private WebElement Username;

	public void enterUsername(String username) {
		Username.sendKeys(username);
	}

	@FindBy(id = "employee-password")
	private WebElement Password;

	public void enterPassword(String password) {
		Password.sendKeys(password);
	}

	@FindBy(id = "person-city")
	private WebElement City;
	@FindBy(xpath = "//*[@class='list-main-card']//span")
	private List<WebElement> CityLists;

	public void selectCity(String city) {
		City.click();

		for (int i = 0; i < CityLists.size(); i++) {
			String actualCity = CityLists.get(i).getText();
			System.out.println("actualCity : " + actualCity);
			if (actualCity.equalsIgnoreCase(city)) {
				CityLists.get(i).click();
				break;
			}
		}
	}

	@FindBy(id = "login-submit-action")
	private WebElement ContinueButton;

	public EmployeeHomePage clickOnContinueButton() {
		ContinueButton.click();
		return new EmployeeHomePage(driver);
	}

	public void enterLoginCredentials(String username, String password, String city) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		City.click();
		for (int i = 0; i < CityLists.size(); i++) {
			String actualCity = CityLists.get(i).getText();
			//System.out.println("actualCity : " + actualCity);
			if (actualCity.equalsIgnoreCase(city)) {
				CityLists.get(i).click();
				break;
			}
		}
	}

	@FindBy(xpath = "//*[@id='client-snackbar']/div")
	private WebElement ErrorMessage;
	public String validateErrorMessage() {
		return ErrorMessage.getText();
	}
}
