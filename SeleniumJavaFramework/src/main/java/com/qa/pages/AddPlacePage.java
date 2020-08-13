package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class AddPlacePage extends TestBase {

	//Object Repository - Page Factory
	
	@FindBy(xpath="//input[@id='name']")
			WebElement name;
	
	@FindBy(xpath="//input[@id='addr']")
			WebElement address;
	
	@FindBy(xpath="//input[@id='city']")
			WebElement city;
	
	//@FindBy(id="countryId")
	//	WebElement countryDropdown;
	
	@FindBy(xpath="//input[@id='zip']")
			WebElement zip;
	
	@FindBy(xpath="//input[@id='phone']")
			WebElement phone;
	
	@FindBy(xpath="//input[@id='URL']")
			WebElement website;
	
	@FindBy(xpath="//input[@id='brewery']")
			WebElement brewsBeerChbx;
	
	@FindBy(xpath="//input[@id='bar']")
			WebElement barChbx;
	
	@FindBy(xpath="//input[@name='submit']")
			WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='edit' and (contains(text(), 'Success!'))]")
			WebElement successMsg;
	
	@FindBy(xpath="//div[@class='baseHtml errorDetails' and (contains(text(), 'Please check zip code format'))]")
			WebElement zipFormatErrorMsg;
	
	//Initializing the Page Objects:
		public AddPlacePage(){
			PageFactory.initElements(driver, this);
		}
		
	//Add Place Page Actions
		public String validateAddPlacePageTitle() {
			return driver.getTitle();
		}
		
		public void addPlace(String n, String add, String cty, String country, String state, String z,
			String pho, String web ) {
			name.sendKeys(n);
			address.sendKeys(add);
			city.sendKeys(cty);
			Select select = new Select(driver.findElement(By.id("countryId")));
			select.selectByVisibleText(country);
			Select selection = new Select(driver.findElement(By.id("stateId")));
			selection.selectByVisibleText(state);
			zip.sendKeys(z);
			phone.sendKeys(pho);
			website.sendKeys(web);
			barChbx.click();
			submitBtn.click();
		}	
		
		
		public String addPlaceSuccess() {
			String successTxt = successMsg.getText();
			return successTxt;
		}
		
		public String invalidZip() {
			String errorTxt = zipFormatErrorMsg.getText();
			return errorTxt;
		}		
}
