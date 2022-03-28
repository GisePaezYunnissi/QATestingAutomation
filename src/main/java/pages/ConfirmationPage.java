package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BasePage {
    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    WebElement messageConfirm;
    @FindBy(xpath = "//p[@class='lead text-muted ']")
    WebElement validateData;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement buttonOk;

    public ConfirmationPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getMessage() {
        return getTextFromWebElement(messageConfirm);
    }

    public String getValidate() {
        return getTextFromWebElement(validateData);
    }

    public void clickButtonOk() {
        clickOnWebElement(buttonOk);
    }
}