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

public class T3_SelectingDateOnDropdown {
            //Selecting date on dropdown and verifying
            // 1.Open Chrome browser
            // 2.Go to http://practice.cybertekschool.com/dropdown
            // 3.Select “December 1st, 1921” and verify it is selected.
            // Select year using: visible textSelect
            // month using : value attributeSelect
            // day using: index number

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
            public void selectingDateOnDropdown() throws InterruptedException{
                Select selectYear= new Select(driver.findElement(By.xpath("//select[@id='year']")));
                selectYear.selectByVisibleText("1921");
                String actualYear=selectYear.getFirstSelectedOption().getText();
                String expectedYear="1921";
                Assert.assertEquals(actualYear,expectedYear);
                Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
                selectMonth.selectByValue("11");
                String actualMonth= selectMonth.getFirstSelectedOption().getText();
                String expectedMonth="December";
                Assert.assertEquals(actualMonth,expectedMonth);
                Select selectDay= new Select(driver.findElement(By.xpath("//select[@id='day']")));
                selectDay.selectByIndex(0);
                String actualDay=selectDay.getFirstSelectedOption().getText();
                String expectedDay="1";
                Assert.assertEquals(actualDay,expectedDay);

    }
}
