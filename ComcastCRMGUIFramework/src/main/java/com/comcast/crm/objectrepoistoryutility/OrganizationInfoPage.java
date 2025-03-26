package com.comcast.crm.objectrepoistoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class OrganizationInfoPage {
	WebDriver driver;
	JavaUtility ju = new JavaUtility();
	Select s;
	public OrganizationInfoPage(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgname;
	
	@FindBy(id = "phone")
	private WebElement phone;

	public WebElement getPhone() {
		return phone;
	}

	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement save;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ele3;

	@FindBy(name = "lastname")
	private WebElement lastname;
	
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerOrgName;
	
	@FindBy(id = "mouseArea_Phone")
	private WebElement after_Phone;
	
	@FindBy(name = "industry")
	private WebElement industry_Name;
	
	@FindBy(name = "accounttype")
	private WebElement type_Name;
	
	public WebElement getIndustry_Name() {
		return industry_Name;
	}

	public WebElement getType_Name() {
		return type_Name;
	}

	public WebElement getAfter_Phone() {
		return after_Phone;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getEle3() {
		return ele3;
	}

	public WebElement getOrgName() {
		return orgname;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getHeaderOrgName() {
		return headerOrgName;
	}

	public void setHeaderOrgName(WebElement headerOrgName) {
		this.headerOrgName = headerOrgName;
	}

	public void save(String orgName) {
		orgname.sendKeys(orgName);
		save.click();
	}
	
	public void saveWithPhone(String orgName,String phone_Number) {
		orgname.sendKeys(orgName);
		phone.sendKeys(phone_Number);
		save.click();
	}
	
	public void saveWithIndustryAndType(String orgName,String industry,String type) {
		 s=new Select(industry_Name);
		orgname.sendKeys(orgName);
		s.selectByVisibleText(industry);
		s=new Select(type_Name);
		s.selectByVisibleText(type);
		save.click();
	}
	

}
