package com.instagram.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.instagram.pageObjects.HomePage;
import com.instagram.pageObjects.InstagramHeaders;
import com.instagram.pageObjects.LoginPage;

public class TC_LoginTest_1234 extends BaseClass
{
	private LoginPage loginPage;
	private HomePage homePage;
	private InstagramHeaders headers;
	private int testID;
	
	@BeforeClass
	public void createPageObjects() {
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		headers = new InstagramHeaders(driver);
	}

	@Test
	public void loginTest() throws IOException, InterruptedException 
	{
		testID= 1234;
		
	//Entering Login Details	
		loginPage.sendUserName(username);
		loginPage.clearUserName();
		loginPage.sendPassword(password);
		loginPage.clickOnLogin();
		Thread.sleep(3000);

	//PopUp
		homePage.clickOnSaveYourLogInNotNowPopUp();
		Thread.sleep(3000);
		homePage.clickOnTurnOnNotNowPopUp();

	//Verifying Page Title
		String title= driver.getTitle();
		System.out.println("title: " + title);
	    Assert.assertEquals(title, "Instagram", "title does not matched");
		
	}

	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws InterruptedException, IOException {
		
		if (ITestResult.FAILURE== result.getStatus())
		{
			captureScreen(driver, testID);
		}
		
		headers.clickOnProfilePhotoIcon();
		Thread.sleep(3000);
		headers.logOut();	
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void clearPageObjects() {
		loginPage= null;
		homePage= null;
		headers= null;
	}
	
 }
