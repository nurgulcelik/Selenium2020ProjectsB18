package test.day8_alerts_iframes_window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class IframePractice {
    /*
    TC #4: Iframe practice
    1.Create a new class called: IframePractice
    2.Create new test and make set ups
    3.Go to: http://practice.cybertekschool.com/iframe
    4.Assert: “Your content goes here.” Text is displayed.
    5.Assert: “An iFrame containing the TinyMCEWYSIWYG Edito
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {


        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe ");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void iframe_practice_test() {
        WebElement  iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
       // driver.switchTo().frame(iframe);
        //driver.switchTo().frame(0);
        driver.switchTo().frame("mce_0_ifr");
        WebElement  yourContentGoesHereText=driver.findElement(By.xpath("//p"));
        System.out.println(yourContentGoesHereText.isDisplayed());
       // driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
        WebElement h3Text= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(h3Text.isDisplayed());
    }
}