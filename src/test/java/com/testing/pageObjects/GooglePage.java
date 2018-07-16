package com.testing.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GooglePage {

final WebDriver driver;

@FindBy(how = How.ID, using = "hplogo")
public WebElement googleLogo;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

}
