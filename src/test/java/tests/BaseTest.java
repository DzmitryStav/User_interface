package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected final Browser browser = AqualityServices.getBrowser();

    @BeforeTest
    public void setup() {
        browser.maximize();
        browser.waitForPageToLoad();
    }

    @AfterTest
    public void close() {
        browser.quit();
    }
}
