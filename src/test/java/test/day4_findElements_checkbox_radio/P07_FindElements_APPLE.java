package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P07_FindElements_APPLE {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.apple.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement Mac = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']"));
        Mac.click();
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        int linksWithoutText = 0;
        int linksWithText= 0;
        System.out.println("MAC===================================");
            for (WebElement eachLink : listOfLinks) {
                String textOfEachLink = eachLink.getText();
                if (textOfEachLink.isEmpty()) {
                    linksWithoutText++;
                } else {
                    linksWithText++;
                }
            }
        System.out.println("For MAC page,The total number of links does not have text: "+linksWithoutText);
        System.out.println("For MAC page,The total number of links that has text: "+linksWithText);
        System.out.println("For MAC page, Total links on this page: "+listOfLinks.size());
        WebElement iPad = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-ipad']"));
            iPad.click();
        List<WebElement> listOfLinks1 = driver.findElements(By.xpath("//body//a"));
        int linksWithoutText1 = 0;
        int linksWithText1 = 0;
        System.out.println("iPAD=====================================");

        for (WebElement eachLink : listOfLinks1) {

            String textOfEachLink = eachLink.getText();
            if (textOfEachLink.isEmpty()) {
                linksWithoutText1++;
            } else {
                linksWithText1++;
            }
        }
        System.out.println("For iPad page,The total number of links does not have text: "+linksWithoutText1);
        System.out.println("For iPad page,The total number of links that has text: "+linksWithText1);
        System.out.println("For iPad page,Total links on this page: "+listOfLinks1.size());
        WebElement iPhone = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iPhone.click();
        System.out.println("IPHONE====================================");
        List<WebElement> listOfLinks2 = driver.findElements(By.xpath("//body//a"));
        int linksWithoutText2 = 0;
        int linksWithText2 = 0;
        for (WebElement eachLink : listOfLinks2) {

            String textOfEachLink = eachLink.getText();
            if (textOfEachLink.isEmpty()) {
                linksWithoutText2++;
            } else {
                linksWithText2++;
            }
        }
        System.out.println("For iPhone page, The total number of links does not have text: "+linksWithoutText2);
        System.out.println("For iPhone page,The total number of links that has text: "+linksWithText2);
        System.out.println("For iPhone page,Total links on this page: "+listOfLinks2.size());
        WebElement Watch = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-watch']"));
        Watch.click();
        List<WebElement> listOfLinks3 = driver.findElements(By.xpath("//body//a"));
        int linksWithoutText3 = 0;
        int linksWithText3 = 0;
        System.out.println("WATCH=====================================");
        for (WebElement eachLink : listOfLinks3) {

            String textOfEachLink = eachLink.getText();
            if (textOfEachLink.isEmpty()) {
                linksWithoutText3++;
            } else {
                linksWithText3++;
            }
        }
        System.out.println("For Watch page,The total number of links does not have text: "+linksWithoutText3);
        System.out.println("For Watch page,The total number of links that has text: "+linksWithText3);
        System.out.println("For Watch page,Total links on this page: "+listOfLinks3.size());
        WebElement TV = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-tv']"));
        TV.click();
        List<WebElement> listOfLinks4 = driver.findElements(By.xpath("//body//a"));
        int linksWithoutText4 = 0;
        int linksWithText4 = 0;
        System.out.println("TV======================================");
        for (WebElement eachLink : listOfLinks4) {

            String textOfEachLink = eachLink.getText();
            if (textOfEachLink.isEmpty()) {
                linksWithoutText4++;
            } else {
                linksWithText4++;
            }
        }
        System.out.println("For TV page,The total number of links does not have text: "+linksWithoutText4);
        System.out.println("For TV page,The total number of links that has text: "+linksWithText4);
        System.out.println("For TV page,Total links on this page: "+listOfLinks4.size());
        WebElement Music = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-music']"));
        Music.click();
        List<WebElement> listOfLinks5 = driver.findElements(By.xpath("//body//a"));
        int linksWithoutText5 = 0;
        int linksWithText5 = 0;
        System.out.println("MUSIC===================================");
        for (WebElement eachLink : listOfLinks5) {

            String textOfEachLink = eachLink.getText();
            if (textOfEachLink.isEmpty()) {
                linksWithoutText5++;
            } else {
                linksWithText5++;
            }
        }
        System.out.println("For Music page,The total number of links does not have text: "+linksWithoutText5);
        System.out.println("For Music page,The total number of links that has text: "+linksWithText5);
        System.out.println("For Music page,Total links on this page: "+listOfLinks5.size());
        WebElement Support = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-support']"));
        Support.click();
        List<WebElement> listOfLinks6 = driver.findElements(By.xpath("//body//a"));
        int linksWithoutText6 = 0;
        int linksWithText6 = 0;
        System.out.println("SUPPORT================================");
        for (WebElement eachLink : listOfLinks6) {

            String textOfEachLink = eachLink.getText();
            if (textOfEachLink.isEmpty()) {
                linksWithoutText6++;
            } else {
                linksWithText6++;
            }
        }
        System.out.println("For Support page,The total number of links does not have text: "+linksWithoutText6);
        System.out.println("For Support page,The total number of links that has text: "+linksWithText6);
        System.out.println("For Support page,Total links on this page: "+listOfLinks6.size());
        int totalLinksWithoutText=linksWithoutText+linksWithoutText1+linksWithoutText2
                +linksWithoutText3+linksWithoutText4+linksWithoutText5+linksWithoutText6;
        int totalLinksWithText= linksWithText+linksWithText1+linksWithText2
                +linksWithText3+linksWithText4+linksWithText5+linksWithText6;
        int totalLink=listOfLinks.size()+listOfLinks1.size()+listOfLinks2.size()
                +listOfLinks3.size()+listOfLinks4.size()+listOfLinks5.size()+listOfLinks6.size();
        System.out.println("The total number of links does not have text: "+totalLinksWithoutText);
        System.out.println("The total number of links that has text: "+totalLinksWithText);
        System.out.println("Total links on this page: "+totalLink);
        }
    }
