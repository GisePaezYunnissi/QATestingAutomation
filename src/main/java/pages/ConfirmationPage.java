package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    WebElement messageConfirm;
    WebDriver driver;

    public ConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMessage() {
        return messageConfirm.getText();
    };



}

