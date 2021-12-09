package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;

//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
 //import cucumber.junit.Cucumber;

//@RunWith(Cucumber.class)



@CucumberOptions(features = "src/test/java/Features/RegressionTest",
//plugin = {"pretty", "html:target/cucumberreport/cucumberpretty","json:target/cucumberreport/cucumbertestreport.json"}, 
//plugin = {"json:./results/cucumber.json"}, 
        plugin = {"pretty", "html:./results","json:./results/cucumber.json"}, 
        
        //format = {"pretty", "html:target/cucumber report/cucumber pretty","json:target/cucumber report/cucumbertestreport.json"},        
        tags = "@regression",        
        
        glue = {"java", "Util","java", "Steps"})

        // glue = {"java", "Steps"})

 public class RegressionTestRunner extends AbstractTestNGCucumberTests{
        //public class RunnerTest {
        
}