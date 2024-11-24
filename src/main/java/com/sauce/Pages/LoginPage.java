package com.sauce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    // Locators
    private By IdInputLocator = By.id("user-name");
    private By passwordInputLocator = By.id("password");
    private By loginButtonLocator = By.id("login-button");
    private By applogo = By.xpath("//div[@class='app_logo']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void enterId(String Id) {
        WebElement emailInput = driver.findElement(IdInputLocator);
        emailInput.sendKeys(Id);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public String getPageTitle() {
        // Fetch the title of the current page
        String pageTitle = driver.getTitle();
        return pageTitle;
    }




}
