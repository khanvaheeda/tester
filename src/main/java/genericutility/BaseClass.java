package genericutility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pomClass.LoginPage;
@Listeners(ListenerUtility.class)
public class BaseClass {
public static WebDriver driver;
public static ExtentReports extentReport;
public ExtentTest test;
public static ExtentTest ListTest;
public WebDriverWait wait;
public UtilityMethod utilityMethod;
public LoginPage loginPage;



@BeforeSuite(alwaysRun = true)
public void configReports() {
	utilityMethod= new UtilityMethod();
	//String time = utilityMethod.getSystemTime();
	ExtentSparkReporter spark = new ExtentSparkReporter("./src/main/resources/Reports");
	extentReport= new ExtentReports();
	extentReport.attachReporter(spark);
}
@BeforeClass(alwaysRun = true)
public void launchBrowser(@Optional("chrome") String browserName) throws IOException {
	if (browserName.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
		
	}
	else if (browserName.equalsIgnoreCase("edge")) {
		driver= new EdgeDriver();
	}
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	wait= new WebDriverWait(driver, Duration.ofSeconds(10));
//	utilityMethod= new UtilityMethod();
	//String url1=utilityMethod.getDataFromProperty("url");
	//driver.get(utilityMethod.getDataFromProperty("url"));
	loginPage= new LoginPage(driver);
}
@BeforeMethod(alwaysRun = true)
public void login(Method method) {
	test= extentReport.createTest(method.getName());
	ListTest= test;
	
}
//@AfterMethod(alwaysRun = true)
//public void logout() {
//	loginPage.getSearchBox().click();
	
//}
@AfterClass(alwaysRun = true)
public void closeBrowser() {
	driver.quit();
}
@AfterSuite(alwaysRun = true)
public void reportBackup() {
	extentReport.flush();
}
}
