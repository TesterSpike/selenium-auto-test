package automation.page.note;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Type {
    private final WebDriver driver;

    public Type(WebDriver driver) {
        this.driver = driver;
    }

    public ComplexNote advancedNote() {
        driver.findElement(By.id("complexFormRadio")).click();
        return new ComplexNote(driver);
    }

    public SimpleNote simpleNote() {
        driver.findElement(By.id("simpleFormRadio")).click();
        return new SimpleNote(driver);
    }
}
