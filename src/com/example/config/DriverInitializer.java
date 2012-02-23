package com.example.config;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverInitializer {

	private ChromeDriverService service;

	public WebDriver getAppropriateDriver(PropertyFileReader propertyReader)
			throws IOException {
		WebDriver driver = null;
		if (propertyReader.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (propertyReader.getProperty("browser").equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else if (propertyReader.getProperty("browser").equalsIgnoreCase(
				"Chrome")) {
			service = new ChromeDriverService.Builder()
					.usingChromeDriverExecutable(
							new File(
									"C:\\Users\\nishanv\\workspace1\\Flipkart_Framework\\chromedriver.exe"))
					.usingAnyFreePort().build();
			service.start();
			driver = new RemoteWebDriver(service.getUrl(),
					DesiredCapabilities.chrome());
		}
		return driver;
	}

}
