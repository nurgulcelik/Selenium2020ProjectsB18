package test.day7_javaFaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Cybertek_Month_Dropdown_DefaultValue {
    /*
    1.Open browser
    2.Go to website: http://practice.cybertekschool.com/dropdowns
    3.Verify default value is always showing the current monthExpected:
     If currently in June, should show June selected
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
    public void Default_ValueOfMonth(){
        Select selectMonth= new Select (driver.findElement(By.xpath("//select[@id='month']")));
       String actualMonth= selectMonth.getFirstSelectedOption().getText();
       String expectedMonth="June";
        Assert.assertEquals(actualMonth,expectedMonth);
    }
}
