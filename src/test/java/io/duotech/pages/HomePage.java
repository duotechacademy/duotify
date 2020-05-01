package io.duotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.duotech.utilities.Driver;

public class HomePage {
	
	
	public HomePage () {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (id = "hideLogin")
    public WebElement signUpLink;
	
	
	@FindBy (id = "username")
    public WebElement username;
	
	@FindBy (id = "firstName")
    public WebElement firstName;
	
	@FindBy (id = "lastName")
    public WebElement lastName;
	
	
	@FindBy (id = "email")
    public WebElement email;
	
	
	@FindBy (id = "email2")
    public WebElement email2;
	
	@FindBy (id = "password")
    public WebElement password;
	
	@FindBy (id = "password2")
    public WebElement password2;

	@FindBy (name = "registerButton")
    public WebElement  signUpButton;

}
