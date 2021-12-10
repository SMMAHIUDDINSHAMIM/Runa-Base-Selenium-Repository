package Steps;

import java.io.IOException;

import Util.BaseUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class myTestSteps extends BaseUtility{

    private BaseUtility base;
   

    public myTestSteps (BaseUtility base){
        this.base = base;
    }
   

    @Given("^I navigate to sauce lab \"([^\"]*)\"$")
    public void openSauceLab(String url) throws IOException{       
        //JOptionPane.showMessageDialog(null,"Steps","myDriver",JOptionPane.WARNING_MESSAGE); 
        base._loginPage.gotoSauceLab(url);                
    }
    @When("^I enter username \"([^\"]*)\"$")
    public void enterUserName (String userName) throws Throwable {                     
        base._loginPage.enterUsername(userName);                   
    }

    @And("^I enter password \"([^\"]*)\"$")
    public void enterPassword(String Password) throws Throwable {             
        base._loginPage.enterPassword(Password);  
    }

    @And("I click login button")
    public void clickOnLoginButton() throws Throwable {        
        base._loginPage.clickLoginButton();                
    }

    @Then("^I validate user login is successful \"([^\"]*)\"$")
    public void validateLogin(String msg) throws Throwable {        
        base._loginPage.verifyElement(msg);                
    }

}



