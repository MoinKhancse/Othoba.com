package Pages;


import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import Utilities.CommonMethod;

public class RegisterPage extends CommonMethod{
	
	Page page;
	ExtentTest test;
	public RegisterPage(Page page, ExtentTest test) {
		this.page = page;
		this.test = test;
	}
	
	public void passCase(String message) {
		test.pass("<p style =\"color:#85BC63;font-size:15px\">"+message+"</p>");
	}
	
	public void passCassWithSC(String message, String scName) {
		test.pass("<p style =\" color:#85BC63; font-size:15px\"><b>"+message+"</b></p>");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screen Shots/"+scName+".png")).setFullPage(true));
		String dest = System.getProperty("user.dir")+"/Screen Shots/" + "" +scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	
	public void failCass(String message, String scName) {
		test.fail("<p style =\" color:#FF5353; font-size:15px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screen Shots/"+scName+".png")).setFullPage(true));
		String dest = System.getProperty("user.dir")+"/Screen Shots/" + "" +scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	
	public void registerPage() throws InterruptedException {
		ElementHandle reg = page.querySelector("//a[normalize-space()='Register']");
		reg.click();
		
		ElementHandle Phone = page.querySelector("//input[@id='Phone']");
		Phone.fill("01920436373");
		passCase("Phone Number Success");
		timeOut();
		
		ElementHandle Email = page.querySelector("//input[@id='Email']");
		Email.fill("moinkhan4363@gmail.com");
		passCase("Email Success");
		timeOut();
		
		ElementHandle gender = page.querySelector("//label[normalize-space()='Male']");
		gender.click();
		timeOut();
		
		ElementHandle FirstName = page.querySelector("//input[@id='FirstName']");
		FirstName.fill("Moin");
		timeOut();
		
		ElementHandle LastName = page.querySelector("//input[@id='LastName']");
		LastName.fill("khan");
		timeOut();
		
		ElementHandle DateOfBirthDay = page.querySelector("//select[@name='DateOfBirthDay']");
		DateOfBirthDay.selectOption("26");
		timeOut();
		
		ElementHandle DateOfBirthMonth = page.querySelector("//select[@name='DateOfBirthMonth']");
		DateOfBirthMonth.selectOption("3");
		timeOut();
		
		ElementHandle DateOfBirthYear = page.querySelector("//select[@name='DateOfBirthYear']");
		DateOfBirthYear.selectOption("1997");
		timeOut();
		
		ElementHandle Password = page.querySelector("//input[@id='Password']");
		Password.fill("01717511288");
		timeOut();
		
		ElementHandle ConfirmPassword = page.querySelector("//input[@id='ConfirmPassword']");
		ConfirmPassword.fill("01717511288");
		timeOut();
		
		ElementHandle button = page.querySelector("//button[@id='register-button']");
		button.click();
		passCassWithSC("Click Button Success","Button Click");
		timeOut(5000);
		
		ElementHandle sign = page.querySelector("//a[@class='login sign-in header-design-color']");
		sign.click();
		timeOut();
		
		ElementHandle phone = page.querySelector("//input[@id='PhoneOrEmail_Popup']");
		phone.fill("01920436373");
		timeOut();
		
		ElementHandle Password1 = page.querySelector("//input[@id='Password_Popup']");
		Password1.fill("01717511288");
		timeOut();
		
		ElementHandle rem = page.querySelector("//input[@id='RememberMe_Popup']");
		rem.click();
		timeOut();
		
		ElementHandle button1 = page.querySelector("//button[@id='dl-login-try']");		
		passCassWithSC("Click Button Success","Button Click");
		button1.click();
		timeOut();

	}	

}
