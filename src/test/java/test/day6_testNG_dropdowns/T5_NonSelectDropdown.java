package test.day6_testNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class T5_NonSelectDropdown {
    /*Selecting value from non-select dropdown
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/dropdown
    3.Click to non-select dropdown
    4.Select Facebook from dropdown
    5.Verify title is “Facebook -Log In or Sign Up
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
       driver= WebDriverFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/dropdown");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void nonSelectDropdown() {
        WebElement nonSelectDropdown =
                driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        nonSelectDropdown.click();
        WebElement facebook = driver.findElement(By.xpath("// a[@class ='dropdown-item'][4]"));
        facebook.click();
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
