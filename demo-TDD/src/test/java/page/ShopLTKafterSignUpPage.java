package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;
import common.PageLoad;
import utilities.reportRelated.Log4jManager;

public class ShopLTKafterSignUpPage extends PageBase {

	public static final String LtkafterSignUpURL = "https://www.shopltk.com/auth?code=XmbwvaqxHN85bWiqPQsWKiMsFmGcVbnKeJsqAN6-TjMk3&state=xPKUMeENJ6";
	
	/***** data member *****/
	String actualTitle = driver.getTitle();

	/* ====================Constructor================ */
	public ShopLTKafterSignUpPage() {

		super(LtkafterSignUpURL);
		logger.createNode("user signs up successfully and direct to a blank Page");
		PageFactory.initElements(driver, this);
		Log4jManager.info("user signs up successfully and direct to a blank Page");
	}

	/* =====================Methods======================== */
	public String getTitleText() {

		Log4jManager.info(
				"user signs up successfully and direct to a blank Page");
		PageLoad.wait(3000);
		System.out.println("Actual Page title is " + actualTitle);
		return actualTitle;
	}

}
