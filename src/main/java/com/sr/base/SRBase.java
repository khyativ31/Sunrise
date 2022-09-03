package com.sr.base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.sr.pages.AdminLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SRBase {

	public static WebDriver webDriver;
	public static String configPath = "./resources/config.properties";
	public static String url = getConfigValue("url");
	public static String adminLoginUserName = getConfigValue("adminUserName");
	public static String adminLoginPassword = getConfigValue("adminPassword");

	public static AdminLoginPage adminLoginPage = new AdminLoginPage();

	public void initWebDriver() {
		initObjects();
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get(url);
	}

	private void initObjects() {
		adminLoginPage = new AdminLoginPage();
	}

	public static String getConfigValue(String key) {
		return getValue(configPath, key);
	}

	private static String getValue(String filePath, String key) {
		FileReader reader;
		Properties p = null;
		try {
			reader = new FileReader(filePath);
			p = new Properties();
			p.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(key);
	}

	public static boolean isElementPresent(By by) {
		return webDriver.findElements(by).size() > 0;
	}

	public boolean isElementPresentWithinTime(By by, int timeout) {
		boolean found = false;
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(by)) {
				found = true;
				break;
			} else {

			}
		}
		return found;
	}

	public static WebElement getWebElement(By by) {
		return webDriver.findElement(by);
	}

	public static WebElement getWebElement(String xPath, Object... objs) {
		xPath = String.format(xPath, objs);
		return webDriver.findElement(By.xpath(xPath));
	}
}