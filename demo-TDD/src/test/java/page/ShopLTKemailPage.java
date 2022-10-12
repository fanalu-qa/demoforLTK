package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;
import utilities.reportRelated.Log4jManager;

public class ShopLTKemailPage extends PageBase {

	public static final String LtkEmailURL = "https://login.shopltk.com/login?state=hKFo2SBIOURWVDdhQ0R1eEIxMGtRZmY4VGtaSjdidy1rdmwtRaFupWxvZ2luo3RpZNkgTzY4bUgtSkJ6d1RCLUM4TWVsZHdiNVRXaVg2bFpXWDWjY2lk2SBOcGMxMEQ3M3JqdUxaak4zR3lWMlRGWnk3YVQyT0NTRw&client=Npc10D73rjuLZjN3GyV2TFZy7aT2OCSG&protocol=oauth2&prompt=login&response_type=code&access_type=&redirect_uri=https%3A%2F%2Fwww.shopltk.com%2Fauth%2Fcallback&scope=openid+profile+offline_access+openid+profile+email+ltk.consumer+offline_access&code_challenge_method=S256&screen_hint=signup&ui_locales=en-US&audience=https%3A%2F%2Fprod-consumer-api.shopltk.com%2Fv1&code_challenge=dsT3j15WQaMX403xEmY2jbBMoqCdszFmgKoRf-k277w";

	/***** data member *****/
	@FindBy(xpath = "(//input[@name='email'])[1]")
	public WebElement email;

	@FindBy(xpath = "//span[text()='continue']")
	public WebElement continute1;

	/* ====================Constructor================ */
	public ShopLTKemailPage() {

		super(LtkEmailURL);
		logger.createNode("user lands on the LTK sign up Page");
		PageFactory.initElements(driver, this);
		Log4jManager.info("user lands on the LTK sign up Page");
	}

	/* =====================Methods======================== */
	public ShopLTKemailPage enterEmail(String emailField)  {

		email.clear();
		if (emailField != null) {
			email.sendKeys(emailField);
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		continute1.click();

		Log4jManager.info("user is entering an email to sign up");
		return this;
	}

}
