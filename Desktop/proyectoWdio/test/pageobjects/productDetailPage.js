const Page = require('./page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class ProductsDetailPage extends Page {
    /**
     * define selectors using getter methods
     */
    get model(){
        return $("//h2[@class='name']")
    };
    get price(){
        return $("//h3[@class='price-container']")
    };
    get addToCartButton(){
        return $("//a[text()='Add to cart']")
    };

    async getModel() {
        await this.getTextFromWebElement(this.model);
    }
    async getPrice() {
        const priceText = await this.getTextFromWebElement(this.price);
        const inicioPrice = priceText.indexOf("$") + 1;
        const finPrice = priceText.indexOf("*") - 1;
        return (priceText.substring(inicioPrice, finPrice));
    }

    async clickAddToCart() {
        await this.clickOnWebElement(this.addToCartButton);
    }
}

module.exports = new ProductsDetailPage();