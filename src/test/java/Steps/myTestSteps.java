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


    // @When("^I enter \"([^\"]*)\"$")
    // public void eligibility (String firstName,String lastName,String dob, String ssn) throws Throwable {              
       
    //     base._loginPageData =  base._loginPage.getfirstPageDataObjbydataType();          
    //     base._loginPage.enterEligibilityData(base._loginPageData.eligibility.firstName, base._loginPageData.eligibility.lastName, base._loginPageData.eligibility.dOB, base._loginPageData.eligibility.sSN);                   
    //     base._loginPage.storeKey(base._loginPageData.eligibility.firstName,false);           
    // }

    // @And("^I enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" as contact information$")
    // public void contactInformation(String email, String mobileNumber, String homeNumber) throws Throwable {             
    //     base._loginPage.ContactInformation(base._loginPageData.contactInfo.email,base._loginPageData.contactInfo.mobile,base._loginPageData.contactInfo.home);       
    // }

    // @And("^I enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" as home address$")
    // public void homeAddress(String street, String city, String state, String zip) throws Throwable {        
    //     base._loginPage.HomeAddress(base._loginPageData.address.home.streetAddress,base._loginPageData.address.home.city,base._loginPageData.address.home.state,base._loginPageData.address.home.zip);                
    // }
    // @And("^I enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" as mailing address$")
    // public void mailingAddress(String street, String city, String state, String zip) throws Throwable {             
    //     base._loginPage.MailingAddress(base._loginPageData.address.mailing.streetAddress,base._loginPageData.address.mailing.city,base._loginPageData.address.mailing.state,base._loginPageData.address.mailing.zip);                
    // }
    
    // @And("^I enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" as work address$")
    // public void workAddress(String street, String city, String state, String zip) throws Throwable {        
    //     base._loginPage.WorkAddress(base._loginPageData.address.work.streetAddress,base._loginPageData.address.work.city,base._loginPageData.address.work.state,base._loginPageData.address.work.zip);                
    // }

    // @And("I Save Address")
    // public void saveAddress() throws Throwable {               
    //     base._loginPage.saveAddress();
    // }

    // @When("I click continue button")
    // public void _continue() throws Throwable {                
    //     base._loginPage._continue();
    // }

   
    // @When("^I tab from \"([^\"]*)\"$")
    // public void tabout(String fromField) throws Throwable {                
    //     base._loginPage.tabOut(fromField);
    // }    
   
    // @Then("^The field \"([^\"]*)\" validation error \"([^\"]*)\" is displayed$")
    // public void fieldValidation(String fieldName,String error) throws Throwable {                
    //     base._loginPage.fieldValidation(fieldName,error);
    // }   

    
    // @Given("^I land on first page \"([^\"]*)\"$")
    // public void _loginPage(String expectedString) throws Throwable {                
    //     base._loginPage.verifyElement(expectedString);
    // }

    // @When("I click on member security check toggle")
    // public void memberToggle() throws Throwable {                
    //     base._loginPage.clickMemberToggle();
    // }

    // @Then("^\"([^\"]*)\" and \"([^\"]*)\" appear$")
    // public void verifyFields(String memberFieldText, String accountFieldText) throws Throwable {                
    //     base._loginPage.verifyMemberFields(memberFieldText,accountFieldText);        
    // }
  
    // @Then("^I land on \"([^\"]*)\"$")
    // public void verifyFamilyEligibility(String expectedString) throws Throwable {                
    //     base._loginPage.verifyElementbyText(expectedString);
    // }

    // @When("^I click on \"([^\"]*)\"$")
    // public void clickEligibilityButton(String buttonText) throws Throwable {                
    //     base._loginPage.clickEligibilityButton(buttonText);
    // }
    
    // @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    // public void enterExistingMember(String memberNumber, String accountNumber) throws Throwable {                
    //     base._loginPage.enterExistingMember(base._loginPageData.member.memberNumber,base._loginPageData.member.accountNumber);
    // }
    

}



