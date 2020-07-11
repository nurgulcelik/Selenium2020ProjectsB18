package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P06_SeleniumEasyCheckbox2 {
    /*
     * TC #3: SeleniumEasy Checkbox Verification – Section 2
     * 1. Open Chrome browser
     * 2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
     * 3. Verify "Check All" button text is "Check All"
     * 4. Click to "Check All" button
     * 5. Verify all check boxes are checked
     * 6. Verify button text changed to "Uncheck All"
     */

    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        String textCheckAllButton= driver.findElement(By.xpath("// input [@id='check1']")).getAttribute("value");
        String actualText="Check All";
        if(textCheckAllButton.equals(actualText)){
            System.out.println("Check all button text verifying is PASSED! ");
        }else{
            System.out.println("Check all button text verifying is FAILED!");
        }
        driver.findElement(By.xpath("// input [@id='check1']")).click();

        List<WebElement> checkBoxes =driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for (WebElement each:checkBoxes) {
        if (each.isSelected()) {
            System.out.println("Checkbox is checked, Passed!");
        } else {
            System.out.println("Checkbox is not checked,Failed!");
        }
    }
    String uncheckAllText =driver.findElement(By.xpath("//input[@value='Uncheck All']")).getAttribute("value");
        String actualResult="Uncheck All";
        if(uncheckAllText.equals(actualResult)){
        System.out.println("Unchecked All button text is verified, Passed!");
    }else{
        System.out.println("Unchecked All button text is not verified, Failed!");
    }
}
        }





