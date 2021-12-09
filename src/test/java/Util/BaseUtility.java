package Util;
import org.openqa.selenium.WebDriver;
import Pages.loginPage;
import testDataTypes.loginPageData;

public class BaseUtility {

     // Driver
     public WebDriver driver;

     // page
     public loginPage _loginPage;
 
     // data
     public loginPageData _loginPageData; 
 
     public WebDriver getDriver() {
         return driver;
     }
}
