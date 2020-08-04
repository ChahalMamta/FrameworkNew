package com.automation.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.Pages.BaseClass;
import com.automation.Pages.LoginPage;
import com.automation.Utility.BrowserFactory;
import com.automation.Utility.Helper;

public class LoginTestCRM extends BaseClass{
	
	@Test
	public void loginApp() {
		
		/*
		 * driver = BrowserFactory.startApplication(driver, "Chrome",
		 * "https://ui.freecrm.com/"); System.out.println(driver.getTitle());
		 */
		
		//2.Using PageFactory and hardcoded data
		/*
		 * LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		 * 
		 * loginPage.loginToCRM("chahalmamta06@gmail.com", "Automation@06");
		 */
		
		//3.using exceldataprovider utility
		
		 logger = report.createTest("LoginToCRM");
		
		 LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		 logger.info("Starting Application");
		 
		 loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		 
		 logger.pass("Login Successful");
		 
		
	}
}
