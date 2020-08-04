package com.automation.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.Utility.BrowserFactory;
import com.automation.Utility.ConfigDataProvider;
import com.automation.Utility.ExcelDataProvider;
import com.automation.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel; 
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up reports and application getting ready", true);
		
	  excel = new ExcelDataProvider();
	  config = new ConfigDataProvider();
	  
	  ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File("./Reports/LoginToCRM"+Helper.getCurrentDateTime()+".html"));
	  report = new ExtentReports();
	  report.attachReporter(reporter);
	  
	  Reporter.log("Setting done - Test can be started", true);
	}
	@BeforeClass
	public void setUp() {
		Reporter.log("Trying to start browser and Getting application ready", true);
		
		BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
		
		Reporter.log("Browser and application is up and running", true);
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE) {
			// For capturing ss on failure using ITestresult interface
			//Helper.captureScreenshot(driver);
			
			// For attaching ss in extent reports on failure	
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}else if(result.getStatus()==ITestResult.SUCCESS){
			
			logger.pass("Test Success", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		
		report.flush();
		
		Reporter.log("Test Completed >> reports generated", true);
		
		//This is to demo git push
	}
}
