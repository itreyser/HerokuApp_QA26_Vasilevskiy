import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlsTest extends BaseTest {
    @Test
    public void dynamicControlsTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p[id=message]"))));
        Assert.assertFalse(isElementPresent(By.cssSelector("input[id=checkbox]")), "Check check-box");

        WebElement input = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        Assert.assertFalse(input.isEnabled(), "check input is disabled");
        driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p[id=message]"))));
        Assert.assertTrue(input.isEnabled(), "check input is enabled");

    }

    public boolean isElementPresent(By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            driver.findElement(locator);
            return true;
        } catch (NotFoundException exception) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }
}
