package com.undostres.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchApp extends DriverClass {

	public void applaunch() {

		DesiredCapabilities caps = new DesiredCapabilities();
		String browser = BaseUtil.getProperty("browser");
		// Launch URL
		try {
			if (browser.equalsIgnoreCase("firefox")) {
				System.out.println("Test case is running on FIREFOX");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("internetexplorer")) {
				System.out.println("Test case is running on IE");
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				System.out.println("Test case is running on EDGE");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("opera")) {
				System.out.println("Test case is running on OPERA");
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
			} else {
				System.out.println("Test case is running on default browser : Chrome");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Driver initialization failed", e);
		}

		System.out.println("Launching URL : " + BaseUtil.getProperty("undostres.web.qa"));
		driver.get(BaseUtil.getProperty("undostres.web.qa"));
	}
}
