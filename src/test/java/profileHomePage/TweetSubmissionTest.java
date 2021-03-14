package profileHomePage;

import Base.BaseTest;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage2;
import pages.ProfileHomePage;


public class TweetSubmissionTest extends BaseTest {
    Faker faker = new Faker();

    @Test
    public void sendTweet1Character() {
        LoginPage1.clickLoginFromHomePage(driver);
        LoginPage2 loginPage2 = new LoginPage2(driver);
        loginPage2.fillUserLoginData("GavenRonaldo", "ahmed123456");
        loginPage2.clickLogin(driver);
        ProfileHomePage profileHomePage = new ProfileHomePage(driver);
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is not dimmed ");
        String tweet = faker.regexify("[a-z1-9]{1}");
        profileHomePage.sendTweet(tweet);
        Assert.assertEquals(profileHomePage.checkTweetButtonEnabled(), "true", "Button is dimmed");
        profileHomePage.clickTweetButton();
        Assert.assertTrue(profileHomePage.getTweetSentMessage(), "Tweet was not sent");
        logger.log(Status.INFO, "sendTweet1Character");
        logger.log(Status.PASS, "Send a tweet of 1 character succeeded");

    }

    @Test
    public void sendTweet279Characters() {
        LoginPage1.clickLoginFromHomePage(driver);
        LoginPage2 loginPage2 = new LoginPage2(driver);
        loginPage2.fillUserLoginData("GavenRonaldo", "ahmed123456");
        loginPage2.clickLogin(driver);
        ProfileHomePage profileHomePage = new ProfileHomePage(driver);
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is not dimmed ");
        String tweet = faker.regexify("[a-z1-9]{279}");
        profileHomePage.sendTweet(tweet);
        Assert.assertEquals(profileHomePage.checkTweetButtonEnabled(), "true", "Button is dimmed");
        profileHomePage.clickTweetButton();
        Assert.assertTrue(profileHomePage.getTweetSentMessage(), "Tweet was not sent");
        logger.log(Status.INFO, "sendTweet279Characters");
        logger.log(Status.PASS, "Send a tweet of 279 characters succeeded");

    }

    @Test
    public void sendTweet280Characters() {
        LoginPage1.clickLoginFromHomePage(driver);
        LoginPage2 loginPage2 = new LoginPage2(driver);
        loginPage2.fillUserLoginData("GavenRonaldo", "ahmed123456");
        loginPage2.clickLogin(driver);
        ProfileHomePage profileHomePage = new ProfileHomePage(driver);
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is not dimmed ");
        String tweet = faker.regexify("[a-z1-9]{280}");
        profileHomePage.sendTweet(tweet);
        Assert.assertEquals(profileHomePage.checkTweetButtonEnabled(), "true", "Button is dimmed");
        profileHomePage.clickTweetButton();
        Assert.assertTrue(profileHomePage.getTweetSentMessage(), "Tweet was not sent");

        logger.log(Status.INFO, "sendTweet280Characters");
        logger.log(Status.PASS, "Send a tweet of 280 characters succeeded");

    }

    @Test
    public void sendBlankTweet() {
        LoginPage1.clickLoginFromHomePage(driver);
        LoginPage2 loginPage2 = new LoginPage2(driver);
        loginPage2.fillUserLoginData("GavenRonaldo", "ahmed123456");
        loginPage2.clickLogin(driver);
        ProfileHomePage profileHomePage = new ProfileHomePage(driver);
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is not dimmed ");
        profileHomePage.sendTweet("");
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is not dimmed ");
        profileHomePage.clickTweetButton();
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is not dimmed ");

        logger.log(Status.INFO, "sendBlankTweet");
        logger.log(Status.PASS, "Failed to send a blank tweet");

    }

    @Test
    public void sendTweetWithSpaces() {
        LoginPage1.clickLoginFromHomePage(driver);
        LoginPage2 loginPage2 = new LoginPage2(driver);
        loginPage2.fillUserLoginData("GavenRonaldo", "ahmed123456");
        loginPage2.clickLogin(driver);
        ProfileHomePage profileHomePage = new ProfileHomePage(driver);
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is not dimmed ");
        profileHomePage.sendTweet("             ");
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is not dimmed ");
        profileHomePage.clickTweetButton();
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is not dimmed ");

        logger.log(Status.INFO, "sendTweetWithSpaces");
        logger.log(Status.PASS, "Failed to send a tweet with spaces only");

    }

    @Test
    public void sendTweetMoreThan280Characters() {
        LoginPage1.clickLoginFromHomePage(driver);
        LoginPage2 loginPage2 = new LoginPage2(driver);
        loginPage2.fillUserLoginData("GavenRonaldo", "ahmed123456");
        loginPage2.clickLogin(driver);
        ProfileHomePage profileHomePage = new ProfileHomePage(driver);
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is not dimmed ");
        String tweet = faker.regexify("[a-z1-9]{281}");
        profileHomePage.sendTweet(tweet);
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is dimmed");
        profileHomePage.clickTweetButton();
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is not dimmed ");

        logger.log(Status.INFO, "sendTweetMoreThan280Characters");
        logger.log(Status.PASS, "Failed to send a tweet with more than 280 characters");

    }

    @Test
    public void sendSameTweetTwiceInRow() {
        LoginPage1.clickLoginFromHomePage(driver);
        LoginPage2 loginPage2 = new LoginPage2(driver);
        loginPage2.fillUserLoginData("GavenRonaldo", "ahmed123456");
        loginPage2.clickLogin(driver);
        ProfileHomePage profileHomePage = new ProfileHomePage(driver);
        Assert.assertEquals(profileHomePage.checkTweetButtonDisabled(), "true", "Button is not dimmed ");
        String tweet = faker.regexify("[a-z1-9]{4}");
        profileHomePage.sendTweet(tweet);
        Assert.assertEquals(profileHomePage.checkTweetButtonEnabled(), "true", "Button is dimmed");
        profileHomePage.clickTweetButton();
        Assert.assertTrue(profileHomePage.getTweetSentMessage(), "Tweet was not sent");
        profileHomePage.sendTweet(tweet);
        Assert.assertEquals(profileHomePage.checkTweetButtonEnabled(), "true", "Button is dimmed");
        profileHomePage.clickTweetButton();
        Assert.assertTrue(profileHomePage.getTweetSentAlreadyMessage(), "Tweet sent twice");

        logger.log(Status.INFO, "sendSameTweetTwiceInRow");
        logger.log(Status.PASS, "Failed to send a tweet twice in a row");

    }
}
