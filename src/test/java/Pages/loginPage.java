package Pages;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import Util.AES;
import Util.OCR;
import managers.FileReaderManager;
import testDataTypes.loginPageData;



// steps for Home Page

public class loginPage extends BasePage {

    /**Constructor*/
    public loginPage(WebDriver driver) {
        super(driver);
    }

    // ************************ Web Elements *********************
    private String env = "";
    By Account = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div/div/div[3]/div/button");
    By SuccessMsg = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div/div/div[3]/div/ul/li[5]/a/span[1]");
    By UserName = By.id("idToken1");
    By Password = By.id("idToken2");
    By LoginButton = By.xpath("//input[@id='loginButton_0']");

    public loginPage gotoSauceLab(String url) throws IOException {                
        //String url = "";
        
        // env = pomPropertyValue("ApplicationEnv");
        
        // url = FileReaderManager.getInstance().getConfigReader().getOAOApplicationEnvironment(env); 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.navigate().refresh();
        //driver.manage().window().maximize();
        return this;
    }
    public loginPage enterUsername(String value)  {              
        writeText(UserName,value);
        return this;
    }
    public loginPage enterPassword(String value)  {                
        writeText(Password,value);
        return this;
    }
    public loginPage clickLoginButton()  {
        click(LoginButton);
        threadWait(3000);
        return this;
    }
    
    public loginPage verifyElement(String expectedText)  {
        // waitVisibility(SuccessMsg);
        //Thread.sleep(4000);
        click(Account);
        threadWait(3000);
        Assert.assertEquals(readText(SuccessMsg), expectedText);
        return this;
    }

    // public loginPage verifyMemberFields(String memberFieldText, String accountFieldText)  {
    //     Assert.assertEquals(readText(MemberField), memberFieldText);
    //     Assert.assertEquals(readText(AccountField), accountFieldText);
    //     return this;
    // }
   

   

    // public loginPage ContactInformation(String email,String mobileNumber,String homeNumber) {   
    //     writeText(Email, email);
    //     writeText(MobileNumber, mobileNumber);
    //     writeText(HomeNumber, homeNumber);    
    //     Reporter.log("Data entry in ContactInformation - Successful");
    //     return this;
    // }   


   
    // public loginPage HomeAddress(String street,String city,String state,String zip) {            
    //     writeText(StreetAddress, street);
    //     writeText(City, city);
    //     selectText(State, state);    
    //     writeText(Zip, zip); 
    //     click(SaveAddress);                
    //     Reporter.log("Data entry in Address - Successful");
    //     return this;
    //  }  
    //  public loginPage MailingAddress(String street,String city,String state,String zip) {        
    //     if (!street.isEmpty()){
    //         click(AddAddress);
    //         click(MailingDropdown);
    //         writeText(StreetAddress, street);
    //         writeText(City, city);
    //         selectText(State, state);    
    //         writeText(Zip, zip);         
    //         click(SaveAddress);   
    //         Reporter.log("Data entry in Address - Successful");
    //     }
    //     return this;
    // }
    // public loginPage WorkAddress(String street,String city,String state,String zip) {   
    //     if (!street.isEmpty()){
    //         click(AddAddress);
    //         click(WorkDropdown);
    //         writeText(StreetAddress, street);
    //         writeText(City, city);
    //         selectText(State, state);    
    //         writeText(Zip, zip);
    //         click(SaveAddress);            
    //         Reporter.log("Data entry in Address - Successful");           
    //     }
    //     return this;
    // }


    //  public loginPage saveAddress() {
    //     click(SaveAddress);     
    //     return this;
    //  }

    //  public loginPage clickMemberToggle()  {
    //     click(MemberToggle);     
    //      return this;
    //  }

    //  public loginPage _continue()  {
       
    //     click(Continuebtn);

    //     return this;
    //  }

    
  
}