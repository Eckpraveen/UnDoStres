
package com.undostres.stepdef;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.undostres.utilities.LaunchApp;
import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks extends LaunchApp {

	LaunchApp app = new LaunchApp();
	Scenario scenario = null;

	@Before
	public void initDriver() {
		app.applaunch();
	}

	@After
	public void embedScreenshotafter(Scenario scenario) throws IOException {
		try {
			driver.quit();
		} finally {
			driver.quit();
		}
	}
}
