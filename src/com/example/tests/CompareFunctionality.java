package com.example.tests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.example.config.DriverInitializer;
import com.example.config.PropertyFileReader;
import com.example.pages.HomePage;


public class CompareFunctionality {
	private WebDriver driver;
	

	@BeforeClass
	public void setUp() throws IOException {
		PropertyFileReader propertyReader = new PropertyFileReader(
				"App.properties");
		DriverInitializer init = new DriverInitializer();
		driver = init.getAppropriateDriver(propertyReader);
		driver.navigate().to(propertyReader.getProperty("url"));
	}

	@Test(description = "Functionality:Compare Laptop")
	public void CompareLaptops() throws InterruptedException {
		HomePage hompepage = new HomePage(driver);
		hompepage.compareLaptops();
		hompepage.selectBrand("HP");
		driver.findElements(By.tagName("STRONG")).get(0).click();
		hompepage.selectBrand("Dell");
		driver.findElements(By.tagName("SPAN")).get(13).click();
		Assert.assertTrue(driver
				.findElements(
						By.linkText("HP Mini 110 Series 110-3729TU Netbook"))
				.get(1).getText()
				.contains("HP Mini 110 Series 110-3729TU Netbook"));
		Assert.assertTrue(driver
				.findElements(
						By.linkText("Dell Inspiron M101Z AMD/ 2GB/ 320GB/ DOS Netbook"))
				.get(1).getText()
				.contains("Dell Inspiron M101Z AMD/ 2GB/ 320GB/ DOS Netbook"));
	}

	@AfterClass
	public void tearDown() throws IOException {
		driver.quit();
	}
}
