package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;

public class HomePageTest extends BaseTest {

	
	
	@Test(priority=1)
	public void getHomePageTitleTest() {
		String actualHeaderTitle = homepage.getHomePageTitle();
		Assert.assertEquals(actualHeaderTitle, AppConstant.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void getHomePageURLTest() {
		String actualurlText = homepage.getHomePageUrl();
		Assert.assertEquals(actualurlText, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object[][] getDataForProduct() {
		return new Object[][] {
			{"macbook"},
			{"iphone"},
			{"samsung"}
		};
	}
	
	
	@Test(dataProvider="getDataForProduct",priority=3)
	public void doSearchTest(String ProductName) throws InterruptedException {
		//Thread.sleep(5000);
		String actualSearchText = homepage.doSearch(ProductName);
		Assert.assertEquals(actualSearchText, "Search - " + ProductName);
		
	}
	
	//Search - iphone
	
	
	
}
