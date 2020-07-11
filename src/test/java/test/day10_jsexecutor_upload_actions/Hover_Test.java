package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Hover_Test {
    /*
    1.Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
    2.Drag	and	drop	the	small	circle	to	bigger	circle.
    3.Assert:	-Text	in	big	circle	changed to:	“You	did	great!"
     */
    @Test
    public void hover_Test(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement dragggable= Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement droptarget= Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        Actions actions= new Actions(Driver.getDriver());
        actions.dragAndDrop(dragggable,droptarget).perform();
        Assert.assertEquals(droptarget.getText(),"You did great!");
    }
}
