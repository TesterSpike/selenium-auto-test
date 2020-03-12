import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicTest {
    @Test
    public void simpleTest() {
        WebDriverManager.chromedriver().setup(); //gets matching version of the chrome driver for the test system
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Assertions.assertEquals("Google", driver.getTitle(), "Simple test");
        driver.quit();
    }
}
