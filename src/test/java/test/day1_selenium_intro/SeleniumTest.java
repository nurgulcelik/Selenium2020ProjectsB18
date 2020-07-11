package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("driver.getTitle()-->"+driver.getTitle());
        System.out.println("driver.getCurrentUrl()-->"+driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.navigate().to("https://facebook.com");
        System.out.println("driver.getTitle()-->"+driver.getTitle());
        System.out.println("driver.getCurrentUrl()-->"+driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());
    }
}
