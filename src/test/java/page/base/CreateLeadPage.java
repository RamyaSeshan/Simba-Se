package page.base;

import com.force.base.ProjectHooks;
import com.force.config.ConfigurationManager;
import com.force.data.dynamic.FakerDataFactory;

import io.cucumber.java.en.When;

public class CreateLeadPage extends ProjectHooks{
	
	@When("Type company name in Create Lead Page")
	public CreateLeadPage typeCompanyName() {
		type(locateElement(ConfigurationManager.configuration().createLeadCompanyName()),FakerDataFactory.getCompanyName());
		return this;
	}

	@When("Type first name in Create Lead Page")
	public CreateLeadPage typeFirstName() {
		type(locateElement(ConfigurationManager.configuration().createLeadFirstName()),FakerDataFactory.getFirstName());
		return this;
	}
	
	@When("Type last name in Create Lead Page")
	public CreateLeadPage typeLastName() {
		String lastName = FakerDataFactory.getLastName();
		type(locateElement(ConfigurationManager.configuration().createLeadLastName()),lastName);
		reportStep("The last name:"+lastName+" is typed", "PASS");
		return this;
	}
	
	@When("Source is selected in Create Lead Page")
	public CreateLeadPage selectSource() {
		String source = FakerDataFactory.getSource();
		selectDropDownUsingValue(locateElement(ConfigurationManager.configuration().createLeadSource()), source);
		reportStep("The source: "+source+" is selected", "PASS");
		return this;
	}
	
	@When("Click Create Lead button in Create Lead Page")
	public ViewLeadPage clickCreateLead() {
		click(locateElement(ConfigurationManager.configuration().createLeadSubmit()));
		return new ViewLeadPage();
	}
	
	@When("Fill all mandatory fields in Create Lead and Submit")
	public ViewLeadPage typeAllMandatoryAndSubmit() {
		return
			typeCompanyName()
			.typeFirstName()
			.typeLastName()
			.selectSource()
			.clickCreateLead();
	}
}
