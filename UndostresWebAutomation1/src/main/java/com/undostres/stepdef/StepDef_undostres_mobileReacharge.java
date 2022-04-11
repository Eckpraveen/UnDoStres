package com.undostres.stepdef;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.undostres.stepImplementation.StepImp_undostres_mobileRecharge;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_undostres_mobileReacharge {

	private static Logger log = Logger.getLogger(StepDef_undostres_mobileReacharge.class);
	private final StepImp_undostres_mobileRecharge stepImp_undostres_mobileRecharge;

	public StepDef_undostres_mobileReacharge() {
		stepImp_undostres_mobileRecharge = new StepImp_undostres_mobileRecharge();
	}

	@When("Verify undostres logo is displayed on home screen")
	public void verify_undostres_logo_is_displayed_on_screen() throws InterruptedException {
		assertThat(stepImp_undostres_mobileRecharge.isUndostresLogoDisplayed()).as("UNDOSTRES Logo is not displayed")
				.isTrue();
		log.info("UNDOSTRES Logo is displayed on displayed home page.");
	}

	@Then("Verify {string} text label displayed on container")
	public void verify_text_displayed_on_screen(String expTextLabel) throws InterruptedException {
		String actText = stepImp_undostres_mobileRecharge.getTopContainerLabelText();
		assertThat(actText).as("Expected text label is " + expTextLabel + " but found " + actText).isEqualTo(actText);
		log.info("'" + actText + "' text label is dispalyed on Mobile Recharge container.");
	}

	@Then("User enter the {string} as {string} from text field")
	public void user_enter_the_as_from_text_field(String fieldName, String inputValue) {
		if (fieldName.equalsIgnoreCase("Numero de celular")) {
			stepImp_undostres_mobileRecharge.enterCellPhoneNumberOnTopContainer(inputValue);
			log.info(inputValue + " cell number is entered.");
		} else
			fail(fieldName + " is not dispalyed on Mobile recharge container");
	}

	@Then("User click on {string} field on displayed mobile recharge container")
	public void user_click_on_field_on_displayed_mobile_recharge_container(String fieldName)
			throws InterruptedException {
		if (fieldName.equalsIgnoreCase("Monto de Recarga")) {
			stepImp_undostres_mobileRecharge.clickAtRechargeAmountField(fieldName);
			log.info("Recharge Amount(Monto de Recarga) field is displayed successfully");
		} else
			fail(fieldName + " is not displayed on Mobile recharge container");

	}

	@Then("Verify suggestion modal is displayed")
	public void verify_suggestion_modal_is_displayed() {
		assertThat(stepImp_undostres_mobileRecharge.isSuggestionModalDisplayed())
				.as("suggestion modal is not dispalyed").isTrue();
		log.info("Suggestion modal is displayed successfully");
	}

	@Then("User select the {string} as {string} from dropdown options")
	public void user_select_the_as_from_dropdown_options(String operator, String requiredOperator) {
		stepImp_undostres_mobileRecharge.clickAtOperator();
		stepImp_undostres_mobileRecharge.selectOperatorFromOperatorList(requiredOperator);
	}

	@Then("User click on {string} tab on suggestion modal")
	public void user_click_on_tab_on_suggestion_modal(String tab) {
		if (Stream.of("Recarga Saldo", "Paquete Internet", "Paquete Sin Limite", "Internet Ilimitado")
				.anyMatch(tab::equalsIgnoreCase)) {
			stepImp_undostres_mobileRecharge.clickAtGivenTabOnSuggestionModal(tab);
			log.info(tab + " is displayed successfully on suggestion modal");
		} else
			fail(tab + " is not displayed on suggestion modal");
	}

	@Then("User select ${string} on suggestion modal")
	public void user_select_on_suggestion_modal(String amount) throws InterruptedException {
		stepImp_undostres_mobileRecharge.selectRechargeAmount(amount);
		log.info("$" + amount + " amount is selected successfully for mobile recharge");
	}

	@Then("User click on {string} button on displayed mobile recharge container")
	public void user_click_on_btn_on_displayed_mobile_recharge_container(String btnName) throws InterruptedException {
		if (btnName.equalsIgnoreCase("Siguiente")) {
			stepImp_undostres_mobileRecharge.clickAtContinueButton();
			log.info(btnName + "/continue button is clicked successfully");
		} else
			fail(btnName + " button is not found at Mobile recharge container");
	}

	@Then("User click on {string} payment and choose {string}")
	public void user_click_on_payment_and_choose(String optionName, String subOption) {
		if (optionName.equalsIgnoreCase("Tarjeta")) {
			stepImp_undostres_mobileRecharge.clickAtPaymentOption(optionName);
			log.info("Uesr successfully clicked at " + optionName);
			stepImp_undostres_mobileRecharge.clickAtGivenCardPaymentSubOptionAtPaymentPage(subOption);
			log.info(subOption + " is selected for card payemnt");
		} else
			fail(optionName + " is not found at Payment page");
	}

	@Then("User enter {string} in {string} text field at card panel")
	public void user_enter_GivenTextAt_text_field(String inputText, String fieldName) {
		if (fieldName.equalsIgnoreCase("Numero de celular")) {
			stepImp_undostres_mobileRecharge.enterTextInCardNumberFieldAtCardPanel(inputText);
		} else if (fieldName.equalsIgnoreCase("Mes")) {
			stepImp_undostres_mobileRecharge.enterTextInCardExpirationMonthFieldAtCardPanel(inputText);
		} else if (fieldName.equalsIgnoreCase("Año")) {
			stepImp_undostres_mobileRecharge.enterTextInExpirationYearFieldAtCardPanel(inputText);
		} else if (fieldName.equalsIgnoreCase("CVV")) {
			stepImp_undostres_mobileRecharge.enterTextInCvvFieldAtCardPanel(inputText);
		} else if (fieldName.equalsIgnoreCase("correo electronico")) {
			stepImp_undostres_mobileRecharge.enterTextInEmailFieldAtCardPanel(inputText);
		} else
			fail(fieldName + " is not found at Card panel");
		log.info(fieldName + " text is entered successfully at card panel");
	}

	@Then("Verify {string} button is enabled")
	public void verify_button_is_enabled(String buttonName) {
		if (buttonName.equalsIgnoreCase("Pagar con Tarjeta")) {
			stepImp_undostres_mobileRecharge.isPayWithCardButtonEnabled();
		} else if (buttonName.equalsIgnoreCase("Acceso")) {
			stepImp_undostres_mobileRecharge.isLoginBtnEnabled();
		} else
			fail(buttonName + " is not displayed on Payment page, Unable verify if it's enabled.");
		log.info(buttonName + " is enabled.");
	}

	@Then("User click on {string} button")
	public void user_click_on_button(String buttonName) {
		if (buttonName.equalsIgnoreCase("Pagar con Tarjeta")) {
			stepImp_undostres_mobileRecharge.clickPayWithCardButton();
		} else if (buttonName.equalsIgnoreCase("Acceso")) {
			stepImp_undostres_mobileRecharge.clickLoginButton();
		} else
			fail(buttonName + " is not displayed on Payment page, Unable verify if it's enabled.");
		log.info(buttonName + " button is clicked successfully.");
	}

	@Then("{string} modal should get displayed")
	public void panel_should_get_displayed(String modalName) {
		if (modalName.equalsIgnoreCase("Registration/Login")) {
			stepImp_undostres_mobileRecharge.isRegistartionLoginPanelDisplayed();
		} else
			fail(modalName + " is not displayed on Payment page");
		log.info(modalName + " modal is displayed on screen.");
	}

	@Then("Enter {string} and {string} on displayed panel")
	public void enter_and_on_displayed_panel(String username, String password) {
		stepImp_undostres_mobileRecharge.enterUserName(username);
		log.info(username + " is entered in 'Correo Electrónico / Teléfono móvil' text field");
		stepImp_undostres_mobileRecharge.enterPassword(password);
		log.info(password + " is entered in 'Contraseña' text field");
	}

	@Then("user click on captcha checkbox")
	public void user_click_on_captcha_checkbox() {
		stepImp_undostres_mobileRecharge.checkCaptcha();
		log.info("CAPTCHA is verified successfully.");
	}

	@Then("Verify {string} message is dispalyed")
	public void verify_message_is_dispalyed(String expText) {
		assertThat(stepImp_undostres_mobileRecharge.getRechargeSuccessMessage()).isEqualToIgnoringCase(expText);
		log.info("Recharge successful : " + expText);
		log.info("SUMMARY : " + stepImp_undostres_mobileRecharge.getConfirmationSummary());
		// stepImp_undostres_mobileRecharge.selectTheFirstCardOption();-- If Payment
		// card is addition limit is exhausted make sure to delete the cards
	}
}
