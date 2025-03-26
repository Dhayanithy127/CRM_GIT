package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepoistoryutility.HomePage;
import com.comcast.crm.objectrepoistoryutility.OrganizationInfoPage;

public class CreateOrganizationWithPhoneNumberTest extends BaseClass {
	@Test
	public  void createOrganizationWithPhoneTest() throws EncryptedDocumentException, IOException{
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
//				String phone_no=eLib.getDataFromExcelFile("Sheet4", 1, 3);
//				
////				WebDriver d=null;
//				if(BROWSER.equals("chrome")) {
//					d=new ChromeDriver();
//				}else if(BROWSER.equals("edge")) {
//					d=new EdgeDriver();
//				}else {
//					d=new ChromeDriver();
//				}
		
		//read script data from excel file
		String orgname=eu.getDataFromExcelFile("Sheet4", 1, 1)+ju.getRandomNumber();
		String phone_no=eu.getDataFromExcelFile("Sheet4", 1, 3);
		
		//2.navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrgLink();
		
		//3.click "+" symbol
		hp.getPuls_org().click();
		
		//4.enter all the details & save organization
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		oip.saveWithPhone(orgname, phone_no);
		
		if((oip.getAfter_Phone().getText()).contains(phone_no)) {
			System.out.println(phone_no+" is verified successfullt==PASS");
		}else {
			System.out.println(phone_no+" is verified successfullt==FAIL");
		}
		}
				 
	}


