package automation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHelper {
    private final WebDriver driver;
    private final Logger logger = new Logger(getClass());

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

    /**
     * Highlights the element currently selected for the number of seconds specified to aid in visually determining
     * which element is being selected.
     *
     * @param element WebElement
     * @param seconds Integer of seconds to wait until highlight removed
     */
    public void highlightElement(WebElement element, int seconds) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String originalStyle = element.getAttribute("style");

        js.executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                "border: 2px solid red; border-style: dashed;");

        if (seconds > 0) {
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                logger.error("Element highlighting was interrupted", e);
            }
            js.executeScript(
                    "arguments[0].setAttribute(arguments[1], arguments[2])",
                    element,
                    "style",
                    originalStyle);
        }
    }

    /**
     * Highlights the element currently selected for 3 seconds, to aid in visually determining which element is active
     *
     * @param element WebElement
     */
    public void highlightElement(WebElement element) {
        highlightElement(element, 3);
    }
}
