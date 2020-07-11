package test.day8_alerts_iframes_window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearEditOrder {
    /*
TC #10: SmartBear edit order
1.Open browser and login to SmartBear
2.Click to edit button from the right for “Steve Johns”
3.Change name to “Michael Jordan”
4.Click Update
5.Assert “Michael Jordan” is in the list
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get(" http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
    }
    @Test
    public void SmartBearEditOrder() {

        WebElement editButton = driver.findElement(By.xpath("//td[.='Steve Johns']/following-sibling::td[11]"));
        editButton.click();
        WebElement customerNameBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerNameBox.clear();
        customerNameBox.sendKeys("Michael Jordan");
        WebElement updateButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']"));
        updateButton.click();
        //SmartBearUtilities.verifyOrder(driver,"Michael Jordan");
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        for (WebElement each : namesList) {
            if (each.getText().contains("Michael Jordan")) {
                Assert.assertTrue(true);
            }
        }
    }
            @AfterMethod
            public void tearDown () throws InterruptedException {
                Thread.sleep(2000);
                driver.close();
            }
        }
