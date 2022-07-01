package com.HQassessment.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Predicate;

public class ProductPage {

    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateMenuTab(Predicate<String> matchingLogic) {
        for (WebElement tabElement : driver.findElements(By.cssSelector("[role=tab]"))) {
            String current = tabElement.findElement(By.className("v-icon")).getText();

            if (matchingLogic.test(current)) {

                tabElement.click();
            }


        }
    }

    public void orderItem(String productBeingOrdered, int quantity,By selector) {

        for (WebElement itemElement : driver.findElements(selector)) {
            String productName = itemElement.findElement(By.className("name")).getText();

            if (productName.equalsIgnoreCase(productBeingOrdered)){

                for (int i = 1; i <= quantity ; i++) {
                    itemElement.findElement(By.className("v-btn__content")).click();
                }
            }
        }
    }


}
