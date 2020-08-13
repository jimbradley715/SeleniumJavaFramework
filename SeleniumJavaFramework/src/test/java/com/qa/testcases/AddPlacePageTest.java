package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AddPlacePage;
import com.qa.pages.HomePage;
import com.qa.util.TestUtil;

public class AddPlacePageTest extends TestBase {
	HomePage homePage;
	AddPlacePage addplacePage;
	
	String sheetName = "places";

	public AddPlacePageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		homePage = new HomePage();
		homePage.login(prop.getProperty("name"), prop.getProperty("password"));
		addplacePage = new AddPlacePage();
		homePage.clickAddPlaceLink();
	}
	
	@Test
	@Ignore
	public void addPlacePageTitleTest() {
		String addPlacePageTitle = addplacePage.validateAddPlacePageTitle();
		Assert.assertEquals(addPlacePageTitle, "Toolbox | Add Place | BeerAdvocate");
	}
	
	@DataProvider
	public Object[][] getAddPlacesData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getAddPlacesData") 
	public void validateAddPlace(String name, String address, String city, String country, String state, 
			String zip, String phone, String website) {
		addplacePage.addPlace(name, address, city, country, state, zip, phone, website);
			String successTxt = addplacePage.addPlaceSuccess();
			Assert.assertEquals(successTxt, "Success! Thank you for adding a place. Places must be approved by BeerAdvocate before they appear on the website.", "The form did not submit successfully");
		}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
