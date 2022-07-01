package com.HQassessment.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.print.PageFormat;

public class ProfilePage {

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderText() {
        String headerText = driver.findElement(By.className("v-main__wrap")).getText();
        //I didn't know how to access certain elements so I did some string manipulation to single out the header text
        //Didn't know to skip the person element
        headerText = headerText.replace("\n", "");
        headerText = headerText.replace("person","");
        return headerText;
    }
}
