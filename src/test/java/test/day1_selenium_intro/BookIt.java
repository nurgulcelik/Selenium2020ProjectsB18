package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookIt {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        utilities.WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://cybertek-reservation-qa.herokuapp.com/sign-in");
        driver.findElement(By.name("email")).sendKeys("bmurkus8q@psu.edu");
        driver.findElement(By.name("password")).sendKeys("alicasanbroke");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
