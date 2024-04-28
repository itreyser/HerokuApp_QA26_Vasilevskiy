import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Inputs extends BaseTest {
    @Test
    public void inputsTest() {
        driver.get("https://the-internet.herokuapp.com/inputs");

        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("fsdfs");
        Assert.assertEquals(input.getAttribute("value"), "", "Ввод текста");

        input.sendKeys("100");
        Assert.assertEquals(input.getAttribute("value"), "100", "Ввод числа");

        for (int i = 0; i < 5; i++) {
            input.sendKeys(Keys.ARROW_UP);
        }
        Assert.assertEquals(input.getAttribute("value"), "105", "Проверка значения 105");


        for (int i = 0; i < 10; i++) {
            input.sendKeys(Keys.ARROW_DOWN);
        }
        Assert.assertEquals(input.getAttribute("value"), "95", "Проверка значения 95");


    }


}
