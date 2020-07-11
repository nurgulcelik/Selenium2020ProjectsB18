package test.day11_page_object_model;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class ActionPractices  {
    Actions actions;
    @Test
    public void scrolling_with_actions() throws InterruptedException{
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        Actions actions = new Actions(Driver.getDriver());
        WebElement cybertekSchoolLink= Driver.getDriver().findElement(By.linkText("Cybertek School"));
        Thread.sleep(2000);
        WebElement element= Driver.getDriver().findElement(By.linkText("WYSIWYG Editor"));
       actions.moveToElement(cybertekSchoolLink).perform();
        Thread.sleep(2000);
        actions.moveToElement(element).click().perform();
    }
    @Test
    public void double_click_test(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
       Driver.getDriver().switchTo().frame("iframeResult");
       WebElement textToDoubleClick= Driver.getDriver().findElement(By.id("demo"));
       actions= new Actions(Driver.getDriver());
       actions.moveToElement(textToDoubleClick).doubleClick().perform();
       String actual= textToDoubleClick.getAttribute("style");
        System.out.println(actual);
        String expected= "color: red;";
       // Assert.assertTrue(actual.equals(expected));
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void drag_and_drop_test(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index ");
        WebElement source= Driver.getDriver().findElement(By.id("draggable"));
        WebElement target= Driver.getDriver().findElement(By.id("droptarget"));
        actions = new Actions(Driver.getDriver());
       // actions.clickAndHold(source).moveToElement(target).release().perform();
        actions.dragAndDrop(source,target).perform();
        String actual= target.getText();
        String expected= "You did great!";
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void context_click_test(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        WebElement theBox= Driver.getDriver().findElement(By.id("hot-spot"));
        actions= new Actions(Driver.getDriver());
        actions.moveToElement(theBox).contextClick().perform();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
}
