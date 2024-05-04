import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Typos extends BaseTest {
    @Test
    public void typosTest() {

        driver.get("https://the-internet.herokuapp.com/typos");

        WebElement element = driver.findElement(By.cssSelector("div#content p:last-child"));
        Assert.assertEquals(element.getText().trim(), "Sometimes you'll see a typo, other times you won't.");
    }
}
