package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P04_Cybertek_Checkboxes {
    /*
//Practice: Cybertek   Checkboxes
// 1.Go    to http://practice.cybertekschool.com/checkboxes
// 2.Confirm   checkbox   #1 is NOT    selected   by default
// 3.Confirm   checkbox   #2 is SELECTED   by default.
// 4.Click checkbox   #1 to select it.
// 5.Click checkbox   #2 to deselect   it.
// 6.Confirm   checkbox   #1 is SELECTED.
// 7.Confirm   checkbox   #2 is NOT */
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        if(!checkbox1.isSelected()){
            System.out.println("Checkbox 1 is not selected, PASSED!");
        }else{
            System.out.println("Checkbox 1 is selected, FAILED!");
        }

        if(checkbox2.isSelected()){
            System.out.println("Checkbox 2 is not selected, PASSED!");
        }else{
            System.out.println("Checkbox 2 is selected, FAILED!");
        }
    }
}