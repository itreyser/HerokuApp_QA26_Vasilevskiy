import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxes extends BaseTest {
    @Test
    public void checkBoxesTest() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("div#content input[type=checkbox]"));
        Assert.assertFalse(checkBoxes.get(0).isSelected(), "Проверка, что первый чек-бокс не выбран");

        checkBoxes.get(0).click();
        Assert.assertTrue(checkBoxes.get(0).isSelected(), "Проверка, что первый чек-бокс выбран");

        Assert.assertTrue(checkBoxes.get(1).isSelected(), "Проверка, что второй чек-бокс выбран");

        checkBoxes.get(1).click();
        Assert.assertFalse(checkBoxes.get(1).isSelected(), "Проверка, что первый чек-бокс выбран");
    }

}
