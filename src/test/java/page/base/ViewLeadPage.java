package page.base;

import com.force.base.ProjectHooks;
import com.force.config.ConfigurationManager;

import io.cucumber.java.en.When;

public class ViewLeadPage extends ProjectHooks{
	
	@When("Verify the View Lead Page Title")
	public ViewLeadPage verifyTitle() {
		verifyPartialTitle(ConfigurationManager.configuration().viewLeadTitle());
		return this;
	}

	
	
}
