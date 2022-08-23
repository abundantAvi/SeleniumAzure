package com.sel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Boxture_LoginPage {


    public WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#user_email")
    private WebElement username;
    @FindBy(css = "#user_password")
    private WebElement password;
    @FindBy(css = "button[value='save']")
    private WebElement button;

    public Boxture_LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void loginUrl() throws AWTException {
        this.driver.get("https://oms.staging.boxture.com/");
//        Robot robot = new Robot();
        this.driver.manage().window().maximize();

        System.out.println("About to zoom in");
//
//        for (int i = 0; i < 3; i++) {
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_SUBTRACT);
//            robot.keyRelease(KeyEvent.VK_SUBTRACT);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            driver.manage().window().maximize();

//        }

        this.wait.until(ExpectedConditions.visibilityOf(this.username));
    }

    public void username_enter(String email) {
        this.username.sendKeys(email);
    }

    public void password_enter(String password) {
        this.password.sendKeys(password);
    }

    public void login_buttonClick() {
        this.button.click();
    }


}
