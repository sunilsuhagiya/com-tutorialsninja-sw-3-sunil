package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    // ********************** SELECT MENU **************************************//

    public void selectMenu(String menu){
        clickOnElement(By.linkText(menu));
        }

        @Test
        public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
            // 1.1 Mouse hover on “Desktops” Tab and click
            mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
            //1.2 call selectMenu method and pass the menu = “Show All Desktops”
            selectMenu("Show All Desktops");
            //1.3 Verify the text ‘Desktops’
            verifyMessage("Desktops",getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]")));
        }
        @Test
        public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
             //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
            mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
            //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
            selectMenu("Show All Laptops & Notebooks");
            //2.3 Verify the text ‘Laptops & Notebooks’
            verifyMessage("Laptops & Notebooks",getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]")));
        }
        @Test
        public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //3.1 Mouse hover on “Components” Tab and click
            mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
            //3.2 call selectMenu method and pass the menu = “Show All Components”
            selectMenu("Show All Components");
            //3.3 Verify the text ‘Components’
            verifyMessage("Laptops & Notebooks",getTextFromElement(By.xpath("//h2[contains(text(),'Components')]")));
        }


    @After
    public void testDown() {
        closeBrowser();
    }
}