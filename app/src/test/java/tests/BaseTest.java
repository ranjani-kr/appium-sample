package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BaseTest {

    public AppiumDriverLocalService service;
    public AndroidDriver driver;

    @BeforeClass
    public void setUp() throws URISyntaxException, MalformedURLException {
        String appiumPath = System.getenv("APPIUM_JS_PATH");
        String deviceName = System.getenv().getOrDefault("ANDROID_DEVICE_NAME", "Android Emulator");
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumPath))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();


        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setApp("/Users/ranjani/IdeaProjects/AppiumProject/app/src/test/resources/ApiDemos-debug.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
