package test.day6_testNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Dropdowns_Intro {
    /*
     Verifying “Simple dropdown” and “State selection” dropdown default values
     1.Open Chrome browser2.Go to http://practice.cybertekschool.com/dropdown
     3.Verify “Simple dropdown” default selected value is correctExpected: “Please select an option”
     4.Verify“State selection” default selected value is correctExpected: “Select a State
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //GOAL is to open new browser for each test.
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
    }@Test
    public void test1_default_value_verification(){

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        String actualDefaultOfSimpleDropdown = simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfSimpleDropdown = "Please select an option";

        Assert.assertEquals(actualDefaultOfSimpleDropdown, expectedDefaultOfSimpleDropdown);

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualDefaultOfStateDropdown = stateDropdown.getFirstSelectedOption().getText();
        String expectDefaultOfStateDropdown = "Select a State";

        Assert.assertEquals(actualDefaultOfStateDropdown, expectDefaultOfStateDropdown);

    }
    @Test
     public void test2_default_value_verification() throws InterruptedException{
 Select stateDropdown= new Select(driver.findElement(By.xpath("//select[@id='state']")));
 Thread.sleep(1000);
 stateDropdown.selectByValue("IL");
        Thread.sleep(1000);
 stateDropdown.selectByVisibleText("Virginia");
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
        String expectedOption="California";
        String actualSelectedOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedOption,expectedOption);
        Assert.assertTrue(actualSelectedOption.equals(expectedOption));

    }

}
