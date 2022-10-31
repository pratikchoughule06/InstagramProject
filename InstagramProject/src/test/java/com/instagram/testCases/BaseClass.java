package com.instagram.testCases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.instagram.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	private String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) throws InterruptedException
	{
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		if(browser.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			//System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(browser.equals("edge"))
		{
			//System.setProperty("webdriver.ie.driver",readconfig.getmsedgePath());
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		driver= null;
		System.gc();
	}
	
	public static void captureScreen(WebDriver driver, int testID) throws IOException {
        Date date1 = new Date();
		DateFormat dateFormat = new SimpleDateFormat(" dd-MM-yyyy HH-mm-ss");
        String date = dateFormat.format(date1);
        
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "/Screenshots/" + "TestID-" + testID + date + ".png");
		FileUtils.copyFile(sourceFile, destination);
		System.out.println("Failed Screenshot of TestID-"+testID+" Taken At:"+date);
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	
}
