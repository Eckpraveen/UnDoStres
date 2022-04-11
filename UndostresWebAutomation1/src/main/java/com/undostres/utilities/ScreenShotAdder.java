package com.undostres.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.vimalselvam.cucumber.listener.Reporter;

public class ScreenShotAdder extends DriverClass{
	public static void addScreenshot() {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			String src = ts.getScreenshotAs(OutputType.BASE64);
			Reporter.addScreenCaptureFromPath("data:image/jpeg;BASE64," + src);
		} catch (Exception e) {
			System.out.println("Exception while taking ScreenShot " + e.getMessage());
		}
	}
}
