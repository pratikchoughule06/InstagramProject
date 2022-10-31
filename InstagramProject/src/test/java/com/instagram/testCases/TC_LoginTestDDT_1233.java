package com.instagram.testCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.instagram.pageObjects.HomePage;
import com.instagram.pageObjects.InstagramHeaders;
import com.instagram.pageObjects.LoginPage;
import com.instagram.utilities.XLUtils;


public class TC_LoginTestDDT_1233 extends BaseClass {
	
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
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		testID= 1233;
	
		//Entering Login Details
		loginPage.sendUserName(user);
		loginPage.sendPassword(pwd);
		loginPage.clickOnLogin();
		
		Thread.sleep(8000);
		
		//Refreshing Page to clear values
		driver.navigate().refresh();
		
		//PopUp
		homePage.clickOnSaveYourLogInNotNowPopUp();
		Thread.sleep(3000);
		homePage.clickOnTurnOnNotNowPopUp();
		
		Thread.sleep(3000);
		
		headers.clickOnProfilePhotoIcon();
		Thread.sleep(3000);
		headers.logOut();	
		Thread.sleep(3000);
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/instagram/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
	
  }
	
