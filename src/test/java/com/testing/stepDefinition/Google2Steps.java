package com.testing.stepDefinition;

import com.testing.sharedWebDriver.SharedDriver;
import com.testing.imageCompare.ASIFTMatchingExample;
import com.testing.pageObjects.GooglePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Google2Steps implements En {

    private BufferedImage logo;
    private WebDriver driver;

    @Given("^page 2 open link \"([^\"]*)\"$")
    public void pageOpenLink(String link) {
        driver = new SharedDriver();
        driver.get(link);
    }

    @When("^capture 2 logo$")
    public void takeScreenshot() throws IOException {
        GooglePage googlePage = PageFactory.initElements(driver, GooglePage.class);
        String webElementSrc = googlePage.googleLogo.getAttribute("src");
        logo = ImageIO.read(new URL(webElementSrc));
    }

    @Then("^compare 2 with saved screenshot by screenshotName \"([^\"]*)\" and matchScore is greater then (\\d+) percent$")
    public void compareWithSavedScreenshotByScreenshotNameWithMatch(String screenshotName, Integer matchScore) throws IOException {
        InputStream googleLogo = GoogleSteps.class.getClassLoader().getResourceAsStream("screenshot/" + screenshotName);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(logo, "png", byteArrayOutputStream);

        Float score = ASIFTMatchingExample.compareTwoImages(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), googleLogo);

        assert score >= (float) matchScore/100;
    }

}
