package com.comcast.crm.contacttest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepoistoryutility.ContactPage;
import com.comcast.crm.objectrepoistoryutility.HomePage;
import com.comcast.crm.objectrepoistoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepoistoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass{
	@Test
	public void createContactTest() throws Throwable {
		
		
		//read test script data from excel 
		String orgName=eu.getDataFromExcelFile("Sheet1", 18, 1)+ju.getRandomNumber();
		String lastName=eu.getDataFromExcelFile("Sheet4", 1, 2)+ju.getRandomNumber();
	//2.navigate to contact module
		HomePage hp=new HomePage(driver);
	//	hp.getOrgLink();
		
		//3.click on "create contact" button
		hp.getContact().click();
//		OrganizationsPage op=new OrganizationsPage(d);
//		op.organizationModule();
		
		
		ContactPage cp=new ContactPage(driver);
		//4.click "+" value
		cp.getPlus_Element().click();
		//5.provide "last name" value
		cp.getL_name().sendKeys(lastName);
		cp.getSaveButton().click();
		
		//enter all the details& create new contact
//		OrganizationInfoPage oip=new OrganizationInfoPage(d);
//				oip.save(orgName); 
		if((cp.getContactHeader().getText()).contains(lastName)) {
			System.out.println(lastName+" information is verified ==PAss");
		}else {
			System.out.println(lastName+" information is verified ==FAIL");
		}
		
		}
		
		
	}


