const Page = require('./page');

/**
 * sub page containing specific selectors and methods for a specific page
 */
class CartPage extends Page {
    /**
     * define selectors using getter methods
     */
    get titleFirstModelAdd(){
        return $("//tr[@class='success']/td[2]")
    };
    get priceFirstModelAdd(){
        return $("//tr[@class='success']/td[3]")
    };
    get buttonPlaceOrder(){
        return $("//button[text()='Place Order']")
    };

    async getModelCart() {
        await this.getTextFromWebElement(this.titleFirstModelAdd);
    }
    async getPrice() {
        await this.getPriceCart(this.priceFirstModelAdd);
    }

    async getclickButtonPlaceOrder() {
        await this.clickOnWebElement(this.buttonPlaceOrder);
    }
}

module.exports = new CartPage();