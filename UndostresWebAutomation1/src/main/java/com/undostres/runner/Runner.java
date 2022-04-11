package com.undostres.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.ExtentProperties;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/mobileRecharge/mobileRecharge_cc.feature",
		glue = "com.undostres.stepdef", 
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}, 
		dryRun = true, 
		strict = true,
		tags = "@QA_TEST", 
		monochrome = true)


public class Runner extends AbstractTestNGCucumberTests {
	@BeforeClass
	public static void setup() {
		ExtentProperties extent = ExtentProperties.INSTANCE;
		extent.setReportPath("target/cucumber-reports/report"+System.currentTimeMillis()+".html");
		extent.setReportPath("target/cucumber-reports/report.html");
	}
}
