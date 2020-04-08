package steps;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;

class BaseStep {
    final ChromeDriver driver;

    BaseStep() {
        WebDriverManager.chromedriver().setup(); //gets matching version of the chrome driver for the test system
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", "failure_" + LocalDateTime.now());
        }
        driver.quit();
    }
}
