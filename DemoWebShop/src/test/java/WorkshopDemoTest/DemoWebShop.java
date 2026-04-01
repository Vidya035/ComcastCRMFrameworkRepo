package WorkshopDemoTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.workshop.basetest.BaseClass;
import com.workshop.objectrepositoryutility.BillingAddress;
import com.workshop.objectrepositoryutility.ConfirmOrder;
import com.workshop.objectrepositoryutility.LoginPage;
import com.workshop.objectrepositoryutility.OrderSuccessPage;
import com.workshop.objectrepositoryutility.PaymentInformation;
import com.workshop.objectrepositoryutility.PaymentMethod;
import com.workshop.objectrepositoryutility.RegisterPage;
import com.workshop.objectrepositoryutility.ShippingAddress;
import com.workshop.objectrepositoryutility.ShippingMethod;
import com.workshop.objectrepositoryutility.ShoppingCart;
import com.workshop.objectrepositoryutility.ShoppingCheckOut;


public class DemoWebShop extends BaseClass
{
	@Test(dataProvider = "ProductName")
	public void Login(String[] products) throws Throwable
	{
		String FirstName = eLib.getDataFromExcel("WebShop_Reg", 1, 2);
	    String LastName = eLib.getDataFromExcel("WebShop_Reg", 2, 2);
	    String baseEmail = eLib.getDataFromExcel("WebShop_Reg", 3, 3);
	    String Email = baseEmail.replace("@gmail.com","") 
	                   + jLib.getRandomNumber() + "@gmail.com";
	    String Password = eLib.getDataFromExcel("WebShop_Reg", 4, 2);
	    String ConfirmPassword = Password;

	    RegisterPage rp = new RegisterPage(driver);
	    rp.clickRegisterLink();
	    rp.selectGender();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(rp.getEditFN()));
	    rp.UserRegDetails(FirstName, LastName, Email, Password, ConfirmPassword);
	    rp.clickRegisterButton();
	    
	    
	    String actualMsg = rp.getRegistrationMessage();
        System.out.println("Registration Message: " + actualMsg);

        Assert.assertTrue(actualMsg.contains("completed"),
                "Registration Failed: " + actualMsg);
	    
	    LoginPage lp=new LoginPage(driver);
	    if(driver.getPageSource().contains("Log out"))
	    {
	        System.out.println("User already logged in after registration");
	    }
	    else
	    {
	        lp.clickLoginlink();
	        lp.Login(Email, Password);
	        lp.clickLoginBtn();
	    }
	    ShoppingCart sc=new ShoppingCart(driver);

	    for(String product : products)
	    {
	    
	        System.out.println("Adding product: " + product);
	        if(product.equalsIgnoreCase("Laptop"))
	        {
	            sc.searchAndSelectAutoSuggestion("Lap", "14.1-inch Laptop");
	        }
	        else
	        {
	            sc.searchAndSelectAutoSuggestion(product, product);
	        }

	        sc.clickAddToCart();
	        WebElement successMsg = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                    By.cssSelector("#bar-notification p"))
	            );

	        System.out.println("Added: " + successMsg.getText());
	        wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector(".close")))
	            .click();
	    }
	    sc.clickShoppingCart();
	  ShoppingCheckOut scd=new ShoppingCheckOut(driver);
	  scd.ClickCheckBox();
	  scd.ClickCheckoutBtn();
	  
	  
	  String Fname = eLib.getDataFromExcel("CheckoutData", 1, 0);
	  String Lname = eLib.getDataFromExcel("CheckoutData", 2, 0);
	  String EmailAdd = Email;
	  String CompanyName = eLib.getDataFromExcel("CheckoutData", 4, 0);
	  String CityName = eLib.getDataFromExcel("CheckoutData", 5, 0);
	  String Addr1 = eLib.getDataFromExcel("CheckoutData", 6, 0);
	  String Addr2 = eLib.getDataFromExcel("CheckoutData", 7, 0);
	  String PostC = eLib.getDataFromExcel("CheckoutData", 8, 0);
	  String PhoneNum = eLib.getDataFromExcel("CheckoutData", 8, 1);
	  String FaxNum = eLib.getDataFromExcel("CheckoutData", 8, 2);
	  String Countryname = eLib.getDataFromExcel("CheckoutData", 1, 1);
	  
	  BillingAddress co=new BillingAddress(driver);
	  co.CheckDetails(Fname, Lname, EmailAdd, CompanyName, CityName, Addr1, Addr2, PostC, PhoneNum, FaxNum);
	  co.selectCountry(Countryname);
	  co.ClickContinueBtn();
	  
	  ShippingAddress shipAdd=new ShippingAddress(driver);
	  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
	  wait1.until(ExpectedConditions.visibilityOf(shipAdd.getContinBtn()));
	  Thread.sleep(2000);
	  shipAdd.ClickShipAddressContinueBtn();
	  
	  ShippingMethod shipMethod=new ShippingMethod(driver);
	  WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
	  wait2.until(ExpectedConditions.visibilityOf(shipMethod.getShippingMetContinueBtn()));
	  shipMethod.ClickShipMethodContinueBtn();
	  
	// --- UPDATED PAYMENT SECTION ---
      PaymentMethod payMeth = new PaymentMethod(driver);
      payMeth.ClickPayementRadioBtn();
      payMeth.clickPaymentMethodContinueBtn(); // Uses the improved logic

      PaymentInformation payInfo = new PaymentInformation(driver);
      payInfo.ClickPaymentInfoContinueBtn(); // Handles scrolling and clicking internally
      
      ConfirmOrder confOrder=new ConfirmOrder(driver);
      confOrder.ClickConfirmBtn();
      
      // Final Step: Capture and Save Order Number
      OrderSuccessPage successPage = new OrderSuccessPage(driver);
      String orderID = successPage.getOrderNumber();
      System.out.println("Captured Order ID: " + orderID);

      // Writing to Excel: (SheetName, RowNum, CellNum, Data)
     
      eLib.setDataIntoExcel("OrderNumber", 0, 1, orderID); 

      System.out.println("Order ID successfully written to Excel.");
	}
	@DataProvider
	public Object[][] ProductName() throws Throwable
	{
		String Product1 = eLib.getDataFromExcel("Products", 1,0);
		String Product2 = eLib.getDataFromExcel("Products", 2,0);
		String Product3 = eLib.getDataFromExcel("Products", 3,0);
		
		return new Object[][] {
		    { new String[]{Product1, Product2, Product3} }};	
	}
	
}


