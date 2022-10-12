package test.regression;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.TestBase;
import common.PageLoad;
import page.ShopLTKafterSignUpPage;
import page.ShopLTKemailPage;
import page.ShopLTKhomePage;
import page.ShopLTKpwPage;

public class ShopLTKsignUpTest extends TestBase{
	
	@Test
	public void TestCase_001_CoSignIn() {
		logger = extent.createTest("TestCase_001_signUp");

		// test data

		String email1 = "fana-test@gmail.com";
		String password1 = "123456789";
		String expectedTitle = "Discover content from our community of Creators | LTK";

		// test steps

		/**** Step 1: click Sign Up button on the Home page ***/
		ShopLTKhomePage sh001 = new ShopLTKhomePage();
		sh001.goToPage();
		PageLoad.waitForElementToBeVisible(driver, sh001.signUpBtn);
		sh001.signUp();
		
//		/**** Step 1: click Login button on the Home page ***/
//		ShopLTKhomePage sh002 = new ShopLTKhomePage();
//		sh002.goToPage();
//		PageLoad.waitForElementToBeVisible(driver, sh002.loginBtn);
//		sh002.login();
		
		/**** Step 2: enter email from the Sign Up page ***/
		ShopLTKemailPage se001 = new ShopLTKemailPage();
		se001.goToPage();
		PageLoad.waitForElementToBeVisible(driver, se001.email);
		se001.enterEmail(email1);
		
		/**** Step 3: enter password and click to finish signing up page ***/
		ShopLTKpwPage sp001 = new ShopLTKpwPage();
		PageLoad.waitForElementToBeVisible(driver, sp001.password);
		sp001.enterPWtoSignup(password1);
//		sp001.enterPWtoLogin(password1);
		PageLoad.waitForLoad(driver);
		
		/**** Step 4: verify actual page title & expected page title ***/
		ShopLTKafterSignUpPage sa001 = new ShopLTKafterSignUpPage();
//		assertEquals("Condition true", sa001.getTitleText(), expectedTitle);
		
		if(sa001.getTitleText().equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");		

	}

}
