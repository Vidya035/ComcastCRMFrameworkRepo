package com.workshop.basetest;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.workshop.generic.fileutility.ExcelUtility;
import com.workshop.generic.fileutility.FileUtility;
import com.workshop.generic.webdriverutility.JavaUtility;
import com.workshop.generic.webdriverutility.UtilityClassObject;

public class BaseClass {

    public FileUtility fLib = new FileUtility();
    public ExcelUtility eLib = new ExcelUtility();
    public JavaUtility jLib = new JavaUtility();
    public WebDriver driver = null;
    public static WebDriver sdriver = null;

    @BeforeClass
    public void configBC() throws Throwable {
        System.out.println("==Launch the BROWSER==");
        
        // 1. Get browser name from properties FIRST
        String BROWSER = fLib.getDataFromProperties("Browser");

        // 2. Initialize driver based on browser type
        if (BROWSER.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            
            // Map to disable "Save Address" and "Save Password" prompts
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("autofill.profile_enabled", false); 
            prefs.put("credentials_enable_service", false); 
            prefs.put("password_manager_enabled", false); 
            
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--incognito"); // Optional: Opens in incognito for a clean session
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
            
            driver = new ChromeDriver(options);
        } 
        else if (BROWSER.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } 
        else if (BROWSER.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } 
        else {
            // Default fallback
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        sdriver = driver;
        UtilityClassObject.setDriver(driver);
    }

    @BeforeMethod
    public void configBM() throws Throwable {
        System.out.println("Login");
        String URL = fLib.getDataFromProperties("Url");
        driver.get(URL);
    }

    @AfterMethod
    public void configAM() {
        System.out.println("==Test Completed==");
    }

    @AfterClass
    public void configAC() {
        System.out.println("==Close the BROWSER==");
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Generic popup handler for DOM-based alerts/modals
     */
    public void handleAnyPopup() {
        try {
            driver.switchTo().alert().dismiss();
            System.out.println("JS Alert dismissed!");
            return;
        } catch (Exception e) {}

        try {
            List<WebElement> pops = driver.findElements(By.xpath(
                "//*[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'no thanks')]"
            ));
            for (WebElement popup : pops) {
                if (popup.isDisplayed()) {
                    popup.click();
                    System.out.println("Web Popup closed!");
                    break;
                }
            }
        } catch (Exception e) {}
    }
}