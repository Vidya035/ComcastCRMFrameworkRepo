package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Dashboard")
	private WebElement DashboarLink;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDashboarLink() {
		return DashboarLink;
	}
	
	
	@FindBy(linkText = "Search")
	private WebElement SearchLink;
	
	public WebElement getSearchLink() {
		return SearchLink;
	}
}
