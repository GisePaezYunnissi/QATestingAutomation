package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitsPage extends BasePage {
    public void Waits() {
        this.driver = getDriver();
    }

    public String waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertmessage = alert.getText();
        alert.accept();
        return alertmessage;
    }
}