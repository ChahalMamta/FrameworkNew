package com.automation.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseWithoutFramework {
	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("https://ui.freecrm.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    
	    driver.findElement(By.name("email")).sendKeys("chahalmamta06@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("Automation@06");
	    driver.findElement(By.xpath("//div[text()='Login']")).submit();
	    
	    Thread.sleep(5000);
	    
	    driver.quit();

}

}