package com.comcast.crm.objectrepoistoryutility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

//1.cteate seperate java class
public class LoginPage {
	WebDriver driver;
	WebDriverUtility wu=new WebDriverUtility();
	public LoginPage(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(d,this);
		
	}
	
	//2.object creation
	//3.object initialization
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath = "(//input[@value='Login'])[2]")})
//	@FindBys({@FindBy(id="submitButton"),@FindBy(xpath = "(//input[@value='Login'])[2]")})
	private WebElement submitButton;
	//4.object encapsulation
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}


	public WebElement getSubmitButton() {
		return submitButton;
	}

	//Business Library
	public void loginApp(String url,String userName,String password) {
		driver.manage().window().maximize();
		driver.get(url);
		wu.waitForPageLoad(driver);
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		submitButton.click();
	}
	
	public void logout() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement img=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))));
		
		
		Actions a=new Actions(driver);
		a.moveToElement(img).perform();
		WebElement signOut = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out")));
		signOut.click();
	
	
	}
	

}
