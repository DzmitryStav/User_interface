package tests;


import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import messages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.*;

public class TestCase extends BaseTest  {
    MainPage page = new MainPage();

    @Test
    public void test() {
        String url = AqualityServices.get(ISettingsFile.class).getValue("/url").toString();
        browser.goTo(URLMaker.getAuthorizationUrl(url, TestDataProvider.getValue("login"), TestDataProvider.getValue("password")));
        Assert.assertEquals(page.getTextFromPage(), ExpectedResults.AUTHORIZATION_RESULTS, AssertMessages.AUTHORIZATION_RESULT_ERROR);
    }
}
