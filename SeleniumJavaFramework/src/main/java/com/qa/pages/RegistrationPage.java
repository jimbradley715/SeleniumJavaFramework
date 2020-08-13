package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class RegistrationPage extends TestBase{
	
	//Object Repository - Page Factory
	@FindBy(xpath="//label[contains(text(), 'Male')]")
			WebElement maleRadioBtn;
	
	@FindBy(xpath="//label[contains(text(), 'unspecified')]/input")
			WebElement unspecifiedRadioBtn;
	
	@FindBy(xpath="//input[@name='agree']")
		WebElement agreeChbx;
	
	@FindBy(xpath="//input[@id='SubmitButton']")
		WebElement submitBtn;
	
	//Initializing the Page Objects:
		public RegistrationPage(){
			PageFactory.initElements(driver, this);
		}
	
	//Registration Page Actions
	public boolean validateMaleRadioBtn(){
		return maleRadioBtn.isSelected();
	}
	
	public boolean validateUnspecifiedRadioBtn(){
		return unspecifiedRadioBtn.isSelected();
	}
	
	public void clickAgree(){
		agreeChbx.click();
	}
	
	public boolean validateSubmitBtn(){
		 return submitBtn.isEnabled();
	}
}
