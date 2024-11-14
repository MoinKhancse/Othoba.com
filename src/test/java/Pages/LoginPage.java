package Pages;

import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import Utilities.CommonMethod;

public class LoginPage extends CommonMethod{
	Page page;
	ExtentTest test;
	
//	ElementHandle sign;
//	ElementHandle phone;
//	ElementHandle Password;
//	ElementHandle RememberMe_Popup;
//	ElementHandle button;
	
	
	public LoginPage(Page page, ExtentTest test) {
		this.page = page;
		this.test = test;
		
//		this.sign = page.querySelector("//a[@class='login sign-in header-design-color']");
//		this.phone = page.querySelector("//form[@autocomplete='off']//input[@id='PhoneOrEmail_Popup']");
//		this.Password = page.querySelector("//form[@autocomplete='off']//input[@id='Password_Popup']");
//		this.RememberMe_Popup = page.querySelector("//form[@autocomplete='off']//input[@id='RememberMe_Popup']");
//		this.button = page.querySelector("//input[@id='dl-login-inpage']");
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
	
	public void login() throws InterruptedException {
		ElementHandle sign = page.querySelector("//a[@class='login sign-in header-design-color']");
		sign.click();
		timeOut();
		
		ElementHandle phone = page.querySelector("//form[@autocomplete='off']//input[@id='PhoneOrEmail_Popup']");
		try {
			if (phone.isVisible()) {
				phone.fill("01920436373");
				passCase("Phone Number Success");
				timeOut();
				
				ElementHandle Password = page.querySelector("//form[@autocomplete='off']//input[@id='Password_Popup']");
				try {
					if (Password.isVisible()) {
						Password.fill("01717511288");
						passCase("Password Success");
						timeOut();
						
						ElementHandle RememberMe_Popup = page.querySelector("//form[@autocomplete='off']//input[@id='RememberMe_Popup']");
						RememberMe_Popup.click();
						timeOut();
						
						ElementHandle button = page.querySelector("//input[@id='dl-login-inpage']");
						try {
							if (button.isVisible()) {
								passCassWithSC("Login Form Fill Screen Shot","Login Form");
								button.click();
								timeOut(3000);
								passCassWithSC("Login Success","Home Page");
							}
						} catch (Exception e) {
							failCass("Login Button Success","Login");
						}
					}
				} catch (Exception e) {
					failCass("Password Locator Not Found","Fail Password");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
	
	public void homePage() throws InterruptedException {
		String scriptButtom ="window.scrollTo(0,document.body.scrollHeight)";
		page.evaluate(scriptButtom);
		timeOut(3000);
		
		String scriptTop= "window.scrollTo(0,0)";
		page.evaluate(scriptTop);
		timeOut(3000);
		
		ElementHandle Recommended = page.querySelector("//h2[normalize-space()='Recommended For You']");
		Recommended.scrollIntoViewIfNeeded();
		timeOut(3000);
		
		ElementHandle New_arrivals = page.querySelector("//a[normalize-space()='New arrivals']");
		New_arrivals.click();
		timeOut(3000);
		
		ElementHandle Top_Rated = page.querySelector("//a[normalize-space()='Top Rated']");
		Top_Rated.click();
		timeOut(3000);
		
		ElementHandle Featured = page.querySelector("//a[normalize-space()='Featured']");
		Featured.click();
		timeOut(3000);
		
		String TopButton = "window.scrollTo(0,0)";
		page.evaluate(TopButton);
		timeOut(3000);
		
		ElementHandle cart_count = page.querySelector("//span[@class='cart-count text-white']");
		cart_count.click();
		timeOut(3000);
		
		ElementHandle close = page.querySelector("//a[normalize-space()='Close']");
		close.click();
		timeOut(3000);
		
		ElementHandle compare = page.querySelector("//i[@class='w-icon-compare header-design-color']");
		compare.click();
		
		ElementHandle Browse_Categories = page.querySelector("//span[normalize-space()='Browse Categories']");
		Browse_Categories.hover();
		timeOut(3000);
		
		ElementHandle Pharmacy = page.querySelector("//li[@class='has-submenu']//a[normalize-space()='Pharmacy']");
		Pharmacy.hover();
		timeOut(3000);
		
		ElementHandle health = page.querySelector("//ul[@class='megamenu customeMenuScroll']//ul//li//a[normalize-space()='health']");
		health.click();
		timeOut(3000);
		
		ElementHandle products_orderby = page.querySelector("//select[@id='products-orderby']");
		products_orderby.selectOption("NewArrivals");
		timeOut(3000);
		
	}

}
