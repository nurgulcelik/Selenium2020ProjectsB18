package test.day6_testNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class T4_MultipleSelectDropdown {
    /*Selecting value from multiple select dropdown
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/dropdown
    3.Select all the options from multiple select dropdown.
    4.Print out all selected values.
    5.Deselect all values
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
        Thread.sleep(1000);
        driver.close();
    }
    @Test
    public void multipleSelectDropdown(){
        Select selectOption= new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        for(int i=0;i<6;i++){
            selectOption.selectByIndex(i);
        }
        for(WebElement each:selectOption.getAllSelectedOptions()){
            System.out.println(each.getText());
        }
        selectOption.deselectAll();
    }
}
