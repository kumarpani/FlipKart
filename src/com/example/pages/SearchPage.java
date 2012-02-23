package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	private WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchAMobile(String modelName) {
		driver.findElement(By.className("fk-logo-img")).click();
		driver.findElement(By.id("fk-menuSelIcon")).click();
		driver.findElement(
				By.xpath("/html/body/div/div[2]/div/div/div[4]/div[2]/div/div/form/table/tbody/tr/td[2]/div/div/ul/li[3]"))
				.click();
		driver.findElement(By.id("fk-top-search-box")).clear();
		driver.findElement(By.id("fk-top-search-box")).sendKeys(modelName);
		driver.findElement(By.name("Search")).click();
	}

	public void searchABook(String name) {
//		driver.findElement(By.className("fk-logo-img")).click();
		driver.findElement(By.id("fk-menuSelIcon")).click();
		driver.findElement(
				By.xpath("/html/body/div/div[2]/div/div/div[4]/div[2]/div/div/form/table/tbody/tr/td[2]/div/div/ul/li[2]"))
				.click();
		driver.findElement(By.id("fk-top-search-box")).clear();
		driver.findElement(By.id("fk-top-search-box")).sendKeys(name);
		driver.findElement(By.name("Search")).click();
	}

}
