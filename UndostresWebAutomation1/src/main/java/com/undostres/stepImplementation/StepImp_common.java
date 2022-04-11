package com.undostres.stepImplementation;

import static com.undostres.utilities.DriverClass.driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.undostres.utilities.BaseUtil;

public class StepImp_common {

	private static Logger log = Logger.getLogger(StepImp_undostres_mobileRecharge.class);
	private final BaseUtil baseUtil;
	JavascriptExecutor js;
	static WebDriverWait wait = null;
	Actions action;

	public StepImp_common() {
		PageFactory.initElements(driver, this);
		baseUtil = new BaseUtil();
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);

	}

	@FindBy(id = "undostres_logo")
	private List<WebElement> companyLogo;
	
	@FindBy(css = "div.logIn>.menu-navlogout")
	private WebElement logoutBtn;
	
	@FindBy(css = "button#wzrk-confirm")
	private WebElement okButtonOnAllowNotification;
	

	public String getCurrentPageUrl() {
		BaseUtil.waitForPageReadyState();
		return driver.getCurrentUrl();
	}
	
	public void clickLogout() {
		if(driver.findElements(By.cssSelector("button#wzrk-confirm")).size()>0) {
			baseUtil.waitForClickable(okButtonOnAllowNotification);
			okButtonOnAllowNotification.click();
		}
		logoutBtn.click();
	}

}
