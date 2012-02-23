package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.pages.ContactUs;
import com.example.pages.FlipkartHomePage;

public class HomePageVerification {
	
	private WebDriver driver = new FirefoxDriver();
	FlipkartHomePage homePage;
	ContactUs contactUsPage;
	
	@BeforeTest
	public void setUp()
	{
		driver.navigate().to("http://www.flipkart.com");
		homePage = PageFactory.initElements(driver, FlipkartHomePage.class);
		contactUsPage = PageFactory.initElements(driver, ContactUs.class);
		
	}
	
	@Test(dependsOnMethods = "contactUSTest")
	public void verifyLogin()
	{
		homePage.login();
	}
	
	@Test (dependsOnMethods = "contactUSTest")
	public void verifySearch()
	{
		homePage.searchFor("Revolution 2020");
	}

	@Test
	public void contactUSTest() throws InterruptedException
	{
		contactUsPage.SetEmailAddress("this is smaple emailid@gmail.com");
		Thread.sleep(5000);
	}
	
	
	
}
