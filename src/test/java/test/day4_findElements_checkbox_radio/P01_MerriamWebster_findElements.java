package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*#0: FINDELEMENTS1.Open Chrome browser
2.Go to https://www.merriam-webster.com/
3.Print out the texts of all links
4.Print out how many link is missing text
5.Print out how many link has text
6.Print out how many total link

 */
public class P01_MerriamWebster_findElements {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.merriam-webster.com/");
        List<WebElement> listOfLinks= driver.findElements(By.xpath("//body//a"));
        int linksWithoutText=0;
        int linksWithText=0;
        for(WebElement eachLink:listOfLinks){
           // System.out.println(eachLink.getText());
          String textOfEachLink=eachLink.getText();
         if(textOfEachLink.isEmpty()){
             linksWithoutText++;
         }else{
             System.out.println(textOfEachLink);
             linksWithText++;
         }
        }
        System.out.println("The number of links does not have text: "+linksWithoutText);
        System.out.println("The number of links that has text: "+linksWithText);
        System.out.println("Total links on this page: "+listOfLinks.size());
    }
}
