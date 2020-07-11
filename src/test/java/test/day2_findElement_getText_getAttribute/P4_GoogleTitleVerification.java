package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleTitleVerification {
    /*
    TC#4:	Google	search1-Open	a	chrome	browser
    2-Go	to:	https://google.com
    3-Write	“apple”	in	search	box
    4-Click	google	search	button
    5-Verify	title:Expected:	Title	should	start	with	“apple"
     */
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //driver.findElement(By.name("btnK")).click();
       driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);
        String expectedTitle="apple";
        String actualTitle=driver.getTitle();
        if(actualTitle.startsWith(expectedTitle)){
            System.out.println("Google search title verification PASSED!");
        } else{
            System.out.println("Google search title verification FAILED!");
        }
    }
}
