package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepoistoryutility.HomePage;
import com.comcast.crm.objectrepoistoryutility.OrganizationInfoPage;

public class CreateOrganizationWithIndustriesTest extends BaseClass {
	@Test
	public void createOrganizationWithIndustriesTest() throws EncryptedDocumentException, IOException {
		//create object
//				FileUtility fLib=new FileUtility();
//				ExcelUtility eLib=new ExcelUtility();
//				JavaUtility jLib=new JavaUtility();
//				
//				
//				//read common data from JSON file
//				String BROWSER=fLib.getDataFromPropertiesFile("browser");
//				String URL=fLib.getDataFromPropertiesFile("url");
//				String USERNAME=fLib.getDataFromPropertiesFile("username");
//				String PASS=fLib.getDataFromPropertiesFile("password");
//				
//				//read script data from excel file
//				String orgname=eLib.getDataFromExcelFile("Sheet4", 1, 1)+jLib.getRandomNumber();
//				String industry=eLib.getDataFromExcelFile("Sheet4", 1, 4);
//				String type=eLib.getDataFromExcelFile("Sheet4", 1, 5);
//				
//				WebDriver d=null;
//				if(BROWSER.equals("chrome")) {
//					d=new ChromeDriver();
//				}else if(BROWSER.equals("edge")) {
//					d=new EdgeDriver();
//				}else {
//					d=new ChromeDriver();
//				}
		//1.click organization module
		HomePage hp=new HomePage(driver);
		hp.getOrgLink();
		
		//2.click "+" symbol
		hp.getPuls_org().click();

		//3.fill require details and save
		
		String orgname=eu.getDataFromExcelFile("Sheet4", 1, 1)+ju.getRandomNumber();
		String industry=eu.getDataFromExcelFile("Sheet4", 1, 4);
		String type=eu.getDataFromExcelFile("Sheet4", 1, 5);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		oip.saveWithIndustryAndType(orgname, industry, type);
				
		
		
				 
	}

}
