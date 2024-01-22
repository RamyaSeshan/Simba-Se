package tests.ui;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.force.base.ProjectHooks;

import page.base.LoginPage;

public class TC102_CreateLead extends ProjectHooks{
	
	@BeforeTest
	public void setReportValues() {
		testcaseName = "TC102 - Create Lead";
		testDescription = "Create a new lead";
		authors = "Babu";
		category = "UI";
	}
	
	@Test
	public void testLogin() {
		new LoginPage()
		.doLogin()
		.clickCRMSFA()
		.clickLeadsTab()
		.clickCreateLeadLink()
		.typeAllMandatoryAndSubmit()
		.verifyTitle();
	}

}
