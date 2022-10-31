package com.instagram.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy (xpath= "//button[text()='Not Now']")
	private WebElement turnOnNotNowPopup;
	
	@FindBy (xpath= "//div[@class='cmbtv']")
	private WebElement saveYourLogInNotNowPopup;
	
	public HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	public void clickOnTurnOnNotNowPopUp() {
		turnOnNotNowPopup.click();	
	}

	public void clickOnSaveYourLogInNotNowPopUp() {
		saveYourLogInNotNowPopup.click();	
	}
}
