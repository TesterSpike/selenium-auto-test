package automation.page;

import automation.util.ElementHelper;
import org.openqa.selenium.WebDriver;

public class OutputNote {
    private final ElementHelper helper;

    public OutputNote(WebDriver driver) {
        helper = new ElementHelper(driver);
    }

    public String getPriority() {
        return helper.findElementBySiblingText("span", "span", "Priority:").getText();
    }

    public String getName() {
        return helper.findElementBySiblingText("span", "span", "Name:").getText();
    }

    public String getCategory() {
        return helper.findElementBySiblingText("span", "span", "Category:").getText();
    }

    public String getCategories() {
        return helper.findElementBySiblingText("span", "span", "Categories:").getText();
    }

    public String getCreationDate() {
        return helper.findElementBySiblingText("span", "span", "Timestamp:").getText();
    }

    public String getNoteText() {
        return helper.findElementBySiblingText("span", "span", "Text:").getText();
    }

    public String getTimeStamp() {
        return helper.findElementBySiblingText("span", "span", "Timestamp:").getText();
    }
}
