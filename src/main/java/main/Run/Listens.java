package main.Run;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listens  extends  Base implements ITestListener{
	static Logger logger = LogManager.getLogger(Listens.class);
	ExtentReports extent=Base.configReport() ;
	ExtentTest test;
ThreadLocal <ExtentTest> extentTest = new ThreadLocal <ExtentTest> ();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		logger.info(result.getMethod().getMethodName()+"has started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest.get().log(Status.PASS, "Test Passed!!!");
		logger.info(result.getMethod().getMethodName()+"Passed!!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest.get().fail(result.getThrowable());
		logger.info(result.getMethod().getMethodName()+"Failed");
		WebDriver driver=  null;
		
		
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String testName =result.getMethod().getMethodName();
		try {
			extentTest.get().addScreenCaptureFromPath(	getScreenShotPath(testName,driver), testName);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		logger.info(result.getMethod().getMethodName()+"Was skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		logger.info("Testcases have been executed");
		extent.flush();
	}
	
	
	
	

}
