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

public class AlertsPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        /*
        TC #1: Information alert practice
        1.Open browser
        2.Go to website: http://practice.cybertekschool.com/javascript_alerts
        3.Click to “Click for JS Alert”button
        4.Click to OK button from the alert
        5.Verify “You successfuly clicked an alert”text is displayed
         */
        driver = WebDriverFactory.getDriver("chrome");
        driver.get(" http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void p1_information_alert_task(){
        WebElement infoAlertButton= driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        infoAlertButton.click();
        Alert alert= driver.switchTo().alert();
        alert.accept();
        WebElement resultText= driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed());
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(1000);
        driver.close();
    }
    @Test
    public void p2_confirmation_alert_test(){
        WebElement confirmationAlertButton= driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmationAlertButton.click();
        Alert alert= driver.switchTo().alert();
        alert.dismiss();
        WebElement resultText= driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed());
    }
    }

