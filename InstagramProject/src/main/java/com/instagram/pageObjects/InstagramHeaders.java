package com.instagram.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstagramHeaders {
	
	private WebDriver driver;
	
	@FindBy (xpath= "//input[@placeholder=\"Search\"]")
	private WebElement searchBarIcon;
	
	@FindBy (xpath= "(//a[@href='/'])[2]")
	private WebElement homePageIcon;
	
	@FindBy (xpath= "//a[@href='/direct/inbox/']")
	private WebElement messageIcon;
	
	@FindBy (xpath= "//a[@href='/explore/']")
	private WebElement exploreReelsIcon;
	
	@FindBy (xpath= "//a[@class='_acuj _aa8k']")
	private WebElement heartIcon;
	
	@FindBy (xpath= "//div[@class='_aaav']")
	private WebElement profilePhotoIcon;
	
	    //Sub-Tabs under profilePhotoIcon
	
	    @FindBy (xpath= "//div[@id='f101cb5ce75c7f4']")
	    private WebElement profileIcon;
	
	    @FindBy (xpath= "//div[@id='f2288c8696fe2f']")
	    private WebElement savedIcon;
	
	    @FindBy (xpath= "//div[text()='Settings']")
	    private WebElement settingsIcon;
	
	    @FindBy (xpath= "//div[@id='f224e89f08f999c']")
	    private WebElement switchAccountsIcon;
	
	    @FindBy (xpath= "//div[text()='Log out']")
	    private WebElement logout;
	
	
	
	public InstagramHeaders (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}

	
	public void clickOnSearchBarIcon() {
		searchBarIcon.click();
	}
	
	public void clickOnHomePageIcon() {
		homePageIcon.click();
	}
	
	public void clickOnMessageIcon() {
		messageIcon.click();
	}
	
	public void clickOnExploreReelsIcon() {
		exploreReelsIcon.click();
	}
	
	public void clickOnHeartIcon() {
		heartIcon.click();
	}
	
	public void clickOnProfilePhotoIcon() {
		profilePhotoIcon.click();
	}
	
	    public void clickOnProfileIcon() {
		    profileIcon.click();
	    }
	
	    public void clickOnSavedIcon() {
		    savedIcon.click();
	    }
	
	    public void clickOnSettingsIcon() {
		    settingsIcon.click();
	    }
	
	    public void clickOnSwitchAccountsIcon() {
		    switchAccountsIcon.click();
	    }
	
	    public void logOut() {
		    logout.click();
	    }
}
