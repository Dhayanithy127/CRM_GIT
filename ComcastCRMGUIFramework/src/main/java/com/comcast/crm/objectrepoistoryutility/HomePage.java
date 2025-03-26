package com.comcast.crm.objectrepoistoryutility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//rule no:1 :create class
public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(d,this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement ele1;
	
	@FindBy(linkText = "Contacts")
	private WebElement contact;
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement puls_org;
	

	public WebElement getPuls_org() {
		return puls_org;
	}


	public WebElement getContact() {
		return contact;
	}


	public WebElement getEle1() {
		return ele1;
	}


	public void getOrgLink() {
		ele1.click();
	}
	
	public void logout() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement img=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))));
		
		
		Actions a=new Actions(driver);
		a.moveToElement(img).perform();
		WebElement signOut = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out")));
		signOut.click();
		}
	
	
	

}
