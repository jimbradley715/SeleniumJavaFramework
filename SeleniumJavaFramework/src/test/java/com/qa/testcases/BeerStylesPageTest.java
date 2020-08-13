package com.qa.testcases;

import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.BeerStylesPage;
import com.qa.pages.HomePage;

public class BeerStylesPageTest extends TestBase{
	HomePage homePage;
	BeerStylesPage beerstylesPage;

	public BeerStylesPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void Setup() {
		initialization();
		homePage = new HomePage();
		beerstylesPage = new BeerStylesPage();
		homePage.clickBeerStylesLink();
	}
	
	@Test
	@Ignore
	public void verifyBeerStylesTitleTest() {
		String beerStylesPageTitle = beerstylesPage.validateBeerStylesPageTitle();
		Assert.assertEquals(beerStylesPageTitle, "Beer Styles | BeerAdvocate");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
