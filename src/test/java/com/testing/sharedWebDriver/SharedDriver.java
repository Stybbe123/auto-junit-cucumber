package com.testing.sharedWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SharedDriver extends EventFiringWebDriver {
    private static WebDriver REAL_DRIVER = null;

    private static final Thread CLOSE_THREAD = new Thread(() -> REAL_DRIVER.close());

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SharedDriver() {
        super(CreateDriver());
    }

    private static WebDriver CreateDriver() {
        WebDriver webDriver;
        if (REAL_DRIVER == null) {
            webDriver = new ChromeDriver();
            setWebDriver(webDriver);
        }
        return getWebDriver();
    }

    private static void setWebDriver(WebDriver webDriver) {
        REAL_DRIVER = webDriver;
    }

    public static WebDriver getWebDriver() {
        return REAL_DRIVER;
    }

    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }
}