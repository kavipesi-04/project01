package com.step;

import java.io.IOException;

import com.base.Utility;
import com.page.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinition extends Utility{
	
	LoginPage lp;
	
	@Given("User is on facebook login page")
	public void user_is_on_facebook_login_page() {
		browserLaunch("https://www.facebook.com/login/");
	}
	@Given("User Enter username and password")
	public void user_enter_username_and_password() throws IOException, InterruptedException {
		Thread.sleep(3000);
		lp=new LoginPage();
		lp.getUserName().sendKeys(getUserNameData(1,0));
		lp.getPassword().sendKeys(getPasswordData(1,1));
	}
	@Given("user click login button")
	public void user_click_login_button() {
		
		lp.getLoginBtn().click();
	}
	@Then("User verify error message")
	public void user_verify_error_message() {
		verifyLogin();
	}


}
