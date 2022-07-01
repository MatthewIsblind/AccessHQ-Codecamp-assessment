package com.HQassessment.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginForm {

    private final WebDriver driver;

    public LoginForm(WebDriver driver) {
        this.driver = driver;
    }

    public void fillUsernameField(String name) {
        driver.findElement(By.id("gen-20220701-username")).sendKeys(name);
    }

    public void fillPasswordField(String password){
        driver.findElement(By.id("gen-20220701-password")).sendKeys(password);
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label=login]")));
        driver.findElement(By.cssSelector("[aria-label=login]")).click();
    }
}
