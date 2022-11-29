package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
        verifyMessage("Price (High > Low)", getTextFromElement(By.xpath("//option[contains(text(),'Price (High > Low)')]")));

    }

    @Test
    //2. Test name verifyThatUserPlaceOrderSuccessfully()
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
        //2.5 Verify the text “MacBook”
        verifyMessage("MacBook", getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]")));
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyMessage("Success: You have added MacBook to your shopping cart!\n" + "×", getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.9 Verify the text "Shopping Cart"
        verifyMessage("Shopping Cart", getTextFromElement(By.xpath("//a[contains(text(),'Shopping Cart')]")));
        //2.10 Verify the Product name "MacBook"
        verifyMessage("MacBook", getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")));
        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyMessage("Success: You have modified your shopping cart!\n" + "×", getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        //
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        clickOnElement(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));
        //2.14 Verify the Total £737.45
        verifyMessage("£737.45", getTextFromElement(By.xpath("//tbody/tr[1]/td[6]")));
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        verifyMessage("Checkout", getTextFromElement(By.xpath("//h1[contains(text(),'Checkout')]")));
        //2.17 Verify the Text “New Customer”
        Thread.sleep(3000);
        verifyMessage("New Customer", getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]")));
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "abc");
        sendTextToElement(By.id("input-payment-lastname"), "abc1");
        sendTextToElement(By.id("input-payment-email"), "abc@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"), "9638258147");
        sendTextToElement(By.id("input-payment-address-1"), "abc street");
        sendTextToElement(By.id("input-payment-city"), "abcxyz");
        sendTextToElement(By.id("input-payment-postcode"), "4153");
        selectByVisibleTextFromDropDown(By.id("input-payment-country"), "Aaland Islands");
        selectByVisibleTextFromDropDown(By.id("input-payment-zone"), " --- None --- ");

        //2.21 Click on “Continue” Button
        clickOnElement(By.id("button-guest"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.name("comment"), "Please consider my order ASAP");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.name("agree"));
        //2.24 Click on “Continue” button
        clickOnElement(By.id("button-payment-method"));
        //2.25 Verify the message “Warning: Payment method required!
        verifyMessage("Warning: No Payment options are available. Please contact us for assistance!", getTextFromElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]")));

    }

    @After
    public void testDown() {
        closeBrowser();
    }

}
