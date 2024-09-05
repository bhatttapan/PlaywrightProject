package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LogInPage {

	private Page page;
	
	//1. String locators
	
	private String emailTextBox = "//input[@id='input-email']";
	private String passwordTextBox = "//input[@id='input-password']";
	private String loginButton = "//input[@value='Login']";
	private String fogotLink = "(//a[text()='Forgotten Password'])[1]";
	private String logOutLink = "(//a[text()='Logout'])[2]";
	
	//2. call constructor
	public LogInPage(Page page) {
		this.page = page;
	}
	
	//3. Now declare actions and methods:
	public String getLogInPageTitle() {
		return page.title();
	}
	
	public boolean isForgetPwdLinkExist() {
		return page.isVisible(fogotLink);
	}
	
	public boolean doLogIn(String appUsername, String appPassword) throws InterruptedException {
		System.out.println("Crednetials are: "+appUsername+" : "+appPassword);
		page.fill(emailTextBox, appUsername);
		page.fill(passwordTextBox, appPassword);
		page.click(loginButton);
		Thread.sleep(5000);
		if(page.isVisible(logOutLink)) {
			System.out.println("user is loggedin successfuly");
			return true;
		}
		return false;
	}
	
	
}
