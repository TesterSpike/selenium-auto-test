package automation.page.note;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Note {
    final WebDriver driver;

    public Note(WebDriver driver) {
        this.driver = driver;
    }

    public void selectPriority(String priority) {
        driver.findElement(By.id("priority")).sendKeys(priority);
    }

    public void submitNote() {
        driver.findElement(By.cssSelector("button[onClick='submitNote()']")).click();
    }

    public void resubmitNote() {
        driver.findElement(By.cssSelector("button[onClick='resubmitNote()']")).click();
    }

    public void enterName(String noteName) {
        driver.findElement(By.id("name")).sendKeys(noteName);
    }
}
