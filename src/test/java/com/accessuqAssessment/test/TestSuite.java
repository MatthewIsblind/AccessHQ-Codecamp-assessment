package com.accessuqAssessment.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSuite {

    private WebDriver driver;

    @BeforeEach
    public void Setup(){
        driver = new ChromeDriver();

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.manage().window().maximize();
    }

    @Test
    public void ForenameInputSubmit(){

        driver.findElement(By.id("forename")).sendKeys("Matthew");
        driver.findElement(By.id("submit")).click();
        var popup = driver.findElement(By.className("popup-message"));

        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOfElementLocated(By.className("popup-message")));
        Assertions.assertEquals("Hello Matthew", popup.getText());

    }
}
