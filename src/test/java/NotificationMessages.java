import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessages extends BaseTest {
    @Test
    public void notificationMessagesTest() {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");

        driver.findElement(By.xpath("//a[text()='Click here']")).click();

        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed(), "отображение текста");

        WebElement element = driver.findElement(By.xpath("//div[@id='flash']"));
        Assert.assertEquals(element.getText().replace("×", "").trim(), "Action successful");

    }
}
