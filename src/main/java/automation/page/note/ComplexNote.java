package automation.page.note;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class ComplexNote extends Note {

    ComplexNote(WebDriver driver) {
        super(driver);
    }

    public void selectCategories(Iterable<String> categories) {
        ISelect categorySelect = new Select(driver.findElement(By.id("multiCategory")));
        for (String category : categories) {
            categorySelect.selectByVisibleText(category);
        }
    }

    public void enterText(String text) {
        driver.findElement(By.id("noteText")).sendKeys(text);
    }
}
