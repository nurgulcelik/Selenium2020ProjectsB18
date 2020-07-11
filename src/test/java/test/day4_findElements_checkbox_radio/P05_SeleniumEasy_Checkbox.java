package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P05_SeleniumEasy_Checkbox {
    /*
    TC #2: SeleniumEasy Checkbox Verification – Section 1
1. Open Chrome browser
2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify "Success – Check box is checked" message is NOT displayed.
4. Click to checkbox under "Single Checkbox Demo" section
5. Verify "Success – Check box is checked" message is displayed.
     */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement successMessage= driver.findElement(By.xpath("//div[@id='txtAge']"));
        WebElement successCheckbox= driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        if(!successCheckbox.isSelected() && !successMessage.isDisplayed()){
            System.out.println("Default value verification is PASSED!");
        }else{
            System.out.println(" Default value verification is FAILED!");
        }
        successCheckbox.click();
        if(successMessage.isDisplayed()){
            System.out.println("Success message is displayed, PASSED!");
        }else{
            System.out.println("Checkbox message is not displayed, FAILED!");
        }



    }
}