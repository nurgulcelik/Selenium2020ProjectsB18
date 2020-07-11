package test.day8_alerts_iframes_window;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class informationAlertPractice {
    /*TC #3: Information Alert practice
 * * 1.Open browser
 * * 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
 * * 3.Click to "Click for JS Prompt" button
 * * 4.Send "hello"text to alert
 * * 5.Click to OK button from the alert
 * * 6.Verify "You entered:  hello" text is displayed.
 */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }@Test
    public void promptAlert(){
        WebElement promptAlert= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        promptAlert.click();
        Alert alert= driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();
        WebElement resultMessage= driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultMessage.isDisplayed());
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(1000);
        driver.close();
    }
    }






