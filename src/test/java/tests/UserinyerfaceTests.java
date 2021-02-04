package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.ISettingsFile;
import constants.AssertMessages;
import constants.TestData;
import forms.MainForm;
import forms.StartForm;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.StringUtils;

import static org.testng.Assert.*;

public class UserinyerfaceTests extends BaseTest {

    private final Browser browser = AqualityServices.getBrowser();
    private final StartForm startForm = new StartForm();
    private final MainForm mainForm = new MainForm();
    private final String url = AqualityServices.get(ISettingsFile.class).getValue("/url").toString();

    @BeforeMethod
    protected void goToPage() {
        browser.goTo(url);
        browser.waitForPageToLoad();
        assertTrue(startForm.atPage(), AssertMessages.START_PAGE_ERROR);
        startForm.clickHere();
        browser.waitForPageToLoad();
        assertTrue(mainForm.isMainPage(), AssertMessages.MAIN_PAGE_ERROR);
    }

    @Test
    public void testCase1() {
        mainForm.getLoginForm().setPassword(StringUtils.getRandomString());
        String firstLetter = String.valueOf(mainForm.getLoginForm().getPassword().charAt(0));
        mainForm.getLoginForm().setEmail(firstLetter + StringUtils.getRandomString());
        mainForm.getLoginForm().setDomain(StringUtils.getRandomString());
        mainForm.getLoginForm().selectRandomTld();
        mainForm.getLoginForm().acceptTermsAndConditions();
        mainForm.getLoginForm().clickNext();
        assertEquals(mainForm.getCurrentPageNumber(), 2, AssertMessages.PROFILE_PAGE_ERROR);
        mainForm.getProfileForm().checkThreeInterests();
        mainForm.getProfileForm().uploadImage();
        mainForm.getProfileForm().clickNext();
        assertEquals(mainForm.getCurrentPageNumber(), 3, AssertMessages.THIRD_PAGE_ERROR);
    }

    @Test
    public void testCase2() {
        mainForm.getHelpForm().hide();
        assertTrue(mainForm.getHelpForm().isHidden(), AssertMessages.HELP_FORM_ERROR);
    }

    @Test
    public void testCase3() {
        mainForm.getCookiesForm().acceptCookies();
        assertFalse(mainForm.getCookiesForm().state().isExist(), AssertMessages.COOKIES_FORM_ERROR);
    }

    @Test
    public void testCase4() {
        String timerValue = mainForm.getTimerValue();
        assertEquals(timerValue, TestData.TIMER_ZERO, AssertMessages.TIMER_ERROR);
    }
}
