package test.day7_javaFaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Cybertek_Month_DropdownList {
     /*
        TC#8: Cybertek “month” dropdown list of default values verification.
        1.Do both verifications in the same test.
        2.Verify list of months are correct as expected.
        Expected: Options should contain all 12 months of the year
         */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        // close browser
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void Month_Dropdown_ListOfValues(){

        List<String> expectedMonths= new ArrayList<String>();
        expectedMonths.addAll(Arrays.asList("January","February","March","April","May","June","July",
                "August","September","October","November","December"));
        List<String> actualMonths= new ArrayList<String>();
        List<WebElement> months = driver.findElements(By.xpath("//select[@id='month']/option"));
        for(WebElement eachMonths:months){
            actualMonths.add(eachMonths.getText());
        }
        Assert.assertEquals(actualMonths,expectedMonths);
    }
}
