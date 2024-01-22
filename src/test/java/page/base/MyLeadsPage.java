package page.base;

import com.force.base.ProjectHooks;
import com.force.config.ConfigurationManager;

import io.cucumber.java.en.When;

public class MyLeadsPage extends ProjectHooks{
	

	@When("Click Create Lead Link in My Leads Page")
	public CreateLeadPage clickCreateLeadLink() {
		click(locateElement(ConfigurationManager.configuration().myLeadsCreateLeadLink()));
		return new CreateLeadPage();
	}

	
	
	
}
