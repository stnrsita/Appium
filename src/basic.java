// Import statements
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction; 

/**
 * Class to demonstrate basic Appium operations on an Android device.
 * Inherits capabilities from base class for setting up the driver.
 */
public class basic extends base {

    /**
     * Main method to execute the test automation script.
     * @param args Command-line arguments (not used in this script).
     * @throws MalformedURLException Thrown when a malformed URL is encountered.
     */
    public static void main(String[] args) throws MalformedURLException {
        // Initialize driver
        AndroidDriver<AndroidElement> driver = capabilities();

        // Wait for the element to be clickable and then click it
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            // Using XPath to locate and click a button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Galeri']"))).click();
        } catch (StaleElementReferenceException e) {
            // Re-locate the element and click it if stale element exception occurs
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Galeri']"))).click();
        }

        // Using Android UI Automator to click an element
        try {
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("text(\"Albums\")"))).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("text(\"Albums\")"))).click();
        }

        // Using direct UI Selector copied from Appium Inspector
        try {
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Photos\")"))).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Photos\")"))).click();
        }

        // Clicking an element identified by XPath
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.providers.media.module:id/icon_thumbnail'])[2]"))).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.providers.media.module:id/icon_thumbnail'])[2]"))).click();
        }

        // Swipe functionality for a specific element
        WebDriverWait swipeWait = new WebDriverWait(driver, 10);
        try {
            WebElement scaleScrollWheel = swipeWait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.id("com.dicoding.asclepius:id/scale_scroll_wheel")
                )
            );

            // Coordinates for starting (353%) and ending (380%)
            int startX = scaleScrollWheel.getLocation().getX() + scaleScrollWheel.getSize().getWidth() / 2;
            int startY = scaleScrollWheel.getLocation().getY() + (int) (scaleScrollWheel.getSize().getHeight() * 0.169);
            int endY = scaleScrollWheel.getLocation().getY() + (int) (scaleScrollWheel.getSize().getHeight() * 0.269);

            TouchAction t = new TouchAction(driver);
            t.longPress(longPressOptions().withElement(element(scaleScrollWheel)).withDuration(ofSeconds(1)))
                    .moveTo(element(scaleScrollWheel, startX, endY))
                    .release()
                    .perform();
        } catch (Exception e) {
            System.out.println("269% scale not found on scale_scroll_wheel: " + e.getMessage());
        }
        
        // Using Android UI Automator to click an element by resource ID
        try {
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.dicoding.asclepius:id/image_view_state_rotate\")"))).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.dicoding.asclepius:id/image_view_state_rotate\")"))).click();
        }
        
        // Clicking a menu item by its ID
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.dicoding.asclepius:id/menu_crop"))).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.dicoding.asclepius:id/menu_crop"))).click();
        }

        // Clicking a button using XPath
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Analyze']"))).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Analyze']"))).click();
        }
        
        // Scrolling to a specific text and clicking it
        try {
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"[Removed]\"));");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id='com.dicoding.asclepius:id/tvTittle' and @text='[Removed]']"))).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id='com.dicoding.asclepius:id/tvTittle' and @text='[Removed]']"))).click();
        }
        
        // Clicking a button using its resource ID
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"com.dicoding.asclepius:id/saveButton\"]"))).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"com.dicoding.asclepius:id/saveButton\"]"))).click();
        }

        // Clicking an image button using its class name
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageButton"))).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageButton"))).click();
        }
        
        // Clicking a button at a specific index in a list
        try {
            AndroidElement element = driver.findElementsByClassName("android.widget.Button").get(0);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (StaleElementReferenceException e) {
            AndroidElement element = driver.findElementsByClassName("android.widget.Button").get(0);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }

        // Scrolling to a specific text and clicking it  
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Insomnia linked to higher ovarian cancer risk and mortality in new genetic study - News-Medical.Net\"));"
                )
            )).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Insomnia linked to higher ovarian cancer risk and mortality in new genetic study - News-Medical.Net\"));"
                )
            )).click();
        }
        
        // Clicking an image button using its class name  
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageButton"))).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageButton"))).click();
        } 
        
        // Clicking an element by its ID
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.dicoding.asclepius:id/histories"))).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.dicoding.asclepius:id/histories"))).click();
        }
        
        // Clicking an image button using its class name  
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageButton"))).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.ImageButton"))).click();
        }
    }
}
