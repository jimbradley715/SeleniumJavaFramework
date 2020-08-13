package com.qa.pages;

import com.qa.base.TestBase;

public class BeerStylesPage extends TestBase{

	
	//Beer Styles Page Actions
	public String validateBeerStylesPageTitle(){
		return driver.getTitle();	
	}
	
	
}

