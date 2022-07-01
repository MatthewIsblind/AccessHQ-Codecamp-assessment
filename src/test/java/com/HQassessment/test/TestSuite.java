package com.HQassessment.test;

import com.HQassessment.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSuite {

    WebDriver driver;

    @BeforeEach
    public void Setup(){
        driver = new ChromeDriver();

        driver.get("https://d2tjwct0w5ff76.cloudfront.net/#/");
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

    @Test
    public void RedircetToHomePageTest(){
        //It shows the steps the test go through but it should refactor this since its repeating the login steps in the preivous test
        Navbar navbar = new Navbar(driver);
        navbar.openLoginForm();

        LoginForm loginForm = new LoginForm(driver);
        loginForm.fillUsernameField("bob");
        loginForm.fillPasswordField("ilovepizza");
        loginForm.clickLoginButton();

        navbar.clickProfileIcon();

        String profilePageUrl = driver.getCurrentUrl();
        navbar.clickProfileLogout();

        Assertions.assertEquals(navbar.openProfileScreen(profilePageUrl), "https://d2tjwct0w5ff76.cloudfront.net/#/");


    }

    @Test
    public void OrderEsperssoThickshakeAndPizzaProductCountTest() {
        Navbar navbar = new Navbar(driver);
        navbar.openMenuPage();


        ProductPage productPage = new ProductPage(driver);
        //the argument for this could be better. Didn't know how to properly access the text
        productPage.navigateMenuTab(p -> p.equalsIgnoreCase("local_drink"));
        productPage.orderItem("Espresso ThickShake",1, By.className("drink"));

        productPage.navigateMenuTab(p -> p.equalsIgnoreCase("local_pizza"));
        productPage.orderItem("Margherita",2,By.className("pizza"));

        Assertions.assertEquals(3,navbar.getProductCount());
    }


    @AfterEach
    public void TearDown() {
        driver.quit();
    }
}
