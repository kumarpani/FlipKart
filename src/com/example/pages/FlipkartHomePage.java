package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartHomePage {
	
	 @FindBy(id = "fk-top-search-box")
	  private WebElement searchBox;
	 	 
	 @FindBy(className="login-required")
	 private WebElement login_Link;

	 
	 @FindBy(id="login_email_id")
	 private WebElement eMail_Textbox;
	 
	 @FindBy(id="login_password")
	 private WebElement password_Textbox;
	 
	  public void searchFor(String text) {
	        searchBox.sendKeys(text);
	        searchBox.submit();
	    }
	  
	  public void login()
	  {
		  login_Link.click();
		  eMail_Textbox.sendKeys("nishuverma@gmail.com");
		  password_Textbox.sendKeys("This is not my password");
//		  password_Textbox.submit();
	  }

}
