package tests.ui;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.force.base.ProjectHooks;

import page.base.LoginPage;

public class TC101_LoginTest extends ProjectHooks{
	
	@BeforeTest
	public void setReportValues() {
		testcaseName = "TC101 - Login";
		testDescription = "Just test login";
		authors = "Babu";
		category = "UI";
	}
	
	@Test
	public void testLogin() {
		new LoginPage().doLogin();
	}

}
