package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    /*
    We will store all login page related web elements and methods into this class
     */
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    //locating input username
    @FindBy(id="prependedInput")
    public WebElement userNameInput;
    //locating input password
    @FindBy(id="prependedInput2")
    public WebElement passwordInput;
    //locating login button
    @FindBy(id="_submit")
    public WebElement loginButton;
    //locating the error message
    @FindBy(xpath="//div[@class='alert alert-error']")
    public WebElement errorMessage;
    //@FindBy(linkTest="Forgot your password?")
    //manageInterestCollectionLinkOnButton
    @FindBy(xpath="//a[.='Forgot your password?']")
    public WebElement forgotPasswordLink;


    public void login(String username, String password){
      userNameInput.sendKeys(username);
      passwordInput.sendKeys(password);
      loginButton.click();

    }

}
