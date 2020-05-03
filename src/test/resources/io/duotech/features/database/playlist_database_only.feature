Feature: Playlist names

@db_only
	Scenario: Verify playlist names for specific user in the database
	
	  Given I send a query to datbase to retrieve playlist names for username "akmal_instructor"
	  Then The database results for the query should have the following
	  		
	  			|Headphone Test        |
	  			|Electronic            |
	  	    |Underground Techno    |
	  	    |Drum and Bass         |
	  	    |UK Garage             |
	  	    |Night Drive           |
	  	    |Progressive House     |
					|Reggaeton             | 
	        |Beach House           |