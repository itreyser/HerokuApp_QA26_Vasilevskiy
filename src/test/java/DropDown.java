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


        elements.get(1).click();
        Assert.assertTrue(elements.get(1).isSelected(), "Первый элемент выбран");

        elements.get(2).click();
        Assert.assertTrue(elements.get(2).isSelected(), "Второй элемент выбран");

    }
}
