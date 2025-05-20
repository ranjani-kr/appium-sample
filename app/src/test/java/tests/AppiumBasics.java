package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

public class AppiumBasics extends BaseTest {

    @Test
    public void AppiumTest() throws InterruptedException {

        System.out.println("App launched! Session: " + driver.getSessionId());
        Thread.sleep(3000);

        // Tap on "Preference"
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        // Scroll to "3. Preference dependencies" using UiScrollable
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().description(\"3. Preference dependencies\"))"));

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();

        // Find the checkbox
        WebElement checkbox = driver.findElement(AppiumBy.id("android:id/checkbox"));

        // Wait for it to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        checkbox.click();

        // Verify state
        boolean isChecked = Boolean.parseBoolean(checkbox.getAttribute("checked"));
        System.out.println("Checkbox checked status: " + isChecked);

        //click on wifi setting
        WebElement secondItem = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout"));
        secondItem.click();

        //enter wifi name and select Ok
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Ranjani's wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();



    }
}
