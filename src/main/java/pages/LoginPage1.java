package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage1 extends Base{
    public LoginPage1(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@dir='auto'][contains(.,'Log in')]")
    WebElement loginButton;

    public LoginPage2 clickLoginFromHomePage(WebDriver driver)
    {
        loginButton.click();
        return new LoginPage2(driver);
    }
}
