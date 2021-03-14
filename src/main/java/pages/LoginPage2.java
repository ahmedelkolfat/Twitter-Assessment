package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage2 extends Base {
    public LoginPage2(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[contains(@type,'text')]")
    WebElement userId;
    @FindBy(xpath = "//input[contains(@type,'password')]")
    WebElement passWord;
    @FindBy(xpath = "(//div[@dir='auto'][contains(.,'Log in')])[1]")
    WebElement clickLoginButton;

    public void fillUserLoginData (String userID, String password)
    {
        userId.sendKeys(userID);
        passWord.sendKeys(password);
    }

    public ProfileHomePage clickLogin (WebDriver driver)
    {
        clickLoginButton.click();
        return new ProfileHomePage(driver);
    }
}
