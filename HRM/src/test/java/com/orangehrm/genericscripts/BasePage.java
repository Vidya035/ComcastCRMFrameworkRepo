package com.orangehrm.genericscripts;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.orangehrm.pageobjects.DashBoardPageObjects;
import com.orangehrm.pageobjects.LoginPageObjects;
import com.orangehrm.pageobjects.PIMPageObjects;
import com.orangehrm.utilities.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage  
{
	//Global Variables
	public WebDriver driver;
	public LoginPageObjects lp;
	public DashBoardPageObjects dp;
	public PIMPageObjects pim;
	
	@BeforeClass
	@Parameters("browserName")
	
	public void initBrowser(String browserName)
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		switch(browserName.trim().toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();
			break;
		case "fire":driver=new FirefoxDriver();
			break;
		default:System.out.println("====Invalid Browser====");
		}
	}
	@BeforeMethod
	public void launchApplication() throws Exception
	{
		
		String url=ReadPropertyFile.readData("testUrl");
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		driver.manage().window().maximize();
		  lp = new LoginPageObjects(driver);
		  dp= new DashBoardPageObjects(driver);
		  pim= new PIMPageObjects(driver);
		  login();	  
	}
	
	public void login() throws Exception
	{
		String usn = ReadPropertyFile.readData("testUsn");
		String psw = ReadPropertyFile.readData("testPsw");
		lp.enterUsn(usn);
		lp.enterPsw(psw);
		
		lp.clickLoginBtn();
	}
//	@AfterMethod
//	public void logout()
//	{
//		dp.profileDropDownClick();
//		dp.logoutBtnClick();
//		
//	}
//
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
