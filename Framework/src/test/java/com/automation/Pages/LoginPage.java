package com.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
     WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		 driver = ldriver;
	}
	
	@FindBy(name="email") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//div[text()='Login']") WebElement loginButton;
	
	public void loginToCRM(String unameApplication, String passApplication) {
		uname.sendKeys(unameApplication);
		pass.sendKeys(passApplication);
		loginButton.click();
	}
	
}
