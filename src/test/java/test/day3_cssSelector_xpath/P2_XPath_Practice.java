package test.day3_cssSelector_xpath;
/*
 * XPATH PRACTICES DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
 * TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
 * 1. Open Chrome browser2. Go to http://practice.cybertekschool.com/add_remove_elements/
 * 3. Click to "Add Element" button
 * 4. Verify "Delete" button is displayed after clicking.
 * 5. Click to "Delete" button.
 * 6. Verify "Delete" button is NOT displayed after clicking.
 * USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class P2_XPath_Practice {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        WebElement deleteButton= driver.findElement(By.xpath("//button[@class='added-manually']"));
        if(deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed on the page, PASSED!");
        }else{
            System.out.println("Delete button is displayed on the page, FAILED!");
        }
         deleteButton.click();
        WebElement deleteButtonNotDisplayed=driver.findElement(By.xpath("//div[@id='elements']"));
        if(deleteButtonNotDisplayed.isDisplayed()){
            System.out.println("Delete button is NOT displayed on the page, PASSED!");
        }else{
            System.out.println("Delete button is NOT displayed on the page, FAILED!");
        }
    }
}
