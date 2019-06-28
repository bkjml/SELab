/* Matias Birhane 
    se lab
*/


package selinium;

import TestIpackage.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginToPortal {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, InterruptedException{
    System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
    WebDriver driver =new FirefoxDriver();
        driver.get("https://portal.aait.edu.et");
        String title = driver.getTitle();
        System.out.println(title);
        driver.findElement(By.name("UserName")).sendKeys("ATR/1530/09");
        driver.findElement(By.id("Password")).sendKeys("xxxx");
        driver.findElement(By.className("btn-success")).click();
        String reportUrl = driver.findElement(By.id("m2")).findElement(By.className("dropdown-menu")).findElements(By.tagName("li")).get(0).findElements(By.tagName("a")).get(0).getAttribute("href");
        driver.navigate().to(reportUrl);
        String table = driver.findElement(By.className("table")).getText();
        System.out.println(table);
        PrintWriter writer = new PrintWriter("gradeReport", "UTF-8");
        writer.print(table);
        writer.close();
        Thread.sleep(5000);
        driver.quit();
        System.out.println("Finished");
    
    
    }
}
