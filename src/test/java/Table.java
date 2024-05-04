import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Table extends BaseTest {
    @Test
    public void sortableDataTablesTest() {

        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement element = driver.findElement(By.xpath ("//table//tr[1]//td[2]"));
        Assert.assertEquals(element.getText(), "John");


        element = driver.findElement(By.xpath ("//table//tr[2]//td[2]"));
        Assert.assertEquals(element.getText(), "Frank");

        element = driver.findElement(By.xpath ("//table//tr[3]//td[2]"));
        Assert.assertEquals(element.getText(), "Jason");

        element = driver.findElement(By.xpath ("//table//tr[4]//td[2]"));
        Assert.assertEquals(element.getText(), "Tim");
    }
}
