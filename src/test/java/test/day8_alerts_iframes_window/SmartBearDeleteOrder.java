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

public class SmartBearDeleteOrder {
    /*
    TC #9: SmartBear delete order
    1.Open browser and login to SmartBear
    2.Delete “Mark Smith” from the list
    3.Assert it is deleted from the list
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
    public void SmartBearDeleteOrder() {

        WebElement theCheckbox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
        theCheckbox.click();
        WebElement deleteSelectedButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']"));
        deleteSelectedButton.click();
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        for (WebElement eachName : names) {
            Assert.assertFalse(eachName.getText().contains("Mark Smith"));
        }
    }@AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();

    }
}


