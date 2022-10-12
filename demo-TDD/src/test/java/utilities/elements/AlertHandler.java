package utilities.elements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import utilities.reportRelated.Log4jManager;

public class AlertHandler {
	
	private WebDriver driver;
	
	public AlertHandler (WebDriver driver) {
		this.driver= driver;
	}

	
	
	public Alert getAlert() { //one alert object
		
		Alert alert1 = driver.switchTo().alert();
		return alert1;
	}
	
	
	
	public void acceptAlert() {
		try {
			getAlert().accept();
			Log4jManager.debug("successfully accept alert");
		}
		catch (Exception e) {
			Log4jManager.error("failed to accept alert");
		}
	}
	
	
	
	
	public void dismissAlert() {
		
		/*another way:
		 * 
		Alert alert1 = driver.swithTo().alert();
		alert1.dismiss();
		
		*/
		
		
		//getAlert().dismiss()		
		try {
			getAlert().dismiss();
			Log4jManager.debug("successfully dismiss alert");
		}
		catch (Exception e) {
			Log4jManager.error("failed to dismiss alert");
		}
	}
	
	
	
	
	
	
	
}
