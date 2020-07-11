package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_Cybertek_AddRemoveElements {
    /*
     PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements/
3. Click to "Add Element" button 50 times
4. Verify 50 "Delete" button is displayed after clicking.
5. Click to ALL "Delete" buttons to delete them.
6. Verify "Delete" button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
Hint: Need to use findElements method.
     */
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        WebElement addElementButton= driver.findElement(By.xpath("//button [@ onclick='addElement()']"));

        for( int i=0; i<50 ; i++){
            addElementButton.click();
        }
        List<WebElement> listOfDeleteButtons= driver.findElements(By.xpath("//button [@ class ='added-manually']"));

        int actualNumberForDisplaying =listOfDeleteButtons.size();
        int expectedNumberForDisplaying=50;
        if(actualNumberForDisplaying==expectedNumberForDisplaying){
            System.out.println("Displaying delete buttons verification is PASSED!");
        }else{
            System.out.println("Displaying delete buttons verification is FAILED!");
        }
        for (WebElement eachButton :listOfDeleteButtons) {
            eachButton.click();
        }

        String actualResult = driver.findElement(By.xpath("//div[@class='container']")).getText();

        String expectedNotDisplayed="Delete";
        if(!(actualResult.equals(expectedNotDisplayed))){
            System.out.println("Delete button is NOT displayed, PASSED!");
        }else{
            System.out.println("Delete button is displayed, FAILED!");
        }

    }
}
