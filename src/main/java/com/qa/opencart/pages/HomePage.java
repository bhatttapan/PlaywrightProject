package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	//1. String Locators-OR
	
	private String searchbox = "//input[@name='search']";
	private String searchButton="//span[@class='input-group-btn']";
	private String pageHeader = "//div[@id='content']/h1";
	private String myAccountLink = "//span[text()='My Account']";
	private String logInLink = "//a[text()='Login']";
	
	
    //2. take constructor
	
	public HomePage(Page page) {
		this.page=page;
	}
	
	//3. page actions or methods
	
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("The title of the page is :"+title);
		return title;
	}
	
	public String getHomePageUrl() {
		String url = page.url();
		System.out.println("The url of the page is :"+url);
		return url;
	}
	
	public String doSearch(String ProductName) throws InterruptedException {
		page.fill(searchbox, ProductName);
		page.click(searchButton);
		Thread.sleep(3000);
		String pageHeaderText = page.textContent(pageHeader);
		System.out.println("the header of the page is :"+pageHeaderText);
		return pageHeaderText;
	}
	
	public LogInPage navigateToLoginPage()
	{
		page.click(myAccountLink);
		page.click(logInLink);
		return new LogInPage(page);
	}
}
