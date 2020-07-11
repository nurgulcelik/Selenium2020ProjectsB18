package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {

    public static void login(WebDriver driver) {
        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUserName.sendKeys("Tester");
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id ='ctl00_MainContent_login_button']"));
        loginButton.click();
    }
    public static void printNamesAndCities(WebDriver driver){
        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));
       // List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[7]"));
        List<WebElement> listOfCities = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[7]"));
        String result = "";
        for(int  i = 0; i < listOfNames.size(); i++){
            result = "Name"+(i+1)+": "+listOfNames.get(i).getText()+" , "+"City"+(i+1)+": "+listOfCities.get(i).getText();
            System.out.println(result);
        }
    }
  /*  public static void verifyingOrder(WebDriver driver, String name){
        List<WebElement> names= driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));
        String givenName= name;
        String actualNames="";
        for(WebElement each: names){
            actualNames +=each.getText();
            }
        Assert.assertTrue(actualNames.contains(givenName));

    /*
@param: WebDriver driver, String name
• Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether
given name is in the list or not.
• Create a new TestNG test to test if the method is working as expected.
*/
    public static void verifyOrder(WebDriver driver, String name){

        //Finding and storing all of the names in our web table in a list of web element
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement each : namesList) {
            if (each.getText().equals(name)){
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.fail("The name does not exist in the list! Verification failed!");

    }
    /*
    Accepts 2 arguments:
            1- Webdriver
    2- String nameToBeDeleted --> This string will be used to create dynamic xpath.

    Basically we copy pasted the logic we created in the first test.
    But we made the xpathForCheckboxes dynamic by concatenating the String argument into the xpath itself.

     */
    public static void deleteName(WebDriver driver, String nameToBeDeleted){

        String xpathForCheckboxes = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[.='"+nameToBeDeleted+"']/../td[1]";

        //String word = "example";
        //String sentence = "This is "+word+"my sentence";
        //We used similar string concat logic in our xpath above. All we do is we dynamically pass the String argument we
        //  get from our method.
        //  This way we manipulate our xpath locator. Which allows us to delete any name from list.

        //We pass our xpath in the web element locator
        WebElement dynamicCheckBox = driver.findElement(By.xpath(xpathForCheckboxes));

        //WebElement locator dynamically finds the given name's checkbox. Then we click to it.
        dynamicCheckBox.click();

        //Locating and clicking the delete button.
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        //Locating all the names from the web table and storing them into a list if web elements
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));


        //Looping through the list of names, and asserting nameToBeDeleted is NOT in the list.
        for(WebElement name : allNames) {
            System.out.println(name.getText());
            Assert.assertFalse(name.getText().equals(nameToBeDeleted));

        }

    }


}

