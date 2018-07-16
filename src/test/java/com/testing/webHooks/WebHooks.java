package com.testing.webHooks;

import com.testing.sharedWebDriver.SharedDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class WebHooks {

    @Before("@web")
    public void setup() {
        System.err.println("SETUP");
    }

    @After("@web")
    public void tearDown(Scenario scenario) {
        System.err.println("TEAR DOWN");
        if (scenario.isFailed()) {
            System.err.println("SCENARIO FAILED");
            WebDriver driver = SharedDriver.getWebDriver();
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
                System.err.println("Screenshot taken on: " + driver.getCurrentUrl());
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }
}
