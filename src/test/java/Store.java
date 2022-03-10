import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.DriverFactory;
import utility.PropertiesFile;

import java.util.concurrent.TimeUnit;

public class Store {
        private String url = PropertiesFile.getProperty("url");
        private WebDriver driver = DriverFactory.getDriver();

        @Test
        public void addProduct() throws InterruptedException {
            String modelo;
            String precio;

            //Maximizo la página y navego
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.navigate().to(url);

            //Busco link a categoría laptop
            driver.findElement(By.linkText("Laptops")).click();
            //Thread.sleep(2000);

            //Hacer click en el primer producto
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.card-img-top"))).click();
            //driver.findElement(By.cssSelector("img.card-img-top")).click();
            //Thread.sleep(2000);

            //Obtengo modelo y precio del producto, imprimo por consola

            //WebDriverWait wait = new WebDriverWait(driver, 5);
            //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("h2.name"))));
            modelo = driver.findElement(By.cssSelector("h2.name")).getText();
            precio = driver.findElement(By.cssSelector("h3.price-container")).getText();
            System.out.println("Modelo: " + modelo + "Precio: " + precio);

            //Agrego el producto al cart
            driver.findElement(By.linkText("Add to cart")).click();
            //Thread.sleep(2000);

            //WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            driver.quit();
        }
}