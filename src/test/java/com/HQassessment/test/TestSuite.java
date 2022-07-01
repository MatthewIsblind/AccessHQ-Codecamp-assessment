package com.HQassessment.test;

import com.HQassessment.model.HomePage;
import com.HQassessment.model.LoginForm;
import com.HQassessment.model.Navbar;
import com.HQassessment.model.ProfilePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSuite {

    WebDriver driver;

    @BeforeEach
    public void Setup(){
        driver = new ChromeDriver();

        driver.get("https://d2dx8jn5qmn998.cloudfront.net/#/");
        driver.manage().window().maximize();

    }

    @Test
    public void LoginAndVerifyProfileHeaderTextTest() {
        Navbar navbar = new Navbar(driver);
        navbar.openLoginForm();

        LoginForm loginForm = new LoginForm(driver);
        loginForm.fillUsernameField("bob");
        loginForm.fillPasswordField("ilovepizza");
        loginForm.clickLoginButton();

        navbar.clickProfileIcon();

        Assertions.assertEquals("Welcome bob", new ProfilePage(driver).getHeaderText());

    }

//    @AfterEach
//    public void TearDown() {
//        driver.quit();
//    }
}
