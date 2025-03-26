package com.comcast.crm.objectrepoistoryutility;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateNewOrganizationPage {
	public static void main(String[] args) throws IOException {
		
	
	
	
	//LoginPage lp=new LoginPage();
	FileUtility fu=new FileUtility();
	// create obj of Excel file class
	ExcelUtility eu=new ExcelUtility();
	//create obj of java utility
	JavaUtility ju=new JavaUtility();
	
	String BROWSER=fu.getDataFromPropertiesFile("browser");
	String URL=fu.getDataFromPropertiesFile("url");
	String USERNAME=fu.getDataFromPropertiesFile("username");
	String PASS=fu.getDataFromPropertiesFile("password");
	
	//generate random number
	Random r=new Random();
	int random=r.nextInt(100);
	
	//read data from excel
	String gender=eu.getDataFromExcelFile("Sheet1", 13, 0);
	String firstName=eu.getDataFromExcelFile("Sheet1", 13, 1);
	String lastName=eu.getDataFromExcelFile("Sheet1", 13, 2);
	String Email_Id=eu.getDataFromExcelFile("Sheet1", 13, 3);
	String pass=eu.getDataFromExcelFile("Sheet1", 13, 4);
	String cnfm_pass=eu.getDataFromExcelFile("Sheet1", 13, 5);
	
	String orgName=eu.getDataFromExcelFile("Sheet4", 1, 1)+ju.getRandomNumber();
	
	WebDriver d=null;
	if(BROWSER.equals("chrome")) {
		d=new ChromeDriver();
	}else if(BROWSER.equals("edge")) {
		d=new EdgeDriver();
	}else {
		d=new ChromeDriver();
	}
	
	
	//1.login to app
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	d.get(URL);
	
	LoginPage login=new LoginPage(d);
	login.loginApp(URL,USERNAME, PASS );
	
	//we can initialize value either this way or business libraries
//	login.getUserNameEdt().sendKeys("admin");
//	login.getUserPasswordEdt().sendKeys("admin");
//	login.getSubmitButton().click();
	
	//2.navigate to organization module 
	
	HomePage hp=new HomePage(d);
	hp.getOrgLink();
			
	//3.click on "create organization module" button
	
	OrganizationsPage op=new OrganizationsPage(d);
	op.organizationModule();
	//4.enter all the details & create new organization
	
	OrganizationInfoPage oig=new OrganizationInfoPage(d);
	oig.save(orgName);
	//5.verify header message expected result
	if((oig.getEle3().getText()).contains(orgName)) {
		System.out.println(orgName+" is verify ==PASS");
	}else {
		System.out.println(orgName+" is verify ==FAIL");
	}
	

}
}
