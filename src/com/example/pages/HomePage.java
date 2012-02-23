package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.example.config.UtilFunctions;



public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}

	public void selectBrand(String brand) throws InterruptedException {
		new org.openqa.selenium.support.ui.Select(driver.findElements(
				By.className("control-brand")).get(0))
				.selectByVisibleText(brand);
		Thread.sleep(5000);
	}

	public void compareLaptops() throws InterruptedException {
	
		driver.findElement(By.className("fk-logo-img")).click();
		UtilFunctions.MouseHover(driver, driver.findElement(By.id("fk-header-tab-computer")));
		driver.findElement(By.linkText("Compare Laptops")).click();
		Assert.assertTrue(driver.findElements(By.className("print-hide"))
				.get(4).getText()
				.contains("You can add upto 4 Computers to compare"));
	}

}
