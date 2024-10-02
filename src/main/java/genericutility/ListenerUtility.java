package genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {
	//String timestamp=LocalDateTime.now().toString().replace(':', '-');
//	String methodName=result.getName();
//	utilityMethod= new UtilityMethod();
//	String time = utilityMethod.getSystemTime();
//	ListTest.log(Status.FAIL, methodName+ "is Failed");
		
	 TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);//("./shots/maharajaslogo.png");
		File dest = new File("./screenshots/temp.png");
		try {
			FileUtils.copyFile(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  //TakesScreenshot tss = (TakesScreenshot)driver;
	//ListTest.addScreenCaptureFromBase64String(tss.getScreenshotAs(OutputType.BASE64));
	//File temp=tss.getScreenshotAs(OutputType.FILE);
//	File dest= new File("./screenshots/"+timestamp+".png");
	try {
		FileHandler.copy(temp, dest);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}

}
