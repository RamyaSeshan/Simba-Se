/*
 * MIT License
 *
 * Copyright (c) 2022 TestLeaf
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.force.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.force.config.ConfigurationManager;
import com.force.utility.DataLibrary;

public class ProjectHooks extends SeleniumBase  {

	/**
	 * Will be invoked before once for every test suite execution and create video folder and the reporting
	 * @author TestLeaf
	 */
	@BeforeSuite
	public void initSuite() {
		startReport();
	}

	
	/**
	 * Will be invoked before once for every test case execution and
	 * a) will launch the browser based on config
	 * b) create reporting structure
	 * c) store login state (if configured)
	 * d) create context, page
	 * e) set default time out based on config
	 * f) maximize and load the given URL
	 * @author TestLeaf
	 */
	@BeforeMethod
	public void init() {
		try {

			// Set the extent report node for the test
			setNode();
			
			// Launch Browser
			startApp(false, ConfigurationManager.configuration().baseUrl());


		} catch (Exception e) {
			reportStep("The browser and/or the URL could not be loaded as expected", "fail");
		}
	}

	@BeforeClass(alwaysRun = true)
	public void startTestcaseReporting() {
		startTestCase();
	}

	/**
	 * Will be invoked after once for every test case execution and
	 * a) video & tracing will be created in the given folder
	 * b) result will be published
	 * @author TestLeaf
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		try {
			quit();
			endResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		return DataLibrary.readExcelData(dataFileName);
	}



}
