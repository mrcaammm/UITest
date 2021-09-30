package com.accesshq.Tests;

import com.accesshq.ui.FormPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class formsPageTests {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/forms");
    }

    @AfterEach
    public void clean() {
        driver.quit();
    }

    @Test
    public void submitErrorTest() {
        //Setup
        FormPage formPage = new FormPage(driver);
        formPage.findSubmit().click();

        Assertions.assertTrue(formPage.isNameErrDisplayed());
        Assertions.assertTrue(formPage.isEmailErrDisplayed());
        Assertions.assertTrue(formPage.isAgreeErrDisplayed());

        //Act
        var response = driver.findElement(By.cssSelector("[id='name-err']"));
        var response2 = driver.findElement(By.cssSelector("[id='email-err']"));

        //Assert
        Assertions.assertEquals(response.getText(),"Your name is required");
        Assertions.assertEquals(response2.getText(),"Your email is required");
    }

    @Test
    public void checkTextTest() {
        //Setup
        FormPage formPage = new FormPage(driver);

        //Act
        formPage.setName("Cameron Coyle");
        formPage.setEmail("cameron.coyle@accesshq.com");

        var str = formPage.getName();
        var str2 = formPage.getEmail();

        //Assert
        Assertions.assertTrue(!str.isEmpty());
        Assertions.assertTrue(!str2.isEmpty());
    }

    @Test
    public void checkboxTest() {
        //Setup
        FormPage formPage = new FormPage(driver);

        //Act
        formPage.findAgree().click();

        //Assert
        //Assertions.assertTrue(checkbox.isSelected());
    }

    @Test
    public void fullSubmitTest() {
        //Setup
        FormPage formPage = new FormPage(driver);

        //Act
        formPage.setName("Cameron Coyle");
        formPage.setEmail("cameron.coyle@accesshq.com");
        formPage.findAgree().click();
        formPage.findSubmit().click();

        var popup = formPage.getPopup();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(popup));

        //Assert
        Assertions.assertEquals("Thanks for your feedback " + "Cameron Coyle", popup.getText());
    }
}