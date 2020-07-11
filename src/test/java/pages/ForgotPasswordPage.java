package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ForgotPasswordPage {
    public ForgotPasswordPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="//a[.='Forgot your password?']")
    public WebElement forgotPasswordLink;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement requestButton;
    @FindBy(id="prependedInput")
    public WebElement userNameInput;
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;
}
