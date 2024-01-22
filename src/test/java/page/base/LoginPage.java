package page.base;

import com.force.base.ProjectHooks;
import com.force.config.ConfigurationManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPage extends ProjectHooks{
	
	@When("Type username in Login Page(.*)$")
	public LoginPage typeUserName(String username) {
		type(locateElement(ConfigurationManager.configuration().loginUsername()), username);
		reportStep("Username entered with data "+username, "PASS");
		return this;
	}
	
	@When("Type password in Login Page(.*)$")
	public LoginPage typePassword(String password) {
		type(locateElement(ConfigurationManager.configuration().loginPassword()), password);
		reportStep("Password entered with data "+password, "PASS");
		return this;
	}
	
	@Then("Click Login button")
	public HomePage clickLogin() {
		click(locateElement(ConfigurationManager.configuration().loginButton()));
		reportStep("Login button clicked", "PASS");
		return new HomePage();
	}
	
	@When("Perform login with default values")
	public HomePage doLogin() {
		return 
		typeUserName(ConfigurationManager.configuration().appUserName())
		.typePassword(ConfigurationManager.configuration().appPassword())
		.clickLogin();
	}

}
