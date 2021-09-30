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
        FormPage fpage = new FormPage(driver);
        fpage.findSubmit().click();

        Assertions.assertTrue(fpage.isNameErrDisplayed());
        Assertions.assertTrue(fpage.isEmailErrDisplayed());
        Assertions.assertTrue(fpage.isAgreeErrDisplayed());

       //  findSubmit(formsDriver).click();

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
        FormPage fpage = new FormPage(driver);

        //Act
        fpage.setName("Cameron Coyle");
        fpage.setEmail("cameron.coyle@accesshq.com");

        var str = fpage.getName();
        var str2 = fpage.getEmail();

        //Assert
        Assertions.assertTrue(!str.isEmpty());
        Assertions.assertTrue(!str2.isEmpty());
    }

    @Test
    public void checkboxTest() {
        //Setup
        FormPage fpage = new FormPage(driver);

        //Act
        fpage.findAgree().click();

        //Assert
        //Assertions.assertTrue(checkbox.isSelected());
    }

    @Test
    public void fullSubmitTest() {
        //Setup
        FormPage fpage = new FormPage(driver);

        //Act
        fpage.setName("Cameron Coyle");
        fpage.setEmail("cameron.coyle@accesshq.com");
        fpage.findAgree().click();
        fpage.findSubmit().click();

        var popup = fpage.getPopup();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(popup));

        //Assert
        Assertions.assertEquals("Thanks for your feedback " + "Cameron Coyle", popup.getText());
    }
}