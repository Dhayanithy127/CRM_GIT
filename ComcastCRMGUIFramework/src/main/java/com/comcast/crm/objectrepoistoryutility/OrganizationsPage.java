package com.comcast.crm.objectrepoistoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	public OrganizationsPage(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement ele1;
	
	
	public WebElement getEle1() {
		return ele1;
	}


	public void organizationModule() {
		ele1.click();
	}

}
