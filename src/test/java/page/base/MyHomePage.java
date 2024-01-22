package page.base;

import com.force.base.ProjectHooks;
import com.force.config.ConfigurationManager;

import io.cucumber.java.en.When;

public class MyHomePage extends ProjectHooks{
	

	@When("Click Leads Tab in My Home Page")
	public MyLeadsPage clickLeadsTab() {
		click(locateElement(ConfigurationManager.configuration().myHomeLeads()));
		return new MyLeadsPage();
	}

	
	
	
}
