import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MenuPage;
import pages.ProductDetailPage;
import pages.ProductPage;
import pages.StoreHomePage;
import utility.DriverFactory;
import utility.PropertiesFile;

import java.util.concurrent.TimeUnit;

public class Prueba2Demoblaze {
        private String url = PropertiesFile.getProperty("url");
        private WebDriver driver = DriverFactory.getDriver();
        StoreHomePage storeHomePage;
        ProductPage productPage;
        ProductDetailPage productDetailPage;
        private final int TIEMPO = 20;
        MenuPage menuPage;

        @Test
        public void addToCart() throws InterruptedException {

            //Instanciar
            storeHomePage  = new StoreHomePage(driver);
            productPage = new ProductPage(driver);
            productDetailPage = new ProductDetailPage(driver);
            menuPage = new MenuPage(driver);

            //Maximizo la página y navego
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.navigate().to(url);

            //Busco link a categoría laptop
            storeHomePage.clickLaptopCategory();

            //Hacer click en el primer producto
            productPage.selectProduct(TIEMPO);

            //Obtengo modelo y precio del producto, imprimo por consola
            String modelo;
            String precio;
            modelo = productDetailPage.getModel();
            precio = productDetailPage.getPrice();
            System.out.println("Modelo:" + modelo + "Precio:" + precio);

            //Agrego al cart
            productDetailPage.ClickAddToCartButton();
            WebDriverWait wait = new WebDriverWait(driver,TIEMPO);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();

            //Hacer click en Cart
            menuPage.ClickCart();
            //Se realiza una espera para poder ver el precio
            menuPage.getPrice(TIEMPO);

            //Cierro el navegador
            driver.quit();
        }
}

