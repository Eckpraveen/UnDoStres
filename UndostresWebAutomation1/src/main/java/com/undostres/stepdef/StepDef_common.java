package com.undostres.stepdef;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.log4j.Logger;

import com.undostres.stepImplementation.StepImp_common;
import com.undostres.stepImplementation.StepImp_undostres_mobileRecharge;
import com.undostres.utilities.Log;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDef_common extends Log{
	private static Logger log = Logger.getLogger(StepDef_common.class);

	private final StepImp_undostres_mobileRecharge stepImp_undostres_mobileRecharge;
	private final StepImp_common stepImp_common;

	public StepDef_common() {
		stepImp_undostres_mobileRecharge = new StepImp_undostres_mobileRecharge();
		stepImp_common = new StepImp_common();
	}

	@Given("^The test execution is running on \"([^\"]*)\"$")
	public void the_test_execution_is_running_on(String env) throws Throwable {
		Log.startTestCase("");
		log.info("Test Execution is running at " + env + " environment");
	}

	@Then("Verfy user should be moved on {string} page")
	public void verfy_user_should_be_moved_on_page(String pageString) {
		String actURL = stepImp_common.getCurrentPageUrl();
		assertThat(actURL).as(actURL + " doesn't contain '" + pageString + "' string").contains(pageString);
		log.info(actURL + " contains '" + pageString + "' string");
	}
	
	@And("User click on Logout")
	public void user_click_on_logout(){
		stepImp_common.clickLogout();
		Log.endTestCase("");
	}
}
