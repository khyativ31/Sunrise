package com.sr.tests;

import org.testng.annotations.Test;

import com.sr.base.SRBase;

public class AdminLogin extends SRBase {

	@Test
	public void validateLogin() {
		adminLoginPage.verifyAdminLoginPageIsPresent();
		adminLoginPage.verifyLoginWithoutCredentials();
		adminLoginPage.verifyLoginWithInvalidCredentials();
		adminLoginPage.login();
	}
}

