Feature: Sign Up verification with database


	Scenario: Verify sign up data with db
	
	  Given I am on homepage
	  When I click on sign up
	  And I enter user details and click on sign up button
	  Then I should land to welcome page
	  And The user data should be reflected correctly in the database
	