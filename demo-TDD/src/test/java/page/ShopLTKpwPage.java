package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;
import utilities.reportRelated.Log4jManager;

public class ShopLTKpwPage extends PageBase {

	public static final String LtkpwURL = "https://login.shopltk.com/login?state=hKFo2SBDMjF4R2NMMlZMMTZtZVFub0QwcDhSMVczYmRBdnBXdqFupWxvZ2luo3RpZNkgZXhMVUJqWURyOHU2c0lPSGpPVDRlY0FxUkNDVlNsMjWjY2lk2SBOcGMxMEQ3M3JqdUxaak4zR3lWMlRGWnk3YVQyT0NTRw&client=Npc10D73rjuLZjN3GyV2TFZy7aT2OCSG&protocol=oauth2&prompt=login&response_type=code&access_type=&redirect_uri=https%3A%2F%2Fwww.shopltk.com%2Fauth%2Fcallback&scope=openid+profile+offline_access+openid+profile+email+ltk.consumer+offline_access&code_challenge_method=S256&screen_hint=signup&ui_locales=en-US&audience=https%3A%2F%2Fprod-consumer-api.shopltk.com%2Fv1&code_challenge=C7PZpNhWO3ME1ptmQBS3OLW_KbsyNx5DD__5vKX8tGM";

	/***** data member *****/
	@FindBy(xpath = "//input[@type='password']")
	public WebElement password;

	@FindBy(xpath = "//span[text()='sign up to begin shopping']")
	public WebElement signUpToShopBtn;

	@FindBy(xpath = "(//span[text()='continue'])[2]")
	public WebElement continute2;

	/* ====================Constructor================ */
	public ShopLTKpwPage() {

		super(LtkpwURL);
		logger.createNode("user lands on the LTK password Page");
		PageFactory.initElements(driver, this);
		Log4jManager.info("user lands on the LTK password  Page");
	}

	/* =====================Methods======================== */
	public ShopLTKpwPage enterPWtoSignup(String pw) {

		password.clear();
		if (pw != null) {
			password.sendKeys(pw);
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

		signUpToShopBtn.click();

		Log4jManager.info(
				"user is entering a password and clicking the Sign Up to Beging Shopping button to finish signing up");
		return this;
	}

	public ShopLTKpwPage enterPWtoLogin(String pw) {

		password.clear();
		if (pw != null) {
			password.sendKeys(pw);
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

		continute2.click();

		Log4jManager.info(
				"user is entering a password and clicking the Sign Up to Beging Shopping button to finish signing up");
		return this;
	}

}
