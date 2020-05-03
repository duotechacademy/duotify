package io.duotech.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.duotech.utilities.DatabaseUtils;

public class DBOnlyStepDefs {
	
	List<String> newList;
	
	@Given("I send a query to datbase to retrieve playlist names for username {string}")
	public void i_send_a_query_to_datbase_to_retrieve_playlist_names_for_username(String string) {
			
		 List<List<Object>> queryResultList = DatabaseUtils.getQueryResultList("select name  from playlists where owner = '"+string+"'");
		
		
		 newList =new ArrayList<String>();
		 
		 for (List<Object> list : queryResultList) {
			newList.add(list.get(0).toString());
		}
		 
		 System.out.println(newList);

		
	}

	@Then("The database results for the query should have the following")
	public void the_database_results_for_the_query_should_have_the_following(List<String> names) {
		List<String> names2 = new ArrayList<String>(names);
		
		Collections.sort(names2);
		Collections.sort(newList);
			assertEquals(names2, newList);
	}

	
	
	

}
