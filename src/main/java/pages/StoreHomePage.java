package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.PropertiesFile;

public class StoreHomePage extends BasePage {
    @FindBy(linkText = "Laptops")
    WebElement laptopsCategory;

    public StoreHomePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    //Le damos acciones
    public void clickLaptopCategory() {
        clickOnWebElement(laptopsCategory);
    }

    //Maximizo la página y navego
    public void navigateStoreHome() {
        driver.manage().window().maximize();
        driver.navigate().to(PropertiesFile.getProperty("url"));
    }

    public void quit() {
        driver.quit();
    }
}