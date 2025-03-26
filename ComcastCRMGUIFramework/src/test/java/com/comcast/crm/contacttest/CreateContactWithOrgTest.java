package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepoistoryutility.HomePage;
import com.comcast.crm.objectrepoistoryutility.LoginPage;
import com.comcast.crm.objectrepoistoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepoistoryutility.OrganizationsPage;

public class CreateContactWithOrgTest extends BaseClass {
	@Test
	public void createcontactWithOrg() throws EncryptedDocumentException, IOException, InterruptedException {
		// create object

		// read common data from JSON file

		// read script data from excel file
//				String orgname=eu.getDataFromExcelFile("Sheet4", 1, 1)+ju.getRandomNumber();
//				String contactLastName=eu.getDataFromExcelFile("Sheet4",1,2)+ju.getRandomNumber();
//				

		// 1.login to app

//				d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
//				d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASS);
//				d.findElement(By.id("submitButton")).click();
//				
		// 2.navigate to Organizations module
//				d.findElement(By.linkText("Organizations")).click();
//				HomePage hp=new HomePage(d);
//				hp.getOrgLink();
//				
//				//3.click create organization module
////				d.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//				OrganizationsPage op=new OrganizationsPage(d);
//				op.organizationModule();

		// 4.enter all the details & create new organization

//				d.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
//				d.findElement(By.xpath("//input[@value='  Save  ']")).click();

		// 5.navigate to Contacts module

//				WebElement contactLink = d.findElement(By.xpath("(//td[@class='small'])[5]/descendant::td[8]/a")); // Locate again
//				wLib.mouseMoveOnElemen;(contactLink, d);
//				OrganizationInfoPage oip=new OrganizationInfoPage(d);
//				oip.save(orgname);
//						System.out.println(hp.getContact());
//				
//				wu.waitForElementCheckClickable(d, hp.getContact());	
//				System.out.println("succs");
		// wLib.waitForElementPresent(d,contactLink);
//				contactLink.click();

		// 6.click create contact module
		// d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//				d.findElement(By.name("lastname")).sendKeys(contactLastName);
//				d.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
//				
		// switch to child window

//				Set<String> set=d.getWindowHandles();
//				Iterator<String> it=set.iterator();
//				
//				while(it.hasNext()) {
//					String windowID=it.next();
//					d.switchTo().window(windowID);
//					
//					String actUrl=d.getCurrentUrl();
//					if(actUrl.contains("module=Accounts")){
//						break;
//					}
//				}
//				
//				wu.switchToTabOnURL(d, "module=Accounts");
//				
//				System.out.println("ORG NAME "+orgname);
//				d.findElement(By.id("search_txt")).sendKeys(orgname);
//				d.findElement(By.name("search")).click();
//				d.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
//				
//				//switch to parent window
//				wu.switchToTabOnURL(d, "Contacts&action");
//				d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//				
//				//verify header phone number into expected result
//				
//				String headerInfo=d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//				if(headerInfo.contains(contactLastName)) {
//					System.out.println(contactLastName+" header verified==PASS");
//				}
//				else {
//					System.out.println(contactLastName+" header verified==FAIL");
//				}
//				
//				//verify header orgname info expexcted result
//				String actOrgName=d.findElement(By.id("mouseArea_Organization Name")).getText();
//				System.out.println("Actual org name "+actOrgName);
//				if(actOrgName.contains(orgname)) {
//					System.out.println(orgname + " information created ==PASS");
//				}
//				else {
//					System.out.println(orgname + " information created ==FAIL");
//				}
//				
		String orgname = eu.getDataFromExcelFile("Sheet4", 1, 1) + ju.getRandomNumber();
		String contactLastName = eu.getDataFromExcelFile("Sheet4", 1, 2) + ju.getRandomNumber();
		//go to website and click create organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink();
		//2.clicl "+" symbol
		hp.getPuls_org().click();
		//3.provide valid name and click save button
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.save(orgname);
		//4.verify orgname 
		if ((oip.getHeaderOrgName().getText()).contains(orgname)) {
			System.out.println(orgname + " is verified successfully==PASS");
		} else {
			System.out.println(orgname + " is verified successfully==Fail");
		}
	}

}
