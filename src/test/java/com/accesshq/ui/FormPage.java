package com.accesshq.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage {

    private final WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(By.cssSelector("input#name")).sendKeys(name);
    }

    public String getName() {
        return driver.findElement(By.cssSelector("input#name")).getAttribute("value");
    }

    public void setEmail(String email) {
        driver.findElement(By.cssSelector("input#email")).sendKeys(email);
    }

    public String getEmail() {
        return driver.findElement(By.cssSelector("input#email")).getAttribute("value");
    }

    public WebElement findAgree() {
        return driver.findElement(By.cssSelector("[for=agree]"));
    }

    public WebElement findSubmit () {
        for (WebElement ele : driver.findElements(By.tagName("button"))) {
            if (ele.findElement(By.tagName("span")).getAttribute("innerHTML").equals("submit")) {
                return ele;
            }
        }
        throw new NoSuchElementException("No button found");
    }

    public WebElement getPopup() {
        return driver.findElement(By.className("popup-message"));
    }

    public boolean isNameErrDisplayed() {
        return driver.findElement(By.id("name-err")).isDisplayed();
    }

    public boolean isEmailErrDisplayed() {
        return driver.findElement(By.id("email-err")).isDisplayed();
    }

    public boolean isAgreeErrDisplayed() { return driver.findElement(By.id("agree-err")).isDisplayed(); }
}
