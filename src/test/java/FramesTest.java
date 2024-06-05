import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest{


    @Test
    public void framesTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "Your content goes here.");
        driver.switchTo().defaultContent();


    }
}
