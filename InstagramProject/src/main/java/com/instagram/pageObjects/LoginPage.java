package com.instagram.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy (xpath= "//input[@name='username']")
	private WebElement userName;
	
	@FindBy (xpath= "//input[@name='password']")
	private WebElement password;
	
	@FindBy (xpath= "//button[@type='submit']")
	private WebElement login;
	
	
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	//1st Method:
	
	public void sendUserName(String Uname) {
		userName.sendKeys(Uname);	
	}
	
	public void clearUserName() {
		userName.clear();
	}
	
	public void sendPassword(String Pwd) {
		password.sendKeys(Pwd);	
	}
	
	public void clickOnLogin() {
		login.click();	
	}
	
 
	
	
	//2nd Method:
	
//	public void loginToApplication() {
//		userName.sendKeys("GabbarSinghSholay1975");
//		password.sendKeys("Basanti1975");
//		login.click();
//      logout.click();
	//}
}
