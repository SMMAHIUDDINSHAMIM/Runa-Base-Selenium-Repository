package Runners;

import org.testng.annotations.Listeners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;





@CucumberOptions(features = "src/test/java/Features/SmokeTest",
//plugin = {"pretty", "html:target/cucumberreport/cucumberpretty","json:target/cucumberreport/cucumbertestreport.json"}, 
//plugin = {"json:./results/cucumber.json"}, 
plugin = {"pretty", "html:./oao/smoketest/results","json:./oao/smoketest/results/cucumber.json"}, 
        //format = {"pretty", "html:target/cucumber report/cucumber pretty","json:target/cucumber report/cucumbertestreport.json"},        
        tags = "@smoke",        
        
        glue = {"java", "Util","java", "Steps"})

        // glue = {"java", "Steps"})

 public class SmokeTestRunner extends AbstractTestNGCucumberTests{
        //public class RunnerTest {
        
}