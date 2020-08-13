package com.qa.testcases;

//import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.BeerReviewPage;
import com.qa.pages.BeerStylesPage;
import com.qa.pages.HomePage;

public class HomePageTest extends TestBase{
	HomePage homePage;
	BeerReviewPage beerreviewPage;
	BeerStylesPage beerstylesPage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test(priority = 1)
		public void homePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Beer Advocate");
	}
	
	@Test(priority = 2)
	public void successfulLoginTest() throws InterruptedException
	{
		homePage.login("boo_jim@yahoo.com", "1lovebeer");
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit. SECONDS);
		//Thread.sleep(5000);
		String label = homePage.verifyUserNameDisplay();
		Assert.assertEquals(label, "JimBradley", "Login was successful");		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
