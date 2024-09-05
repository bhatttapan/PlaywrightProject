package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.*;
//import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LogInPage;

public class BaseTest {
	
	PlaywrightFactory pf;
	Page page;
	protected HomePage homepage;
	public Properties prop;
	protected LogInPage loginpage;
	
	@BeforeTest
	public void setUp() {
		pf= new PlaywrightFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(prop);
		homepage = new HomePage(page);
	}
	

	 @AfterTest() public void tearDown() { 
		 page.context().browser().close(); 
		 }
	

}
