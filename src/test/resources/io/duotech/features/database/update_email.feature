Feature: Update email

@db
	Scenario: Verify update by modifying the database
	
	  Given I am on homepage
	  And I log in as a user "akmaldtech"
	  When I update the the email for "akmaldt" in the database
	  Then The email should also change in the user details page
	  		
	  			
