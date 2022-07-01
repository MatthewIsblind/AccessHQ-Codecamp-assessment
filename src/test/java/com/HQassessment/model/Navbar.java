package com.HQassessment.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Navbar {

    private final WebDriver driver;

    public Navbar(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginForm() {
        driver.findElement(By.className("nav-login-signup")).click();

    }


    public void clickProfileIcon() {
        driver.findElement((By.className("nav-profile"))).click();

    }
}
