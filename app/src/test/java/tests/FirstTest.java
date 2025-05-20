package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;

public class FirstTest {
    public static void main(String[] args) {
        AndroidDriver driver = null;
        try {
            // 1. Set capabilities (using your EXACT path)
            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName("emulator-5554")
                    .setApp("/Users/ranjani/IdeaProjects/AppiumProject/app/src/test/resources/ApiDemos-debug.apk");

            // 2. Initialize driver
            System.out.println("Attempting to start session...");
            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"),
                    options
            );
            Thread.sleep(5000);

            // 3. Test verification
            System.out.println("SUCCESS! Application launched!");
            System.out.println("Session ID: " + driver.getSessionId());

        } catch (Exception e) {
            System.out.println("TEST FAILED!");
            e.printStackTrace();
        } finally {
            // 4. Clean up
            if (driver != null) {
                driver.quit();
                System.out.println("Driver closed");
            }
        }
    }
}