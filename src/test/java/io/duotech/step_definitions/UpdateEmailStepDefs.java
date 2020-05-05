package io.duotech.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.duotech.pages.HomePage;
import io.duotech.pages.UserDetailsPage;
import io.duotech.utilities.DatabaseUtils;
import io.duotech.utilities.Driver;

public class UpdateEmailStepDefs {
	
	String expected;
	
	@Given("I log in as a user {string}")
	public void i_log_in_as_a_user(String string) {
		HomePage hp = new HomePage();
		hp.loginUsername.sendKeys(string);
		hp.loginPassword.sendKeys("akmalbekk");
		hp.loginButton.click();


	}

	@When("I update the the email for {string} in the database")
	public void i_update_the_the_email_for_in_the_database(String string) {
		List<List<Object>> queryResultList = DatabaseUtils.getQueryResultList("select email from users where username='"+string+"'");
		
		expected = queryResultList.get(0).get(0).toString().toLowerCase();
		
		System.out.println();
		
		DatabaseUtils.updateQuery("UPDATE users SET email = '"+expected+"' WHERE username = '"+string+"'");


	}

	@Then("The email should also change in the user details page")
	public void the_email_should_also_change_in_the_user_details_page() {
            
		Driver.getDriver().get("http://test2-env.eba-3s8p7zn5.us-east-2.elasticbeanstalk.com/updateDetails.php?");
        String actual = new UserDetailsPage().emailInputBox.getAttribute("value");
             
        assertEquals(expected, actual);
             

	}

}
