package com.qa.pages;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

		
	//Object Repository - Page Factory
	@FindBy(xpath="//strong[@class='loginText']")
		WebElement login;	
	
	@FindBy(xpath="//dl[@class='ctrlUnit']//input[@id='ctrl_pageLogin_login']")
			WebElement name;
	
	@FindBy(xpath="//li[@id='ctrl_pageLogin_registered_Disabler']//input[@id='ctrl_pageLogin_password']")
			WebElement password;
	
	@FindBy(xpath="//form[@id='pageLogin']//input[@class='button primary']")
			WebElement loginBtn;
	
	@FindBy(xpath="//strong[contains(text(),'Sign up')]")
		WebElement signUp;
	
	@FindBy(xpath="//a[@class='navLink NoPopupGadget'][contains(text(), 'Places')]")
			WebElement menuPlacesLink;
	
	@FindBy(xpath="//div[@id='XenForoUniq5']//a[contains(text(),'Add a Place')]")
			WebElement menuAddPlaceLink;
	
	@FindBy(xpath="//a[@class='navLink NoPopupGadget'][contains(text(), 'Beers')]")
		WebElement menuBeersLink;
	
	@FindBy(xpath="//div[@id='XenForoUniq2']//a[contains(text(), 'Beer Styles')]")
		WebElement menuBeerStylesLink;
	
	@FindBy(id = "QuickSearchPlaceholder")
		WebElement searchIcon;
	
	@FindBy(xpath="//div[@class='sidebar']//a[@class='username NoOverlay'][contains(text(),'JimBradley')]")
			WebElement userNameLabel;
	
	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
		
	//Home Page Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public void clickSignUp() {
		signUp.click();
	}
	
	public void login(String un, String pswd) {
		login.click();
		//Thread.sleep(10000);
		name.sendKeys(un);
		//need to navigate to Password field to interact with it
			//JavascriptExecutor js = (JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", password);
		password.sendKeys(pswd);
		//password.submit();
		loginBtn.click();
	}
	
	public String verifyUserNameDisplay() {
		String unl = userNameLabel.getText();
		return unl;
		}
		
	public BeerStylesPage clickBeerStylesLink() {
		Actions action = new Actions(driver);
		action.moveToElement(menuBeersLink).build().perform();
		menuBeerStylesLink.click();
		return new BeerStylesPage();
	}
	
	public AddPlacePage clickAddPlaceLink() {
		Actions action = new Actions(driver);
		action.moveToElement(menuPlacesLink).build().perform();
		menuAddPlaceLink.click();
		return new AddPlacePage();
	}
}
