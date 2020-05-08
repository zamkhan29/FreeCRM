package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameLable;
	
	@FindBy(xpath="//span[contains(text(), 'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//span[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOncontactsLink() {
		contactLink.click();
		return new ContactsPage();
		
	}
	public DealsPage clickOndealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	public boolean verifyCorretUserName() {
		return userNameLable.isDisplayed();
	}


}
