package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class ContextClick {
    /*
    	1.Go	to	https://the-internet.herokuapp.com/context_menu
    	2.Right	click	to	the	box.
    	3.Alert	will	open.
    	4.Accept	alertNo	assertion	needed	for	this	practice

     */
    @Test
    public void context_Click(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(Driver.getDriver());
        WebElement theBox= Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));
        actions.moveToElement(theBox).contextClick().perform();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
}
