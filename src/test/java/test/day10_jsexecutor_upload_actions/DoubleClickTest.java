package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
/*
TC	#16:	Double	ClickTest
1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
2.Switch	to	iframe.
3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
4.Assert:	Text’s	“style”	attribute	value	contains red
 */
public class DoubleClickTest {
    @Test
    public void doubleClickTest(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().switchTo().frame(0);
        WebElement theText= Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));
        Actions actions= new Actions(Driver.getDriver());
        actions.moveToElement(theText).doubleClick().perform();
        WebElement styleElement= Driver.getDriver().findElement(By.xpath("//p[@style='color: red;']"));
        Assert.assertTrue(styleElement.getAttribute("style").contains("red"));

    }
}
