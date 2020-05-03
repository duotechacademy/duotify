package io.duotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.duotech.utilities.Driver;

public class UserDetailsPage {
	
	
	public UserDetailsPage () {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (name = "email")
    public WebElement emailInputBox;

}
