package com.workshop.objectrepositoryutility;

public class testCode {
	/*
	 package webdemo;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Excelutility.Excelutiltiy;
import demowebpage.CheckOutBoxPage;
import demowebpage.Checkoutpage;
import demowebpage.Homepage;
import demowebpage.Loginpage;
import fileutility.Propertyfile;

public class DemoWebShop {
	public static void main(String[] args) throws IOException, InterruptedException {
		
	
		
		final Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one final
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
	
	
		Propertyfile pu= new Propertyfile();
		String Browser = pu.getDatafromProperty("browser");
		String Url=pu.getDatafromProperty("url");
		System.out.println(Browser);
		System.out.println(Url);
		WebDriver driver=new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Url);
		
		
		
		Excelutiltiy eu= new Excelutiltiy();
		String email = eu.getExceldemo("login", 1, 0);
		String password = eu.getExceldemo("login", 1, 1);
		Homepage hp= new Homepage(driver);
		hp.getLoginlink().click();
		
		Loginpage lp= new Loginpage(driver);
		lp.getEmailEdt().sendKeys(email);
		lp.getPasswordEdt().sendKeys(password);
		lp.getLoginEdt().click();
//		Thread.sleep(3000);
		//booklink
		hp.getBooklink().click();
		WebElement addtocart = driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]"));
		addtocart.click();
		
		
//		Thread.sleep(6000);
		//apparel & shoe
		hp.getApparelShoelink().click();
		WebElement addcart = driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]"));
		addcart.click();
		Thread.sleep(6000);
		
		WebElement Addcart = driver.findElement(By.xpath("//input[@id='add-to-cart-button-5']"));
		Addcart.click();
		
		Thread.sleep(3000);
		//digital download
		hp.getDigitallink().click();
		WebElement addcart2 = driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]"));
		addcart2.click();
		
		//cartlink
		hp.getCartlink().click();
//		Thread.sleep(6000);
		
		//click checkbox
		WebElement book = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		book.click();
		WebElement apparel = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		apparel.click();
		WebElement digital = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		digital.click();
		
//		Thread.sleep(3000);
		//checkout
		
		Checkoutpage cp= new Checkoutpage(driver);
		cp.getTerms().click();
		cp.getCheckout().click();
		
		
		//checkOut-Checkbox
		String Adress= eu.getExceldemo("login", 1, 2);
		CheckOutBoxPage cbp= new CheckOutBoxPage(driver);
		cbp.getAddressEdt().sendKeys(Adress);
		cbp.getContinueEdt().click();
		Thread.sleep(3000);
		cbp.getShippaddressEdt().sendKeys(Adress);
		Thread.sleep(3000);
		cbp.getShippingcontinueEdt().click();
		Thread.sleep(3000);
		cbp.getShippingoptionEdt().click();
		Thread.sleep(3000);
		cbp.getShippingmethodcontinueEdt().click();
		Thread.sleep(3000);
		cbp.getPaymentEdt().click();
		Thread.sleep(3000);
		cbp.getPaymentcontinueEdt().click();
		Thread.sleep(3000);
		cbp.getPaymentinfoEdt().click();
		Thread.sleep(3000);
		cbp.getConfirmEdt().click();
		
		Thread.sleep(3000);
		//orderid
		WebElement order = driver.findElement(By.xpath("//a[contains(text(),'Click here for order details.')]"));
		order.click();
		Thread.sleep(3000);
		WebElement orderid = driver.findElement(By.xpath("//strong[contains(text(),'Order #')]"));
		String text = orderid.getText();
		System.out.println(text);
	
		WebElement orderInfoPageTextEl = driver.findElement(By.xpath("//h1[text()='Order information']"));
		Assert.assertEquals(orderInfoPageTextEl.isDisplayed(), true  );
		//write back to excel
		eu.getExcelemp("OrderId", 1, 0, text);
		//System.out.println(OrderId);
			
	}

}
	 */

}
