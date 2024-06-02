import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {
    @Test
    public void fileUploadPositiveTest() {
        driver.get("https://the-internet.herokuapp.com/upload");
        String pathToFile = System.getProperty("user.dir") + "/src/test/resources/Документ Microsoft Word.docx";

        driver.findElement(By.id("file-upload")).sendKeys(pathToFile);
        driver.findElement(By.cssSelector("input[id=file-submit]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[text()='File Uploaded!']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed());
    }
}
