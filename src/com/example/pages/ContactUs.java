package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs {
	
	@FindBy(id = "cs_r_0_v")
	  private WebElement eMailAddress_Textbox;

	
	@FindBy(linkText = "Contact Us")
	  private WebElement linkToContactPage;

	
	public void SetEmailAddress(String emailId)
	{
		linkToContactPage.click();
		eMailAddress_Textbox.sendKeys(emailId);
	}

}
