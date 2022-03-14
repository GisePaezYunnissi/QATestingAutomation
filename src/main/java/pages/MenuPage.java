package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MenuPage {
    @FindBy(xpath = ("//a[@id='cartur']"))
    WebElement cart;
    @FindBy(xpath = ("//td[text()='790']"))
    WebElement price;

    WebDriver driver;

    public MenuPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickCart(){
        cart.click();
    }

    public void getPrice(int tiempo){
        WebDriverWait wait = new WebDriverWait(driver,tiempo);
        wait.until(ExpectedConditions.visibilityOf(price)).getText();
    }
}
