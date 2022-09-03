package com.sr.testbase;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.sr.base.SRBase;

public class SetupSuite_Web extends SRBase {
	
	@BeforeSuite
	public void launchBrowser() {
		initWebDriver();
	}
	
	// @AfterSuite
	public void tearDown() {
		webDriver.quit();
	}
}
