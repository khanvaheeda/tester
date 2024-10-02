package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import pomClass.LoginPage;

public class TC_01 extends BaseClass {
	public WebDriver driver;

	@Test
	public void searchLaptop() throws InterruptedException, IOException {
		//driver.get("https://www.flipkart.com/");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		
		LoginPage loginpage=new LoginPage(driver);
		
		
		loginpage.getSearchBox().click();
		Thread.sleep(2000);
		loginpage.getSearchBox().sendKeys("dell inspiron 3520");
		Thread.sleep(2000);
		
		loginpage.getSearchButton().click();
		Thread.sleep(2000);
		loginpage.getlaptopDell().click();
		 String Parentwindow = driver.getWindowHandle();//Gn+jFg
		 System.out.println("parent window="+ Parentwindow);
		 driver.findElement(By.xpath("//div[text()='DELL Inspiron 3520 Intel Core i3 12th Gen 1215U - (8 GB/512 GB SSD/Windows 11 Home) New Inspiron 15 La...']")).click();
		 Set<String> childwindow = driver.getWindowHandles();
		 for(String page:childwindow) {
			 if(!page.equals(Parentwindow)) {
				 driver.switchTo().window(page);
				 break;
			 }
		 }
		 System.out.println(driver.getCurrentUrl());
		 
		 driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		 driver.findElement(By.xpath("//span[text()='Cart']")).click();
		 
		   
		 
		    driver.get("https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART");
		    Thread.sleep(3000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File tempfile = ts.getScreenshotAs(OutputType.FILE);//("./shots/maharajaslogo.png");
			File perfile = new File("./BuGGSSS/temp.png");
			
			FileUtils.copyFile(tempfile, perfile);
	}


	}
	
	
	
	

