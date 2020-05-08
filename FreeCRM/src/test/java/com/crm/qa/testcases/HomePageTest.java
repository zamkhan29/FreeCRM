package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		contactsPage = new ContactsPage();
		dealsPage= new DealsPage();
		loginPage = new LoginPage();
		//homePage =new HomePage();
		
		homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
	String homePageTitle = homePage.validateHomePageTitle();
		System.out.println("Home page Title is "+homePageTitle);
		Assert.assertEquals("CRM", homePageTitle);
		
	}
	@Test(priority=2)
	public void verifyContactsLinkTest() {
		contactsPage =homePage.clickOncontactsLink();
		
		
	}
	@Test(priority=3)
	public void verifyCorretUserNameTest() {
		Assert.assertTrue(homePage.verifyCorretUserName());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
