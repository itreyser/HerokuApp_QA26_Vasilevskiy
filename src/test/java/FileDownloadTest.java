import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class FileDownloadTest {

    @Test
    public void fileDownloadTest() {

        HashMap<String, Object> chromePrefs = new HashMap<>();
        String fullPathToFile = Paths.get("/src/test/resources").toAbsolutePath().toString();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", fullPathToFile);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/download");
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='example']/a"));
        links.get(1).click();

        String fileName = links.get(1).getText();
        File downloadedFile = new File(fullPathToFile + File.separator + fileName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) d -> downloadedFile.exists());
        Assert.assertTrue(downloadedFile.exists(), "Проверка наличия файла");
        downloadedFile.deleteOnExit();

        driver.quit();
    }
}
