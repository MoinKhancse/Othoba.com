package Drivers;

import java.util.List;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;

public class BaseDriver {
	public static Playwright playwright;
	public static BrowserType browserType;
	public static Browser browser;
	public static BrowserContext browserContext;
	public static Page page;
	protected ExtentTest test;
	
	
	public static void startPlaywright(String browserName, String headless ) {
		playwright = Playwright.create();
		
		if(browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("msedge") || 
				browserName.equalsIgnoreCase("chromium")) {
			browserType = playwright.chromium();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			browserType = playwright.firefox();
		}
		else {
			browserType = playwright.webkit();
		}
		
		if(headless.equalsIgnoreCase("true")) {
			browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(true).setArgs(List.of("--start-maximized")));
		}
		else {
			browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(false).setArgs(List.of("--start-maximized")));
		}
		
		browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		page = browserContext.newPage();
	}
	
	public static void launchApplication(String url) throws InterruptedException {
		page.navigate(url,new Page.NavigateOptions().setWaitUntil(WaitUntilState.LOAD));
		Thread.sleep(5000);
	}
	
	public void closePlaywright() {
		try {
			page.close();
			browser.close();
			playwright.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	

}
