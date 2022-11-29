package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility{
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("input-sort"),"Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
        String expectedText = "Name (Z - A)";
        // Actual Message
        String actualText = getTextFromElement(By.xpath("//option[contains(text(),'Name (Z - A)')]"));
        //verify actual and expected message
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.id("input-sort"),"Name (A - Z)");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[3]/div[1]/div[1]/a[1]/img[1]"));
        //2.5 Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        // Actual Message
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        //verify actual and expected message
        Assert.assertEquals(expectedText, actualText);
        //2.6 Select Delivery Date "2022-11-30"

        //2.7.Enter Qty "1” using Select class.
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(3000);
        verifyMessage("Success: You have added HP LP3065 to your shopping cart!\n"+"×",getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.11 Verify the text "Shopping Cart"
        verifyMessage("Shopping Cart",getTextFromElement(By.xpath("//a[contains(text(),'Shopping Cart')]")));
        //2.12 Verify the Product name "HP LP3065"
        verifyMessage("HP LP3065",getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")));
        //2.13 Verify the Delivery Date "2022-11-30"
        //2.14 Verify the Model "Product21"
        verifyMessage("Product 21",getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]")));
        // Since I am not in UK i have to fix the Currency as pound
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        clickOnElement(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));
        //2.15 Verify the Total "£74.73"
        verifyMessage("£74.73",getTextFromElement(By.xpath("//tbody/tr[1]/td[6]")));
    }
    @After
    public void testDown() {
        closeBrowser();
    }
    }




