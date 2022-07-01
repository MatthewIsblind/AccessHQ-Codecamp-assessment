package com.HQassessment.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Predicate;

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

    public void clickProfileLogout() {
        Actions action = new Actions(driver);
        WebElement profileIcon = driver.findElement((By.className("nav-profile")));
        action.moveToElement(profileIcon).perform();
        new WebDriverWait(driver , 3).until(ExpectedConditions.visibilityOfElementLocated((By.className("dd-nav-logout"))));
        driver.findElement(By.className("dd-nav-logout")).click();

        new WebDriverWait(driver , 3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label=yes]")));
        driver.findElement(By.cssSelector("[aria-label=yes]")).click();


    }

    public String openProfileScreen(String profileScreenUrl) {

        driver.get(profileScreenUrl);
        return driver.getCurrentUrl();

    }

    public void openMenuPage() {
        driver.findElement(By.cssSelector("[aria-label=menu]")).click();
    }


    public int getProductCount() {
        String numtext =  driver.findElement(By.className("v-chip")).findElement(By.className("order-count")).getText();
        return Integer.parseInt(numtext);
    }
}
