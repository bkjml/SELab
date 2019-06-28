/*
	Matias BIrhane
*?

package selinium;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.support.ui.WebDriverWait;


public class gmail {

 public static void main(String[] args) throws InterruptedException {
     
  System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    //WebDriver driver = new ChromeDriver();

        //Launch gmail website
        driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

        //Find the email input filed and seed it your email address
        driver.findElement(By.id("identifierId")).sendKeys("mattbirhane@gmail.com");

        //Find the Next button and click it
        driver.findElement(By.id("identifierNext")).click();

        //Initialize web driver to stop the execution until the passwordNext button in clickable
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(elementToBeClickable(By.id("passwordNext")));
        Thread.sleep(2000);
        //Find the password input filed and seed it your password
        driver.findElement(By.name("password")).sendKeys("xxx");

        //Find the Next(Login) button and click it
        driver.findElement(By.id("passwordNext")).click();

        //Stop the execution until the Updates button in clickable
        wait.until(presenceOfElementLocated(By.xpath("//*[@aria-label='Primary']")));
        Thread.sleep(2000);

        //Get Web Elements that contain unread message
        List<WebElement> unreadMessages = driver.findElements(By.className("zE"));

        //print unread messages
        printUnreadMessage(unreadMessages);

        //export unread messages
        String filename = "unreadMessages" + new Date().getTime() + ".txt";
        exportUnreadMessage(unreadMessages,filename);

        driver.quit();
    }
    public static void printUnreadMessage(List<WebElement> unreadMessages){
        System.out.println("Total Number Of Unread Messages: " + unreadMessages.size());
        for (int i =0; i < unreadMessages.size(); i++){
                        System.out.println("Sender Email: " + unreadMessages.get(i).findElement(By.className("zF")).getAttribute("email"));
            System.out.println("Subject: " + unreadMessages.get(i).findElement(By.className("bog")).getText());
            System.out.println("Body: " + unreadMessages.get(i).findElement(By.className("y2")).getText());
                        System.out.println();
        }
    }
    public  static void exportUnreadMessage(List<WebElement> unreadMessages,String filename){
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename);
            writer.append("Total Number Of Unread Messages: " + unreadMessages.size() + "\n");
            for (int i =0; i < unreadMessages.size(); i++){
                \n");
                writer.append("Sender Email: " + unreadMessages.get(i).findElement(By.className("zF")).getAttribute("email") + "\n");
                writer.append("Subject: " + unreadMessages.get(i).findElement(By.className("bog")).getText() + "\n");
                writer.append("Body: " + unreadMessages.get(i).findElement(By.className("y2")).getText() + "\n");
                \n");
                writer.append("\n");
                writer.flush();
            }
        } catch (IOException ex) {

        } finally {
            try {
                writer.close();
            } catch (IOException ex) {

            }
        }}}









