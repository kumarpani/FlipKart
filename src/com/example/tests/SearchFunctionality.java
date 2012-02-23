package com.example.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.config.DriverInitializer;
import com.example.config.PropertyFileReader;
import com.example.config.UtilFunctions;
import com.example.pages.SearchPage;

public class SearchFunctionality {

	private WebDriver driver;
	SearchPage searchPage;

	@BeforeTest(alwaysRun = true)
	public void setUp() throws IOException {
		PropertyFileReader propertyReader = new PropertyFileReader(
				"App.properties");
		DriverInitializer init = new DriverInitializer();
		driver = init.getAppropriateDriver(propertyReader);
		driver.navigate().to(propertyReader.getProperty("url"));
		searchPage = new SearchPage(driver);
	}

	@Test(description = "Functionality: Search for book", groups = { "search" }, dependsOnMethods = { "searchForBooksUsingArray" })
	public void SearchBook() throws InterruptedException, IOException {
		searchPage.searchABook("Steve Jobs");
		Assert.assertTrue(driver
				.findElements(
						By.linkText("Steve Jobs: The Exclusive Biography"))
				.get(0).getText()
				.contains("Steve Jobs: The Exclusive Biography"));
	}
	

	@Test(description = "Functionality: Search for mobile", groups = { "search" }, dependsOnMethods = { "searchForMobilesUsingArray" })
	public void SearchMobile() throws InterruptedException, IOException {
		searchPage.searchAMobile("samsung galaxy s2");
	}


	@DataProvider(name = "TestData1")
	public Object[][] createBookSearchData(){
		return new Object[][] {
				{"Sherlock Holmes"},				
				{"Revolution 2020"},
				{"I Too Had A Love Story"}
		};
	}
	
	@DataProvider(name = "TestData2")
	public Object[][] createMobileSearchData(){
		return new Object[][] {
				{"Nokia N 70"},				
				{"Samsung Galaxy S2"},
				{"iPhone 5"}
		};
	}
	
	@Test(dataProvider = "TestData1" , groups = { "search" })	
	public void searchForBooksUsingArray(String item){
		SearchPage searchPage = new SearchPage(driver);
		searchPage.searchABook(item);
	}
	
	@Test(dataProvider = "TestData2" , groups = { "search" })	
	public void searchForMobilesUsingArray(String item){
		SearchPage searchPage = new SearchPage(driver);
		searchPage.searchAMobile(item);
	}
	

	@AfterTest(alwaysRun = true)
	public void tearDown() throws IOException {
		driver.close();
	}
}
