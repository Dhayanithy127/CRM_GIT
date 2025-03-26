package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrganizationTest {
	public static void main(String[] args) throws IOException {
		
		//create object
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		
		
		//read common data from JSON file
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASS=fLib.getDataFromPropertiesFile("password");
		
		//read script data from excel file
		String orgname=eLib.getDataFromExcelFile("Sheet4", 1, 1)+jLib.getRandomNumber();
		
		WebDriver d=null;
		if(BROWSER.equals("chrome")) {
			d=new ChromeDriver();
		}else if(BROWSER.equals("edge")) {
			d=new EdgeDriver();
		}else {
			d=new ChromeDriver();
		}
		 
		
	}

}
