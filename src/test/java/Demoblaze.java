import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utility.DriverFactory;
import utility.PropertiesFile;

import java.util.concurrent.TimeUnit;

public class Demoblaze {
        private String url = PropertiesFile.getProperty("url");
        private WebDriver driver = DriverFactory.getDriver();
        private final int TIEMPO = 10;
        StoreHomePage storeHomePage;
        ProductPage productPage;
        ProductDetailPage productDetailPage;
        MenuPage menuPage;
        CartPage cartPage;
        FormPage formPage;
        ConfirmationPage confirmationPage;

        @Test
        public void addToCart() throws InterruptedException {

            //Instanciar
            storeHomePage  = new StoreHomePage(driver);
            productPage = new ProductPage(driver);
            productDetailPage = new ProductDetailPage(driver);
            menuPage = new MenuPage(driver);
            cartPage = new CartPage(driver);
            formPage = new FormPage(driver);
            confirmationPage = new ConfirmationPage(driver);

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
            productDetailPage.clickAddToCartButton();
            WebDriverWait wait = new WebDriverWait(driver,TIEMPO);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();

            //Hacer click en Cart
            menuPage.clickCart();

            //Declaro las variable
            String modelCart;
            String priceCart;
            modelCart = cartPage.getModelCart();
            priceCart = cartPage.getPriceCart();
            System.out.println("Modelo:" + modelCart + "Precio:" + priceCart);
            //Valido que el titulo de la columna y precio es el mismo
            Assert.assertEquals(modelo,modelCart);
            Assert.assertEquals(precio,priceCart);

            //Hacer click en el boton de ordenar
            cartPage.clickButtonPlaceOrder();

            //Completar el formulario
            formPage.formComplete("Paula","Alaska","Palmer","42857541924","Julio","2027");

            //Hacer click en el boton comprar
            formPage.clickButtonPurchase();

            //Mensaje de confirmación
            Assert.assertEquals(confirmationPage.getMessage(), "Thank you for your purchase!");

            //Cierro el navegador
            driver.quit();
        }
}

