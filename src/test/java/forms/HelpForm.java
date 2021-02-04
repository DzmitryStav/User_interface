package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private final String HIDE_HELP_FORM_BUTTON = "//button[contains(@class,'help-form__send-to-bottom-button')]";
    private final String HELP_TITLE = "//*[@class='help-form__title']";

    private final IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final IButton btnSendToBottom = elementFactory.getButton(By.xpath(HIDE_HELP_FORM_BUTTON), "Hide help button");
    private final ILabel lblTitle = elementFactory.getLabel(By.xpath(HELP_TITLE), "Title");

    public HelpForm() {
        super(By.className("help-form__container"), "Help");
    }

    public void hide() {
        btnSendToBottom.click();
        lblTitle.state().waitForNotDisplayed();
    }

    public boolean isHidden() {
        return !lblTitle.state().isDisplayed();
    }
}
