package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import com.asprise.ocr.Ocr;

public class OCR {
    
   

    public static String webUiImageText(WebElement element ) throws IOException {
        
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English

        String imageUrl = element.getAttribute("src");
        
        URL url = new URL(imageUrl);
        BufferedImage image = ImageIO.read(url);

        String s = ocr.recognize((RenderedImage) image,Ocr.RECOGNIZE_TYPE_ALL,Ocr.OUTPUT_FORMAT_PLAINTEXT);
        System.out.println("Text From Image : \n"+ s);
        System.out.println("Length of total text : \n"+ s.length());
        return s;
    }

    public static String localImageText(String filePath ) throws IOException {
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English

        BufferedImage image = ImageIO.read(new File(filePath));   
        String s = ocr.recognize((RenderedImage) image,Ocr.RECOGNIZE_TYPE_ALL,Ocr.OUTPUT_FORMAT_PLAINTEXT);
        System.out.println("Text From Image : \n"+ s);  
        System.out.println("Length of total text : \n"+ s.length()); 
        return s;
    }


}
