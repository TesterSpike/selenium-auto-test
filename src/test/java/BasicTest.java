import automation.SystemVariable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BasicTest {
    private final SystemVariable systemVariable = new SystemVariable();
    WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup(); //gets matching version of the chrome driver for the test system
        driver = new ChromeDriver();
        driver.get(systemVariable.baseUrl);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
