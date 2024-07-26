package Builder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


enum FindBy {
    ByXPath,
    ByCssSelector,
    ByClass
}

interface WebActions {
    void clickAction(String selector, String findby, boolean shouldWait);
    List<WebElement> findElements(String selector, String findby);
}

public class Command implements WebActions {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public Command(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    @Override
    public void clickAction(String selector, String findby, boolean shouldWait) {

        FindBy findBy = FindBy.valueOf(findby);

        WebElement element = WaitOrfindElement(selector, findBy, shouldWait);

        element.click();
    }

    @Override
    public List<WebElement> findElements(String selector, String findby) {
        FindBy findBy = FindBy.valueOf(findby);
        return driver.findElements(getBy(selector, findBy));
    }

    private WebElement WaitOrfindElement(String selector, FindBy findBy, boolean shouldWait) {
        By by = getBy(selector, findBy);

        if (shouldWait) {
            System.out.println(by);
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        } else {
            return driver.findElement(by);
        }
    }

    private By getBy(String selector, FindBy findBy) {
        return switch (findBy) {
            case ByXPath -> By.xpath(selector);
            case ByCssSelector -> By.cssSelector(selector);
            case ByClass -> By.className(selector);

        };
    }
}