package com.comcast.crm.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepoistoryutility.LoginPage;

public class BaseClass {
	public DataBaseUtility du = new DataBaseUtility();
	public FileUtility fu = new FileUtility();
	public ExcelUtility eu = new ExcelUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	LoginPage lp;
	public WebDriver driver;
	public static WebDriver sdriver;
//	public ExtentReports report;

	@BeforeSuite
	public void beforesuite() {
		System.out.println("====Connect DB beforeSuite====");
		du.getConnection();
//		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
//		spark.config().setDocumentTitle("CRM test suite Results");
//		spark.config().setReportName("CRM Report");
//		spark.config().setTheme(Theme.DARK);
//		
//		//add ENV information &create test 
//		report=new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("OS", "Windows-11");
//		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@BeforeClass
	public void beforeclass() throws IOException {
		System.out.println("====Launch browser beforeClass====");
		String BROWSER = fu.getDataFromPropertiesFile("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		 if (driver == null) {
		        throw new RuntimeException("WebDriver initialization failed!");
		    }
	//	sdriver = d;
		UtilityClassObject.setDriver(driver);
		
		
	//	System.out.println(sdriver);
	}

	@BeforeMethod
	public void beforemethod() throws IOException {
		System.out.println("====Login====");
		String URL = fu.getDataFromPropertiesFile("url");
		String USERNAME = fu.getDataFromPropertiesFile("username");
		String PASS = fu.getDataFromPropertiesFile("password");
		lp = new LoginPage(driver);
		lp.loginApp(URL, USERNAME, PASS);
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("====Logout====");
		lp.logout();

	}

	@AfterClass
	public void afterclass() {
		System.out.println("=====Close browser afterClass=====");
		driver.quit();
	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("=====Close DB afterSuite=====");
	//	report.flush();
		du.closeConnection();
	}
}
