package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLoad {

	/*
	 * Waits for the page to finish loading. this may not always be what is desired though. If the page makes further 
	 * async calls, the page could be finished loading before the data is retrieved. In that case, you will want 
	 * to use one of the other methods to ensure that you wait for something on the page to exist or be clickable.
	 */
	public static void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
	
	/*
	 * Waits for the specified element to exist on the page or 10 seconds, whichever comes first
	 */
	public static void waitForAllElementsToBePresent(WebDriver driver, By by) {
		(new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}

	/*
	 * Waits for the specified element to exist on the page or 10 seconds, whichever comes first
	 */
	public static void waitForElementToBePresent(WebDriver driver, By addTabFilter1) {
		WebElement element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.presenceOfElementLocated(addTabFilter1));
	}
	
	/*
	 * Waits for the specified element to be visible exist on the page or 10 seconds, whichever comes first
	 */
	public static void waitForElementToBeVisible(WebDriver driver, By by) {
		WebElement element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	/*
	 * Waits for the specified element to be visible exist on the page or 10 seconds, whichever comes first
	 */
	public static void waitForElementToBeVisible(WebDriver driver, WebElement we) {
		WebElement element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.visibilityOf(we));
	}
	
	/*
	 * Waits for the specified element to be visible exist on the page or 10 seconds, whichever comes first
	 */
	public static void waitForAllElementsToBeVisible(WebDriver driver, List<WebElement> we) {
		(new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.visibilityOfAllElements());
	}
	
	/*
	 * Waits for the specified element to be clickable or 10 seconds, whichever comes first
	 */
	public static void waitForElementToBeClickable(WebDriver driver, By by) {
		WebElement element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(by));
	}
	
	/*
	 * Waits for the specified element to be clickable or 10 seconds, whichever comes first
	 */
	public static void waitForElementToBeClickable(WebDriver driver, WebElement el) {
		WebElement element = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(el));
	}
	
	/*
	 * Waits a certain number of milliseconds. Useful for when you want to slow down execution, which 
	 * mainly applies to verifying the tests work.
	 */
	public static void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
