package com.instagram.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.instagram.pageObjects.EditProfile;
import com.instagram.pageObjects.HomePage;
import com.instagram.pageObjects.InstagramHeaders;
import com.instagram.pageObjects.LoginPage;

	public class TC_EditProfile_1235 extends BaseClass {
		
		private LoginPage loginPage;
		private HomePage homePage;
		private InstagramHeaders headers;
		private EditProfile editProfile;
		private int testID;  
		
      @BeforeClass
      public void createPageObjects() {
    	  
    	  loginPage=new LoginPage(driver);
		  homePage= new HomePage(driver);
		  headers= new InstagramHeaders(driver);
		  editProfile= new EditProfile(driver);
      }
      
      @BeforeMethod
      public void loginToApplication() throws InterruptedException {
    	  
    	  loginPage.sendUserName(username);
		  loginPage.sendPassword(password);
		  loginPage.clickOnLogin();
		  Thread.sleep(3000);
		  
		  homePage.clickOnSaveYourLogInNotNowPopUp();
		  Thread.sleep(3000);
		  homePage.clickOnTurnOnNotNowPopUp();
      }

      @Test
		public void editProfile() throws IOException, InterruptedException 
		{
			testID= 1235;
			
			headers.clickOnProfilePhotoIcon();
		    headers.clickOnSettingsIcon();
			Thread.sleep(3000);
			
	//Verifying Current URL		
			String url= driver.getCurrentUrl();
			System.out.println("Current URL: " + url);
			Assert.assertEquals(url, "https://www.instagram.com/accounts/edit/", "current url does not matched");
	
	//Verifying Page Title
			String title= driver.getTitle();
			System.out.println("Title: " + title);
			Assert.assertEquals(title, "Edit Profile • Instagram", "title did not matched");
			
	//Enter Details
			editProfile.sendWebsite("www.gabbarsinghsholay1975.com");
			editProfile.sendBio("I am the Famous Gabbar Singh");
			editProfile.clickSubmit();
			Thread.sleep(3000);
	
	//Verify PopUp
			editProfile.popUpProfileSaved();
			boolean pageSource=driver.getPageSource().contains("Profile saved.");
			Assert.assertTrue(pageSource, "PopUp PageSource is False");
		
		}
			
	@AfterMethod
	  public void logoutFromApplication(ITestResult result) throws IOException, InterruptedException{
		
		  if (ITestResult.FAILURE== result.getStatus())
		  {
			  captureScreen(driver, testID);
		  }
		  
			headers.clickOnProfilePhotoIcon();
			Thread.sleep(2000);
			headers.logOut();
	  }
	
	@AfterClass
	public void clearPageObjects() {
		
		loginPage= null;
		homePage= null;
		headers= null;
		editProfile= null;	
	}
	
 }
	