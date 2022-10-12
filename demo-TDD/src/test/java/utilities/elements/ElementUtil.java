package utilities.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.reportRelated.Log4jManager;

public class ElementUtil {
	
	private WebDriver driver;

	
	public ElementUtil(WebDriver inComingDriver) {
		this.driver = inComingDriver;
	}
	
	
	
	public void clickEle(WebElement webelement) {
		try{
			webelement.click();
		}
		catch(Exception e) {
			Log4jManager.error("failed to click element" + webelement );
		}
		
	}
	
	
	public void enterContent(WebElement inputbox, String text) {
		try{
			inputbox.clear();
			inputbox.sendKeys(text);
		} catch(Exception e) {
			Log4jManager.error("failed to send text to the input box" + inputbox );
		}
		
	}
	
	
	public void clickElementBy(By locator) {
		try {
			WebElement ele = driver.findElement(locator);
			ele.click();
		}catch (Exception e) {
			Log4jManager.error("failed to click element using this locator" + locator.toString() );
		}
	}
	
	
	
	public void highLighter(WebElement element) {
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	     
	     try {
	      Thread.sleep(1000);
	     } catch (InterruptedException e) {
	      Log4jManager.error("failed to highlight elements" + element);
	     }
	    }

	
	
	
}
