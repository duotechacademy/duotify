package io.duotech.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.duotech.pages.HomePage;
import io.duotech.utilities.ConfigReader;
import io.duotech.utilities.DatabaseUtils;
import io.duotech.utilities.Driver;

public class SignUpStepDefs {
	
    
private static String username ;
private static String firstName;
private static String lastName ;
private static String password ;
private static String email;
	
	@Given("I am on homepage")
	public void i_am_on_homepage() {
		
		Driver.getDriver().get(ConfigReader.getConfiguration("url"));


	}

	@When("I click on sign up")
	public void i_click_on_sign_up() {
		HomePage hp = new HomePage();
		hp.signUpLink.click();
	}

	@When("I enter user details and click on sign up button")
	public void i_enter_user_details_and_click_on_sign_up_button() {
		Faker f = new Faker();
		HomePage hp = new HomePage();
		
		username = f.name().username();
		firstName = f.name().firstName();
		lastName = f.name().lastName();
		password = f.internet().password();
		email = f.internet().emailAddress();
		
		
		hp.username.sendKeys(username);
		hp.firstName.sendKeys(firstName);
		hp.lastName.sendKeys(lastName);
		hp.email.sendKeys(email);
		hp.email2.sendKeys(email);
		hp.password.sendKeys(password);
		hp.password2.sendKeys(password);
		hp.signUpButton.click();
		
	}

	@Then("I should land to welcome page")
	public void i_should_land_to_welcome_page() {
	  
	}

	@Then("The user data should be reflected correctly in the database")
	public void the_user_data_should_be_reflected_correctly_in_the_database() {
	    
		List<Map<String, Object>> rs = DatabaseUtils.getQueryResultMap("select * from users where username = '"+username+"'");
		
		assertEquals(username, rs.get(0).get("username"));
		assertEquals(firstName, rs.get(0).get("firstName"));
		assertEquals(lastName, rs.get(0).get("lastName"));
		assertEquals(email, (rs.get(0).get("email").toString().toLowerCase()));

		
	}

}
