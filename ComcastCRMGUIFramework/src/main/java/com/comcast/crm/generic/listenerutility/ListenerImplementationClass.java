package com.comcast.crm.generic.listenerutility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementationClass implements ISuiteListener,ITestListener{

	public ExtentReports report;
//	public static ExtentTest test;
	public ExtentTest test;
//	BaseClass_Assert ast;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("===Suite onTestStart()  started===");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"===> START <===");
		System.out.println(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===started onTestSuccess()-result===");
		test.log(Status.PASS, result.getMethod().getMethodName()+"===> END <===");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {//tc fails means it automatically take screenshot
		// TODO Auto-generated method stub
		String name=result.getMethod().getMethodName();
		String time=new Date().toString();
		//String simpletime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	//	String time = new Date().toString();
		//TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
      //  File src=ts.getScreenshotAs(OutputType.FILE);
      //  File dest=new File("./screenshot/" + result.getName() +"+"+time+ ".png");
       // File dest = new File("./screenshot/" + result.getName() + "_" + time + ".png");
//        try {
//			Files.copy(src, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if (UtilityClassObject.getDriver() != null) {
		    TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		    String filePath = ts.getScreenshotAs(OutputType.BASE64);
		    test.addScreenCaptureFromBase64String(filePath, name + "_" + time);
		    test.log(Status.FAIL, name);
		} else {
		    System.out.println("WebDriver instance is null. Cannot take screenshot.");
		}
//		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
//		String filePath=ts.getScreenshotAs(OutputType.BASE64);
//		
//		test.addScreenCaptureFromBase64String(filePath, name+"_"+time);
//		test.log(Status.FAIL, name);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("===started onStart()-context===");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("===started onFinish()-context===");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("===started onStart()-suite===");
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM test suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add ENV information &create test 
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-100");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("===started onFinish()-suite===");
		// TODO Auto-generated method stub
		report.flush();
		
	}
	
	

}
