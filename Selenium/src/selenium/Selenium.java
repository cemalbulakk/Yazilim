/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 *
 * @author cemal
 */
public class Selenium {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Setup();
        
        driver.get("https://www.finartz.com");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Solutions")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> labels = driver.findElements(By.cssSelector(".title.section-title.has-text-centered.dark-text"));
        System.out.println(labels);
        driver.findElement(By.linkText("Blog")).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        //WebElement txtSearch = driver.findElement(By.cssSelector(".collectionHeader-blockNav"));
        //WebElement btnSearch = driver.findElement(By.className("svgIcon-use"));
        //txtSearch.sendKeys(labels.toString());
        //btnSearch.click();
        //txtSearch.sendKeys(Keys.ENTER);
        //Thread.sleep(2000);
        Stop();
        
    }
    
    protected static String ChromePath = "C:\\Users\\cemal\\OneDrive\\Masaüstü\\chromedriver_win32_3\\chromedriver.exe";
    protected static ChromeDriverService service;
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    
   public static void Setup(){
        service = new ChromeDriverService.Builder().usingDriverExecutable(new File(ChromePath)).usingAnyFreePort().build();       
        try{
            service.start();
        }catch(IOException e){
        }
        System.setProperty("webdriver.chrome.driver", ChromePath);
        
        driver = new RemoteWebDriver(service.getUrl(),new ChromeOptions());
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        
    }
    public static void Stop(){
        driver.quit();
        service.stop();
    }
}

