import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown extends BaseTest {
    @Test
    public void DropDownTest() {

        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> elements = select.getOptions();
        Assert.assertTrue(elements.get(0).isDisplayed(), "Наличие 1го елемента");
        Assert.assertTrue(elements.get(1).isDisplayed(), "Наличие 2го елемента");
        Assert.assertTrue(elements.get(2).isDisplayed(), "Наличие 3го елемента");

        select.selectByIndex(1);
        Assert.assertEquals("Option 1", select.getFirstSelectedOption().getText(), "Текст второго выбранного элемента");

        select.selectByIndex(2);
        Assert.assertEquals("Option 2", select.getFirstSelectedOption().getText(), "Текст третьего выбранного элемента");
    }
}
