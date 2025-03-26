package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepoistoryutility.ContactPage;
import com.comcast.crm.objectrepoistoryutility.HomePage;
import com.comcast.crm.objectrepoistoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepoistoryutility.OrganizationsPage;

public class CreateContactWithSupportDateTest extends BaseClass {
	@Test
	public  void createcontactWithDate() throws EncryptedDocumentException, IOException {
		//create object
				
//			
//				//read script data from excel file
//				String orgname=eu.getDataFromExcelFile("Sheet4", 1, 1)+ju.getRandomNumber();
//				String lastname=eu.getDataFromExcelFile("Sheet4", 1, 2);
//			
//				
//				//1.login to app
//				//2.navigate to Contacts module
//				HomePage hp=new HomePage(d);
//				hp.getOrgLink();
//				
//				//3.click create organization module
//				OrganizationsPage op=new OrganizationsPage(d);
//				op.organizationModule();
//				
//				
//				String start_date=ju.getSystemData();
//				String end_date=ju.getRequiredDate(30);
//			//	System.out.println(start_date+" "+end_date);
//				
//				
//				//4.enter all the details & create new organization
//				
////				 d.findElement(By.name("lastname")).sendKeys(lastname);
////				 d.findElement(By.name("support_start_date")).clear();
////				 d.findElement(By.name("support_start_date")).sendKeys(start_date);
////				 d.findElement(By.name("support_end_date")).clear();
////				 d.findElement(By.name("support_end_date")).sendKeys(end_date);
////				
//				 //save data
//				 OrganizationInfoPage oip=new OrganizationInfoPage(d);
//				 oip.saveLastNameAndDate(lastname,start_date,end_date);
//				 d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//				 
//				 //verify header phone number into expected result
//				 String actStartDate=d.findElement(By.id("dtlview_Support Start Date")).getText();
//				 if(actStartDate.equals(start_date)) {
//					 System.out.println(start_date+" information is verified==PASS");
//				 }else {
//					 System.out.println(start_date+" information is not verified==FAIL");
//				 }
//				 
//				 String actEndDate=d.findElement(By.id("dtlview_Support End Date")).getText();
//				 if(actEndDate.equals(end_date)) {
//					 System.out.println(end_date+" information is verified==PASS");
//				 }else {
//					 System.out.println(end_date+" information is not verified==FAIL");
//				 }
		
		
		//read script data from excel file
		String orgname=eu.getDataFromExcelFile("Sheet4", 1, 1)+ju.getRandomNumber();
		String lastname=eu.getDataFromExcelFile("Sheet4", 1, 2)+ju.getRandomNumber();
	
		//2.navigate to Contacts module		
		
		HomePage hp=new HomePage(driver);
		hp.getContact().click();
		
		//click "+" button
		ContactPage cp=new ContactPage(driver);
		cp.getPlus_Element().click();
		
		//cp.getL_name().sendKeys(lastname);
		
		//get start date & end date from java utility
		String startDate=ju.getSystemData();
		String endDate=ju.getEndDate(30);
		cp.createwithDate(lastname,startDate,endDate);
		
		//4.verify start date
		if((cp.getAfterVerifyStartDate().getText()).contains(startDate)) {
			
			System.out.println(startDate+" is verified successfully==PASS");
		}
		
		else {
			System.out.println(startDate+" is verified successfully==Fail");
		}
		
		
		//5.verify end date
		if((cp.getAfterVerifyendDate().getText()).equals(endDate)) {
			
			System.out.println(endDate+" is verified successfully==PASS");
		}
		else {
			System.out.println(endDate+" is verified successfully==Fail");
		}
		
		System.out.println("After start date :"+cp.getAfterVerifyStartDate().getText());
		System.out.println("After end date :"+cp.getAfterVerifyendDate().getText());
		
	}

	

}
