package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends BasePage {
    @FindBy(xpath = "//input[@id='name']")
    WebElement inputName;
    @FindBy(xpath = "//input[@id='country']")
    WebElement inputCountry;
    @FindBy(xpath = "//input[@id='city']")
    WebElement inputCity;
    @FindBy(id = "card")
    WebElement inputCard;
    @FindBy(xpath = "//input[@id='month']")
    WebElement inputMonth;
    @FindBy(xpath = "//input[@id='year']")
    WebElement inputYear;
    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement buttonPurchase;
    @FindBy(xpath = "//button[text()='Close']")
    WebElement buttonClose;

    public FormPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void formName(String name) {
        sendKeysToWebElement(inputName, name);
    }

    public void formCountry(String country) {
        sendKeysToWebElement(inputCountry, country);
    }

    public void formCity(String city) {
        sendKeysToWebElement(inputCity, city);
    }

    public void formCard(String card) {
        sendKeysToWebElement(inputCard, card);
    }

    public void formMonth(String month) {
        sendKeysToWebElement(inputMonth, month);
    }

    public void formYear(String year) {
        sendKeysToWebElement(inputYear, year);
    }

    public void clickButtonPurchase() {
        clickOnWebElement(buttonPurchase);
    }

    public void clickButtonClose() {
        clickOnWebElement(buttonClose);
    }

    public void formComplete(String name, String country, String city, String card, String month, String year) {
        formName(name);
        formCountry(country);
        formCity(city);
        formCard(card);
        formMonth(month);
        formYear(year);
    }
}