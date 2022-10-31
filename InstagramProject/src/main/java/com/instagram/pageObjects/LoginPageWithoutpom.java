package com.instagram.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageWithoutpom {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		String currentURL= driver.getCurrentUrl();
		System.out.println(currentURL);
		
		String title= driver.getTitle();
		System.out.println(title);
		
//		Point point= new Point(300,500);
//		driver.manage().window().setPosition(point);
//		Thread.sleep(5000);
//		
//		Dimension dimension= new Dimension(700,600);
//		driver.manage().window().setSize(dimension);
//		Thread.sleep(5000);
		
		driver.manage().window().maximize();
		
	//Login In Page
		
		//UserName TextBox
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("GabbarSinghSholay1975");
		
		//Password Textbox
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Basanti1975");
		Thread.sleep(5000);
		
		//LogIn Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
	//Home Page
		
		//Turn-On Notification
		driver.findElement(By.xpath("//button[text()='Not Now']")).click();
		
		//Profile Icon Top-Right Corner
		driver.findElement(By.xpath("//span[@class='_aa8h _aa8i']")).click();
		
		//Click on Profile
		driver.findElement(By.xpath("//div[text()='Profile']")).click();
		Thread.sleep(3000);
		
		//Click on Photo
		driver.findElement(By.xpath("//div[@class='_aagw']")).click();
		
		//Click on Heart(like) icon
		driver.findElement(By.xpath("(//div[@class='_abm0 _abl_'])[1]")).click();
		
		//Click on comment section and comment
		driver.findElement(By.xpath("//div[@class='_abm0 _abl_']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@aria-label='Add a comment…']")).sendKeys("Basanti in kutton ke samne mat nacna");
		Thread.sleep(3000);

//        //Click in smiley icon
//		driver.findElement(By.xpath("(//button[@class='_abl- _abm2'])[4]")).click();
//		Thread.sleep(3000);
//		WebElement dancingSmiley= driver.findElement(By.xpath("(//button[@class='_acan _acao _acas'])[316]"));
//		
//		for(int i=1; i<=5; i++)
//		{
//			dancingSmiley.click();
//		}
//		Thread.sleep(3000);
		
		//Click on Post 
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		//click on save icon
		driver.findElement(By.xpath("(//div[@class=\"_abm0 _abl_\"])[3]")).click();
		Thread.sleep(3000);
		
		//Close Icon
		driver.findElement(By.xpath("//div[@class='futnfnd5 li38xygf q0p5rdf8 mudwbb97']")).click();
		Thread.sleep(3000);

		//Profile Icon Top-Right Corner
		driver.findElement(By.xpath("//span[@class='_aa8h _aa8i']")).click();
		Thread.sleep(3000);

		//Logout option
		driver.findElement(By.xpath("//div[text()='Log out']")).click();
		Thread.sleep(3000);

		driver.close();
		driver.quit();
		
		
	}

}
