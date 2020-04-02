package automation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHelper {
    private final WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns an element whose previous sibling has matching text
     *
     * @param elementType The element type you want to return, e.g. "span"
     * @param siblingType The element type of the sibling, e.g. "div"
     * @param siblingText The text value of the sibling element
     * @return Web Element
     */
    public WebElement findElementBySiblingText(String elementType, String siblingType, String siblingText) {
        return driver.findElement(By.xpath(String.format("//%s[normalize-space() = '%s']/following-sibling::%s", siblingType, siblingText, elementType)));
    }
}
