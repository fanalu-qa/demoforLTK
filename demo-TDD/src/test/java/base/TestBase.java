package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.dataRelated.ExcelManager;
import utilities.dataRelated.JDBCManager;
import utilities.dataRelated.JsonManager;
import utilities.elements.DriverUtil;
import utilities.reportRelated.TestListener;

public class TestBase extends TestListener {

	// data member
	// protected WebDriver driver;

	protected static ExcelManager xlread = new ExcelManager();
	protected static JDBCManager sqlread = new JDBCManager();
	
     static String filePath = System.getProperty("user.dir") + "/src/test/resources/testData/teklabJson.json";
     protected JsonManager json = new JsonManager(filePath);
	
	// protected static EcelEZ ezexcel = new ExcelEZ();

	// --------------- Before all @Test --------------------
	@BeforeTest
	public void beforeAllTestCase() {

		onExtentSetup();

	}

	// --------------- After all @Test--------------------
	@AfterTest
	public void afterAllTestCase() {
		// write the report to output view
		extent.flush();

	}

/***************** this parameter is used in testNG.xml****************************/
	@BeforeMethod
	@Parameters("browser")      
	// public void beforeEachTestCase(/*String browser*/) {
	public void beforeEachTestCase(String browser) {
		//String browser = System.getProperty("browser");   
		driver = DriverUtil.startBrowser(browser);  //run locally
//		driver = DriverUtil.startBrowserInPrivateMode(browser);
//		driver = DriverUtil.startDockerContainerBrowser(browser);         //run in Docker

	}

/*****************use this with Maven build configuration*************************/
//   @BeforeMethod
//    public void beforeEachTestCase() {  
//    String browser = System.getProperty("browser");
////    driver = DriverUtil.startBrowser(browser);
////    driver = DriverUtil.startBrowserInPrivateMode(browser);
//    driver = DriverUtil.startDockerContainerBrowser(browser);
//   }

	
	
//	 //@BeforeMethod   //annotation
//	 public void setUp() {
//
//	  //setting system property so system would know where our actual driver is located
//	  String driverpath = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
//	  System.setProperty("webdriver.chrome.driver", driverpath);
//	  
//	    
//	  // Launch Chrome
//	   driver = new ChromeDriver();
//	   //driver = new FirefoxDriver();
//	  // Maximize the browser window
//	  driver.manage().window().maximize();
//	  // Navigate to Google
//	      
//	 }

	@AfterMethod
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}

}
