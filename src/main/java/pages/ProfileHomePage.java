package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileHomePage extends Base {
    @FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
    WebElement tweetBox;
    @FindBy(xpath = "//div[@data-testid=\"tweetButtonInline\"]")
    WebElement tweetButton;
    @FindBy(xpath = "//div[@data-testid='tweetButtonInline']")
    WebElement dimmedButton;

    @FindBy(xpath = "//span[contains(.,'Your Tweet was sent.')]")
    WebElement tweetSentMessage;

    @FindBy(xpath = "//span[contains(.,'Whoops! You already said that.')]")
    WebElement tweetSentAlreadyMessage;

    @FindBy(xpath = "//svg[@viewBox='0 0 24 24']")
    WebElement replyButton;


    public ProfileHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean getTweetSentMessage() {
        return tweetSentMessage.isDisplayed();
    }

    public boolean getTweetSentAlreadyMessage() {
        return tweetSentAlreadyMessage.isDisplayed();
    }

    public void sendTweet(String tweet) {

        tweetBox.sendKeys(tweet);
    }

    public void clickTweetButton() {
        tweetButton.click();
    }

    public String checkTweetButtonDisabled() {
        return dimmedButton.getAttribute("aria-disabled");
    }

    public String checkTweetButtonEnabled() {
        return dimmedButton.getAttribute("data-focusable");
    }

}
