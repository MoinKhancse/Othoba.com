package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Drivers.BaseDriver;
//import Pages.LoginPage;
import Pages.RegisterPage;
import Utilities.ExtentFactory;

public class RegistationTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	@Parameters({"url","browserName", "headless"})
	public void openUrl(@Optional("https://www.othoba.com")String url, @Optional("chromium")String browserName,
			@Optional("false")String headless) throws InterruptedException {
		
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:13px\"><b> Othoba.com - Registation </b></p>").assignAuthor("SQA Team").assignDevice("Windows");
		startPlaywright(browserName,headless);
		launchApplication(url);
		
	}
//	@Test(priority = 1)
//	public void signIn() throws InterruptedException {
//		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Login</b></p>");
//		LoginPage log = new LoginPage(page,childTest);
//		log.login();
//		log.homePage();
//	}
	@Test(priority = 0)
	public void registation() throws InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>RegisterPage</b></p>");
		RegisterPage reg = new RegisterPage(page,childTest);
		reg.registerPage();
	}
	
	@AfterClass
	public void afterClass() {
		closePlaywright();
		report.flush();
	}

}
