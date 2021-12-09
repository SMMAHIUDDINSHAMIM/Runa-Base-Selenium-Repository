package Util;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import com.saucelabs.saucebindings.SaucePlatform;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import Pages.loginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.FileReaderManager;
import managers.WebDriverManager;



public class Hook extends BaseUtility{

    private static boolean initialized = false;
    private static WebDriver myDriver = null;
    WebDriverManager webDriverManager;
    private BaseUtility base;
    private String platform = System.getProperty("os.name");



    public Hook (BaseUtility base){
        this.base = base;
    }
    
    @Before
    public void  classLevelSetup(Scenario scenario) throws IOException {        

     

        if (!initialized) {
           
     

            webDriverManager = new WebDriverManager();
            base.driver = webDriverManager.getDriver();
            myDriver = webDriverManager.getDriver();
            
         
            initialized = true;
        }

        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        base._loginPage = new loginPage(myDriver);        
    }

  
    // @BeforeMethod
    // public void methodLevelSetup() {
    //     //_getStarted = new GetStartedPage(driver);
    //     //enrollmentPage = new EnrollmentPage(driver);
    // }
 
    
    @After
    public void teardown(Scenario scenario) {
        

        String screenShotName = scenario.getName().replaceAll(" ", "_");                 
        if(screenShotName.toLowerCase().contains("logout")) return;    

        try {
              
           

                if(((RemoteWebDriver)myDriver).getSessionId() != null){
                    TakesScreenshot s = (TakesScreenshot)  myDriver;
                    byte[] screenByte = s.getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenByte, "image/png", screenShotName);
                }
               
               
               // save as
               capturePNG(scenario.getName());              

        } catch (Exception e) {
            e.printStackTrace();
        }
        base.driver.close();
        base.driver.quit();
    }

    public void capturePNG(String fileName) {
        try {
            BufferedImage screencapture = new Robot().createScreenCapture(
                    new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            
            if(!fileName.contains(".png")){
                fileName = fileName+".png";
            }
            File file = new File(filePath()+fileName);
            ImageIO.write(screencapture, "png", file);

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String filePath(){
        ZoneId zonedId = ZoneId.of( "America/Montreal" );
        LocalDate today = LocalDate.now( zonedId );

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String todaysDate = today.format(formatters);
        String dir = "src\\main\\resources\\screencaptures\\"+todaysDate.replace("/", "_") +"\\";
        //String dir = "G:\\Digital Experience\\SeleniumCucumberJVM\\"+todaysDate.replace("/", "_") +"\\";
        //JOptionPane.showMessageDialog(null,dir,"dir",JOptionPane.WARNING_MESSAGE); 
        File directory = new File(dir);
        if (! directory.exists()){            
            directory.mkdir();
            //JOptionPane.showMessageDialog(null,"make","make",JOptionPane.WARNING_MESSAGE); 
        }
        return  dir;
    }
    
  
}
