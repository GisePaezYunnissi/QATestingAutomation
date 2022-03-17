package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    @FindBy(xpath = "//input[@id='name']")
    WebElement name;
    @FindBy(xpath = "//input[@id='country']" )
    WebElement country;
    @FindBy(xpath = "//input[@id='city']")
    WebElement city;
    @FindBy(id = "card")
    WebElement card;
    @FindBy(xpath = "//input[@id='month']")
    WebElement month;
    @FindBy(xpath = "//input[@id='year']")
    WebElement year;
    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement buttonPurchase;
    WebDriver driver;

    public FormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void formName(String nameInput){
        name.sendKeys(nameInput);
    }
    public void formCountry(String countryInput){
        country.sendKeys(countryInput);
    }
    public void formCity(String cityInput){
        city.sendKeys(cityInput);
    }
    public void formCard(String creditCardInput){
        card.sendKeys(creditCardInput);
    }
    public void formMonth(String monthInput){
        month.sendKeys(monthInput);
    }
    public void formYear(String yearInput){
        year.sendKeys(yearInput);
    }

    public void formComplete(String nameInput, String countryInput, String cityInput, String creditCardInput, String monthInput, String yearInput){
        formName(nameInput);
        formCountry(countryInput);
        formCity(cityInput);
        formCard(creditCardInput);
        formMonth(monthInput);
        formYear(yearInput);
    }

    public void clickButtonPurchase(){
        buttonPurchase.click();
    }
}
