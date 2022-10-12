package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;
import common.PageLoad;
import utilities.reportRelated.Log4jManager;

public class ShopLTKhomePage extends PageBase {

	public static final String LtkURL = "https://www.shopltk.com/";
	
	
	/*****data member*****/
	@FindBy(xpath = "//a[@href='/signup']")
	public WebElement signUpBtn;
	
	@FindBy(xpath = "//span[text()='Log in']")
	public WebElement loginBtn;


	/* ====================Constructor================ */
	public ShopLTKhomePage() {
		
		super(LtkURL);
		logger.createNode("user goes to LTK home Page");
		PageFactory.initElements(driver, this);
		Log4jManager.info("user goes to LTK home Page");
	}

	/* =====================Methods======================== */
	public ShopLTKhomePage signUp() {
		
		signUpBtn.click();

		Log4jManager.info("user click on the Signup button on the LTK home page");	
		return this;
	}
	
	public ShopLTKhomePage login() {
		
		loginBtn.click();

		Log4jManager.info("user click on the Login button on the LTK home page");	
		return this;
	}

}
