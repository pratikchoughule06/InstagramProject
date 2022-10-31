package com.instagram.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfile {

private WebDriver driver;
	
	@FindBy (xpath= "//input[@id='pepName']")
	private WebElement name;
	
	@FindBy (xpath= "//input[@id='pepUsername']")
	private WebElement userName;
	
	@FindBy (xpath= "//input[@id='pepWebsite']")
	private WebElement website;
	
	@FindBy (xpath= "//textarea[@id='pepBio']")
	private WebElement bio;
	
	@FindBy (xpath= "//input[@id='pepEmail']")
	private WebElement email;
	
	@FindBy (xpath= "//input[@id='pepPhone Number']")
	private WebElement phoneNumber;
	
	@FindBy (xpath= "//input[@id='pepGender']")
	private WebElement gender;
	
	@FindBy (xpath= "//button[text()='Submit']")
	private WebElement submit;
	
	//Hidden PopUp after Submit
	@FindBy (xpath= "//p[text()='Profile saved.']")   
	private WebElement profileSavedPopup;
	
	public EditProfile (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	//1st Method:
	
	public void sendName(String Uname) {
		name.sendKeys(Uname);	
	}
	
	public void sendUserName(String username) {
		userName.sendKeys(username);	
	}
	
	public void sendWebsite(String Wsite) {
		website.sendKeys(Wsite);	
	}
	
	public void sendBio(String Bio) {
		bio.sendKeys(Bio);	
	}
	
	public void sendEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void sendPhoneNumber(String Pnumber) {
		phoneNumber.sendKeys(Pnumber);
	}
	
	public void selectGender() {
		gender.click();
	}
	
	public void clickSubmit() {
		if (submit.isEnabled())
		{
		   submit.click();
		}
	}
	
	public void popUpProfileSaved() {
    	String popUpText= profileSavedPopup.getText();
    	System.out.println(popUpText);
    	if (popUpText.equalsIgnoreCase("Profile saved."))
    	{
    		System.out.println("Pass");
    	}
    	else
    	{
    		System.out.println("Fail");
    	}
	}
	
}
