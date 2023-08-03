package com.fsm.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.fsm.utilities.UtilityClass;

public class BaseClass {

	public Properties prop;
	public WebDriver driver;

	public BaseClass() {
		prop = new Properties();
		File file = new File(System.getProperty("user.dir") + "");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver initilizeBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilityClass.implicitWaitTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilityClass.pageLoadTime));
		driver.manage().deleteAllCookies();

		String user = "Employee";
		if (user.equalsIgnoreCase(prop.getProperty("User"))) {
			driver.get(prop.getProperty("EmployeeURL"));
		} else {
			driver.get(prop.getProperty("CitizenURL"));
		}

		return driver;
	}
}
