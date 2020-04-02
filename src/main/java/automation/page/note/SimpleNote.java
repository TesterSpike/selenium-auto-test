package automation.page.note;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SimpleNote extends Note {

    SimpleNote(WebDriver driver) {
        super(driver);
    }

    public void selectCategory(String category) {
        new Select(driver.findElement(By.id("singleCategory"))).selectByVisibleText(category);
    }
}
