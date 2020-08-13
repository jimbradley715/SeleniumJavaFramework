package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.RegistrationPage;



public class RegistrationPageTest extends TestBase{

	HomePage homePage;
	RegistrationPage registrationPage;
	
	public RegistrationPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		homePage.clickSignUp();
		registrationPage = new RegistrationPage();		
	}
	
	@Test(priority = 1)
	@Ignore
	public void maleRadioBtnTest() {
		boolean flag = registrationPage.validateMaleRadioBtn();
		Assert.assertFalse(flag);
	}
	
	@Test(priority = 2)
	@Ignore
	public void unspecifiedRadioBtnTest() {
		boolean state = registrationPage.validateUnspecifiedRadioBtn();
		Assert.assertTrue(state);
	}
	
	@Test(priority=3)
	public void submitButtonDisabledTest() {
		boolean state = registrationPage.validateSubmitBtn();
		Assert.assertTrue(state);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

