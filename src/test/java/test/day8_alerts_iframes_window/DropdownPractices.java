package test.day8_alerts_iframes_window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractices {
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
        String expectedMonth= LocalDateTime.now().getMonth().name();
        Assert.assertEquals(actualMonth.toLowerCase(),expectedMonth.toLowerCase());
        //Assert.assertTrue(actualMonth.equalsIgnoreCase(expectedMonth));
        //PRACTICE #8:
        // Storing all of the options in the month dropdown into the list of web elements
        List<WebElement> actualDropdownOptions = selectMonth.getOptions();

        List<String> expectedDropdownOptions = Arrays.asList("January", "February", "March", "April", "May", "June", "July"
                , "August", "September", "October", "November", "December");
        //We create a list of Strings just as to use as a container to the texts of actual dropdown values
        List<String> actualMonthsText = new ArrayList<>();

        for (WebElement each : actualDropdownOptions) {

            actualMonthsText.add(each.getText());

        }


        Assert.assertEquals(actualMonthsText, expectedDropdownOptions);


    }

}

