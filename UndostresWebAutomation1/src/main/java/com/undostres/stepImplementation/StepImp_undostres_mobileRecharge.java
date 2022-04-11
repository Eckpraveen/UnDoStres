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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.undostres.utilities.BaseUtil;

public class StepImp_undostres_mobileRecharge {

	private static Logger log = Logger.getLogger(StepImp_undostres_mobileRecharge.class);
	private final BaseUtil baseUtil;
	JavascriptExecutor js;
	static WebDriverWait wait = null;
	Actions action;

	public StepImp_undostres_mobileRecharge() {
		PageFactory.initElements(driver, this);
		baseUtil = new BaseUtil();
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);

	}
//Page Factory Approach
	@FindBy(id = "undostres_logo")
	private List<WebElement> companyLogo;

	@FindBy(css = "div.container-main-top div.box.menuitem[to-do='mobile']>h1.name")
	private WebElement topContainerLabel;

	@FindBy(xpath = "//label[contains(string(.),'Número de celular (10 dígitos)')]/preceding-sibling::*")
	private WebElement cellPhoneNumberField;

	@FindBy(xpath = "(//label[text()='Operador']/preceding-sibling::input)[1]")
	private WebElement operatorField;

	@FindBy(xpath = "(//label[contains(string(.),'Monto de Recarga')]/preceding-sibling::input)[1]")
	private WebElement rechargeAmountField;

	@FindBy(css = "button[perform='payment'].button.buttonRecharge[data-qa='celular-pay']")
	private WebElement continueBtn;

	@FindBy(css = "form#payment-form input[data-openpay-card='card_number']")
	private WebElement cardNumberFieldAtCardPanel;

	@FindBy(css = "form#payment-form input[data-openpay-card='expiration_month']")
	private WebElement expirationMonthFieldAtCardPanel;

	@FindBy(css = "form#payment-form input[data-openpay-card='expiration_year']")
	private WebElement expirationYearFieldAtCardPanel;

	@FindBy(css = "form#payment-form input[data-openpay-card='cvv2']")
	private WebElement cvvFieldAtCardPanel;

	@FindBy(css = "form#payment-form input[type='email'][name='txtEmail']")
	private WebElement emailFieldAtCardPanel;

	@FindBy(css = "button.buttonPayment.pay4.limit.PulsiIndicator")
	private WebElement payWithCardBtnOnPaymentPage;

	@FindBy(css = "div.modal.fade.in div.modal-dialog")
	private WebElement registrationORLoginPanel;

	@FindBy(css = "input#usrname")
	private WebElement usernameTextBox;

	@FindBy(css = "input#psw")
	private WebElement passwordtextBox;

	@FindBy(css = "button#loginBtn")
	private WebElement loginButton;

	@FindBy(css = "//div[@id='cardsBox']/table/tbody/tr[1]")
	private WebElement firstCardOptionAtCardTable;

	@FindBy(css = "div.visual-message")
	private WebElement rechargeSuccessTextMessage;

	@FindBy(css = "div.flex-row.flex-space-between.date-folio")
	private WebElement confirmationSummary;

	public static void waitForClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void waitForVisible(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	@SuppressWarnings("static-access")
	public boolean isUndostresLogoDisplayed() throws InterruptedException {
		waitForClickable(companyLogo.get(0));
		baseUtil.highlightInGreen(companyLogo.get(0));
		return companyLogo.size() > 0;
	}

	public String getTopContainerLabelText() throws InterruptedException {
		waitForVisible(topContainerLabel);
		BaseUtil.highlightInGreen(topContainerLabel);
		return topContainerLabel.getText().trim();
	}

	public void enterCellPhoneNumberOnTopContainer(String cellNumber) {
		waitForClickable(cellPhoneNumberField);
		cellPhoneNumberField.sendKeys(cellNumber);
		BaseUtil.highlightInGreen(cellPhoneNumberField);
	}

	public void clickAtOperator() {
		waitForClickable(operatorField);
		BaseUtil.highlightInGreen(operatorField);
		operatorField.click();
	}

	public void selectOperatorFromOperatorList(String operatorName) {
		WebElement operator = driver.findElement(
				By.xpath("//label[text()='Operador']/following-sibling::div//li[@data-show='" + operatorName + "']"));
		waitForVisible(operator);
		BaseUtil.highlightInGreen(operator);
		waitForClickable(operator);
		operator.click();
	}

	public void clickAtRechargeAmountField(String fieldName) throws InterruptedException {
		waitForClickable(rechargeAmountField);
		BaseUtil.highlightInGreen(rechargeAmountField);
		rechargeAmountField.click();
		Thread.sleep(1200);
	}

	public boolean isSuggestionModalDisplayed() {
		return driver.findElements(By.cssSelector("div.suggestion")).size() > 0;
	}

	public void clickAtGivenTabOnSuggestionModal(String tab) {
		WebElement tabWl = driver.findElement(
				By.xpath("//div[@class='suggestion']/div[@class='category-tab ']/div[contains(text(),'" + tab + "')]"));
		waitForClickable(tabWl);
		BaseUtil.highlightInGreen(tabWl);
		tabWl.click();
	}

	public void selectRechargeAmount(String rechargeAmt) throws InterruptedException {
		WebElement rechAmtWl = driver.findElement(By.xpath(
				"//ul[@class='category-list  cat1']/li[@class='category-suggest'][@data-name='" + rechargeAmt + "']"));
		waitForClickable(rechAmtWl);
		BaseUtil.highlightInGreen(rechAmtWl);
		rechAmtWl.click();
		BaseUtil.sleep(1000);
	}

	public void clickAtContinueButton() {
		waitForClickable(continueBtn);
		BaseUtil.highlightInGreen(continueBtn);
		continueBtn.click();
		BaseUtil.sleep(1000);
		BaseUtil.waitForPageReadyState();
	}

	public void clickAtPaymentOption(String paymentMode) {
		WebElement paymentOption = driver
				.findElement(By.xpath("//div[@id='paymentMethods']//p[text()='" + paymentMode + "']"));
		waitForClickable(paymentOption);
		BaseUtil.highlightInGreen(paymentOption);
		paymentOption.click();
		BaseUtil.sleep(300);
	}

	public void clickAtGivenCardPaymentSubOptionAtPaymentPage(String subOptionAtCardPayment) {
		WebElement subOption = driver.findElement(By.xpath(
				"//div[@id='paymentMethods']//p[text()='Tarjeta']/ancestor::div[contains(@class,'panel-custom-desktop')]//span[contains(text(),'"
						+ subOptionAtCardPayment + "')]"));
		waitForClickable(subOption);
		BaseUtil.highlightInGreen(subOption);
		subOption.click();
		BaseUtil.sleep(300);
	}

	public void enterTextInCardNumberFieldAtCardPanel(String inputValue) {
		waitForClickable(cardNumberFieldAtCardPanel);
		BaseUtil.highlightInGreen(cardNumberFieldAtCardPanel);
		cardNumberFieldAtCardPanel.sendKeys(inputValue);
	}

	public void enterTextInCardExpirationMonthFieldAtCardPanel(String inputValue) {
		waitForClickable(expirationMonthFieldAtCardPanel);
		BaseUtil.highlightInGreen(expirationMonthFieldAtCardPanel);
		expirationMonthFieldAtCardPanel.sendKeys(inputValue);
	}

	public void enterTextInExpirationYearFieldAtCardPanel(String inputValue) {
		waitForClickable(expirationYearFieldAtCardPanel);
		BaseUtil.highlightInGreen(expirationYearFieldAtCardPanel);
		expirationYearFieldAtCardPanel.sendKeys(inputValue);
	}

	public void enterTextInCvvFieldAtCardPanel(String inputValue) {
		waitForClickable(cvvFieldAtCardPanel);
		BaseUtil.highlightInGreen(cvvFieldAtCardPanel);
		cvvFieldAtCardPanel.sendKeys(inputValue);
	}

	public void enterTextInEmailFieldAtCardPanel(String inputValue) {
		waitForClickable(emailFieldAtCardPanel);
		BaseUtil.highlightInGreen(emailFieldAtCardPanel);
		emailFieldAtCardPanel.sendKeys(inputValue);
	}

	public boolean isPayWithCardButtonEnabled() {
		waitForVisible(payWithCardBtnOnPaymentPage);
		BaseUtil.highlightInGreen(payWithCardBtnOnPaymentPage);
		return payWithCardBtnOnPaymentPage.isEnabled();
	}

	public void clickPayWithCardButton() {
		waitForClickable(payWithCardBtnOnPaymentPage);
		BaseUtil.highlightInGreen(payWithCardBtnOnPaymentPage);
		payWithCardBtnOnPaymentPage.click();
		BaseUtil.waitForPageReadyState();
	}

	public boolean isRegistartionLoginPanelDisplayed() {
		waitForVisible(registrationORLoginPanel);
		BaseUtil.highlightInGreen(registrationORLoginPanel);
		return registrationORLoginPanel.isDisplayed();
	}

	public void enterUserName(String usernameTxt) {
		waitForClickable(usernameTextBox);
		usernameTextBox.clear();
		usernameTextBox.sendKeys(usernameTxt);
	}

	public void enterPassword(String passwordTxt) {
		waitForClickable(passwordtextBox);
		passwordtextBox.clear();
		passwordtextBox.sendKeys(passwordTxt);
	}

	public void checkCaptcha() {
		driver.switchTo().frame(0);
		BaseUtil.sleep(2000);
		driver.findElements(By.xpath("//div[@id='rc-anchor-container']//span[contains(@class,'recaptcha-checkbox')]"))
				.get(0).click();
		BaseUtil.sleep(2000);
		driver.switchTo().defaultContent();
	}

	public void clickLoginButton() {
		waitForClickable(loginButton);
		BaseUtil.highlightInGreen(loginButton);
		loginButton.submit();
		BaseUtil.sleep(2000);
		BaseUtil.waitForPageReadyState();
	}

	public boolean isLoginBtnEnabled() {
		waitForVisible(loginButton);
		return loginButton.isEnabled();
	}

	public String getRechargeSuccessMessage() {
		return rechargeSuccessTextMessage.getText();
	}

	public void selectTheFirstCardOption() {
		waitForClickable(firstCardOptionAtCardTable);
		firstCardOptionAtCardTable.click();
	}

	public String getConfirmationSummary() {
		waitForVisible(confirmationSummary);
		return confirmationSummary.getText().trim();
	}
}
