package page.base;

import com.force.base.ProjectHooks;
import com.force.config.ConfigurationManager;

import io.cucumber.java.en.When;

public class HomePage extends ProjectHooks{
	
	
	@When("The logout is clicked")
	public LoginPage clickLogOut() {
		click(locateElement(ConfigurationManager.configuration().logout()));
		return new LoginPage();
	}

	@When("CRM is clicked")
	public MyHomePage clickCRMSFA() {
		click(locateElement(ConfigurationManager.configuration().homeCrmsfa()));
		return new MyHomePage();
	}

	
	
	
}
