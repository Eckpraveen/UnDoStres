package com.undostres.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.sjavac.Log;

public class BaseUtil extends DriverClass {

	static Properties automationProps;
	private WebDriverWait wait = null;
	static JavascriptExecutor js;

	static {
		try {
			loadProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BaseUtil() {
		wait = new WebDriverWait(driver, 10);
	}

	public static void takescreenshot() {
		String screenshotname = "target/screen";
		try {
			File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File(String.format("%s.png", screenshotname)));
			// Reporter.addScreenCaptureFromPath("data:image/jpeg;file," + srcfile);

		} catch (Exception e) {
			System.out.println("Exception while taking ScreenShot " + e.getMessage());
		}
	}

	public static String excelreader(String path, int a, int cell1) throws IOException {
		FileInputStream fis = new FileInputStream(new File(path));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(a);
		XSSFCell cell = row.getCell(cell1 - 1);

		String rsdata = "";
		try {
			rsdata = cell.getStringCellValue();
		} catch (Exception ex) {
			rsdata = cell.getRawValue() + "";
		}

		return rsdata;
	}

	public static void loadProperties() throws IOException {
		automationProps = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\praveendas\\Downloads\\Undostres\\UndostresWebAutomation1\\src\\main\\resources\\automation.properties");
		automationProps.load(fis);
	}

	public static String getProperty(String propertyName) {
		return automationProps.getProperty("undostres.web.qa");
	}

	public void waitForClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void waitForVisible(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static WebElement highlightInGreen(WebElement elmt) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid green'", elmt);
			Thread.sleep(800);
			js.executeScript("arguments[0].style.border=''", elmt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return elmt;
	}

	public static void waitForPageReadyState() {
		boolean loaded = false;
		js = (JavascriptExecutor) driver;
		int waitTimeInMillis = 2000;
		int loop = 50;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < loop; i++) {
			try {
				if (js.executeScript("return document.readyState").equals("complete")) {
					loaded = true;
					break;
				}
			} catch (JavascriptException e) {
				Log.warn("waitForPageReady Page Loading!");
				sleep(waitTimeInMillis);
			}
			long endTime = System.currentTimeMillis();
			long totalTimeTaken = endTime - startTime;
			if (loaded) {
				Log.info("waitForPageReadyState loaded successfully : " + totalTimeTaken + " millis");
			}
		}

	}

	public static void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
