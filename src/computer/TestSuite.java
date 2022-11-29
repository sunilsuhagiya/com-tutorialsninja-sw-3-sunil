package computer;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl="http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
       //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”

        //1.3 Verify the text ‘Desktops'

    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
//2.1 Mouse hover on “Laptops & Notebooks” Tab and click
//2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
//2.3 Verify the text ‘Laptops & Notebooks’


    }
@Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //3.1 Mouse hover on “Components” Tab and click
    //3.2 call selectMenu method and pass the menu = “Show All Components”
    //3.3 Verify the text ‘Components’
}



}
