import automation.SystemVariable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BasicTest {
    private final SystemVariable systemVariable = new SystemVariable();

    @Test
    void simpleTest() {
        WebDriverManager.chromedriver().setup(); //gets matching version of the chrome driver for the test system
        WebDriver driver = new ChromeDriver();
        driver.get(systemVariable.baseUrl);
        Assertions.assertEquals("Single Page App demo", driver.getTitle(), "Simple test");
        driver.quit();
    }
}
