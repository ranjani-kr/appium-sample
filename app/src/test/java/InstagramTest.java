package test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class InstagramTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "15");  // Your emulator version
        capabilities.setCapability("deviceName", "emulator-5554");  // Emulator ID
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.instagram.android");
       //capabilities.setCapability("appActivity", "com.instagram.android/.activity.MainTabActivity");
        capabilities.setCapability("appActivity", "com.instagram.android/com.instagram.mainactivity.MainActivity.");
        capabilities.setCapability("noReset", true); // Ensures the app is not reset on each test run
        capabilities.setCapability("fullContextList", true); // Get all the context details when switching between native/web views



        //Dynamically resolve the APK path
        String projectDir = System.getProperty("user.dir");
        String apkPath = projectDir + "/src/test/resources/com.instagram.android_apkmirror.com.apk";
        System.out.println("APK Path: " + apkPath);
        capabilities.setCapability("app", apkPath);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    // @Test
    // public void testLoginButton() throws InterruptedException {
    //     System.out.println("Locating the login button...");
    //     WebElement loginButton = driver.findElement(By.xpath("//*[@content-desc='Log In']")); // Use XPath or other locators
    //     System.out.println("Clicking the login button...");
    //     loginButton.click();
    //     Thread.sleep(5000);  // Let the app load for a few seconds
    //     System.out.println("Test completed.");
    // }

    @Test
    public void launchInstagram() {
    System.out.println("Instagram launched successfully!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}