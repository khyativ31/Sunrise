package com.sr.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sr.base.SRBase;

public class AdminLoginPage extends SRBase {
	
	By lblSunRiseHomepage = By.xpath("//*[contains(text(),'SUN RISE HOMEPAGE')]");
	By txtUserName = By.xpath("//*[@value='Username']");
	By txtPassword = By.xpath("//*[@value='Password']");
	By btnLogin = By.xpath("//*[@value='Login']");
	By lblRoomBooking = By.xpath("//*[contains(text(),'Room Booking ')]");
	
	public String alertMessageForInvalidCredentails = "Your Login Name or Password is invalid";
	public String invalidUserName = "Test";
	public String invalidPassword = "Test";
	
	public void verifyAdminLoginPageIsPresent() {
		isElementPresentWithinTime(lblSunRiseHomepage, 10);
	}
	
	public void enterUserName(String adminUserName) {
		isElementPresentWithinTime(txtUserName, 10);
		getWebElement(txtUserName).sendKeys(adminUserName);
	}
	
	public void enterPassword (String adminPassword) {
		isElementPresentWithinTime(txtPassword, 10);
		getWebElement(txtPassword).sendKeys(adminPassword);
	}
	
	public void clickLogin() {
		isElementPresentWithinTime(btnLogin, 10);
		getWebElement(btnLogin).click();
	}
	
	public String getTextFromAlertBox() {
		String alertMessage = webDriver.switchTo().alert().getText();
		return alertMessage;
	}
	
	public void verifyTextFromAlertBox() {
		Assert.assertEquals(alertMessageForInvalidCredentails, getTextFromAlertBox(), "Error message not found!!");
	}
	
	public void clickOkFromAlertBox() {
		webDriver.switchTo().alert().accept();
	}
	
	public void verifyLoginWithoutCredentials() {
		clickLogin();
		verifyTextFromAlertBox();
		clickOkFromAlertBox();
	}
	
	public void verifyLoginWithInvalidCredentials() {
		enterUserName(invalidUserName);
		enterPassword(invalidPassword);
		clickLogin();
		verifyTextFromAlertBox();
		clickOkFromAlertBox();
	}
	
	public void verifyPageAfterLogin() {
		isElementPresentWithinTime(lblRoomBooking, 10);
	}
	
	public void login() {
		verifyAdminLoginPageIsPresent();
		enterUserName(adminLoginUserName);
		enterPassword(adminLoginPassword);
		clickLogin();
		verifyPageAfterLogin();
	}
}