package com.comcast.crm.objectrepoistoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;

	public ContactPage(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeader;

	@FindBy(name = "lastname")
	private WebElement l_name;

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement plus_Element;

	public WebElement getPlus_Element() {
		return plus_Element;
	}

	@FindBy(name = "support_start_date")
	private WebElement start;

	@FindBy(name = "support_end_date")
	private WebElement end;

	@FindBy(id = "mouseArea_Support Start Date")
	private WebElement afterVerifyStartDate;

	public WebElement getAfterVerifyStartDate() {
		return afterVerifyStartDate;
	}

	public WebElement getAfterVerifyendDate() {
		return afterVerifyendDate;
	}

	@FindBy(id = "mouseArea_Support End Date")
	private WebElement afterVerifyendDate;

	public WebElement getStart() {
		return start;
	}

	public WebElement getEnd() {
		return end;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getContactHeader() {
		return contactHeader;
	}

	public WebElement getL_name() {
		return l_name;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void createwithDate(String last, String st_Date, String end_Date) {
		l_name.sendKeys(last);
		start.clear();
		start.sendKeys(st_Date);
		end.clear();
		end.sendKeys(end_Date);
		saveButton.click();
	}

}
