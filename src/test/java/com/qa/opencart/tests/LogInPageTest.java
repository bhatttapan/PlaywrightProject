package com.qa.opencart.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.pages.LogInPage;

public class LogInPageTest extends BaseTest {
	
	//Properties prop;
	
	@Test(priority=1)
	public void logInPageNavigationTest() {
		loginpage = homepage.navigateToLoginPage();
		String logInPageTitle = loginpage.getLogInPageTitle();
		Assert.assertEquals(logInPageTitle, AppConstant.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void forgotPwdLinkExistTest() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(loginpage.isForgetPwdLinkExist());
	}
	
	@Test(priority=3)
	public void appLoginTest() throws InterruptedException {
		Assert.assertTrue(loginpage.doLogIn(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}

}
