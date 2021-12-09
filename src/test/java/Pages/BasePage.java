package Pages;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.PropertiesReader;
import managers.FileReaderManager;
import testDataTypes.loginPageData;


// reusable methods

public class BasePage {
    public WebDriver driver;
   
//public 

    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,60);
    }
  
       
    

    //Click Method
    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Write Text
    public void writeText(By elementLocation, String text) {
        //threadWait(3000);
        driver.findElement(elementLocation).sendKeys(text);
    }
    //Select Text
    public void selectText(By elementLocation, Integer index) {
        //threadWait(3000);
        Select se = new Select(driver.findElement(elementLocation));
        se.selectByIndex(index);
    }
    //Select Text
    public void selectText(By elementLocation, String text) {
        //threadWait(3000);        
        Select se = new Select(driver.findElement(elementLocation));
        se.selectByVisibleText(text.replace("\"", ""));
        //driver.findElement(elementLocation).sendKeys(text);
    }
    //Read Text
    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

    //Wait
    public void waitVisibility(By by){  
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);      
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

     //tab
     public void tab(By elementLocation){       
        driver.findElement(elementLocation).click(); 
        //threadWait(2000);
        driver.findElement(elementLocation).sendKeys(Keys.TAB);
        //threadWait(2000);
    }

    public void threadWait(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
        }
    }

    public void clickbyExecuteJavaScript(By by){
        
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
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
        // return "src\\main\\resources\\screencaptures\\";
        return "G:\\Digital Experience\\Katalon\\NomArtifacts\\04_26_2021\\Test\\";
    }

    // public loginPageData FirstPageDataObjbydataType(String dataType){
    //     //return FileReaderManager.getInstance().getJsonReader().getOAOFirstPageData(dataType);
    // } 

    public String GetSecurityQuestionAnswer(Object question){
        try {

            String oaoThirdPageFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "oaoThirdPageDataSrc.json";

            FileReader reader = new FileReader(oaoThirdPageFilePath);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(reader);
            JsonObject obj = element.getAsJsonObject();
            Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();
            for(Map.Entry<String, JsonElement> entry: entries) {
                //JOptionPane.showMessageDialog(null,entry.getKey(),"entry.getKey()",JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null,question,"question",JOptionPane.WARNING_MESSAGE);
                if(question.toString().toLowerCase().contains(entry.getKey().toString().toLowerCase())){
                   //JOptionPane.showMessageDialog(null,"Question: "+question + "// Answer: "+entry.getValue().toString(),"question : answer",JOptionPane.WARNING_MESSAGE);
                    return entry.getValue().toString();
                }
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }




    public String FutureDate(int year){
		ZoneId zonedId = ZoneId.of( "America/Montreal" );
		LocalDate today = LocalDate.now( zonedId );
		LocalDate date= today.plusYears(year);
		//messageBox(date)
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return date.format(formatters);

	}
    public String PastDate(int year){
		ZoneId zonedId = ZoneId.of( "America/Montreal" );
		LocalDate today = LocalDate.now( zonedId );
		LocalDate date= today.minusYears(year);
		//messageBox(date)
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return date.format(formatters);
	}


    public void storeKey(Object k, Boolean bool){
        try {                         
            
            FileWriter myWriter = new FileWriter("src/main/resources/Keys/key.txt",bool);
            myWriter.write(String.valueOf(k));
            //JOptionPane.showMessageDialog(null,String.valueOf(k),"String.valueOf(k)",JOptionPane.WARNING_MESSAGE);
            myWriter.close();             
            System.out.println("Successfully wrote primary key to text file.");
        } catch (IOException e) {
            System.out.println("An error occurred while storing primary key to text file");
            e.printStackTrace();
        }
    }

    public String getPrimKey() {
        try {
            File myObj = new File("src/main/resources/Keys/key.txt");
            Scanner myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();              
            }
           
            myReader.close();          
            return data;
        } catch (FileNotFoundException e) {

            System.out.println("An error occurred while getting name from key text file");
            e.printStackTrace();  
            return null;         
        }
       
    }

    public Boolean verifyElementbyText(String text){       
        
        List<WebElement> list= driver.findElements(By.xpath("//*[contains(text(),'"+text+"')]"));
        // verify list size
        if ( list.size() > 0){
           System.out.println("Text: " + text + " is present. "); return true;
        } else {
           System.out.println("Text: " + text + " is not present. "); return false;
        }
    }


    public String pomPropertyValue(String property) throws IOException{
        PropertiesReader reader = new PropertiesReader("properties-from-pom.properties"); 
       return reader.getProperty(property);       
    }

    
}