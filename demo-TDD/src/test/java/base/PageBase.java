package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.elements.AlertHandler;
import utilities.elements.ElementUtil;
import utilities.reportRelated.Log4jManager;
import utilities.reportRelated.TestListener;

public abstract class PageBase extends TestListener  {
	
	
    public WebDriverWait wait;
	public ElementUtil eles;
	public AlertHandler alert;
	public final String url;


	//constructor
	public PageBase(String url) {
		eles = new ElementUtil(driver);  //initialize elements in constructor
		alert = new AlertHandler(driver);
		wait = new WebDriverWait(driver, 10);
		this.url = url;
	}
	
	/*----------------------
	 * /Click Method
	public void click(By elementLocation) {
		waitVisibility(elementLocation);
		try {
			driver.findElement(elementLocation).click();
		}
		catch (Exception e) {
			Log4jManager.error("failed to click element");
		}
	}
	
	//WriteText Method
	public void writeText(By elementLocation, String text) {
		waitVisibility(elementLocation);
		driver.findElement(elementLocation).sendKeys(text);
	}
	
	**************************/
	
	public void goToPage() {
		Log4jManager.info("Go to page:" +url);
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log4jManager.info("Loaded page:" +url);
	}
	
	public void scrollDown() {
	((JavascriptExecutor) driver)
    .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void highlightElement(WebElement el) {
		eles.highLighter(el);
	}

}
 