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
        //The selector argument is so that it can be used later on if there are more tab pages like dessert
        productPage.orderItem("Espresso ThickShake",1, By.className("drink"));

        productPage.navigateMenuTab(p -> p.equalsIgnoreCase("local_pizza"));
        productPage.orderItem("Margherita",2,By.className("pizza"));

        Assertions.assertEquals(3,navbar.getProductCount());
    }

    @Test
    public void CheckOrderSubtotal() {
        Navbar navbar = new Navbar(driver);
        navbar.openMenuPage();


        ProductPage productPage = new ProductPage(driver);
        productPage.navigateMenuTab(p -> p.equalsIgnoreCase("local_drink"));
        productPage.orderItem("Espresso ThickShake",1, By.className("drink"));

        productPage.navigateMenuTab(p -> p.equalsIgnoreCase("local_pizza"));
        productPage.orderItem("Margherita",2,By.className("pizza"));

        //click on the order navigation
        //navbar.clickOrderPageButton();


        //assrtequal here to check subtotal. The margherita subtotal can be found using a seperate method.
        // OrderPage class may have to be created to account for future methods that may be on the page
        //Assertions.assertEquals(19.98,ProductPage.getSubtotal("margherita"));

    }

    @AfterEach
    public void TearDown() {
        driver.quit();
    }
}
