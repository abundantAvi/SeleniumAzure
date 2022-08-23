package com.sel.tests;

import com.sel.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.awt.*;

public class Boxture_InventoryAdjust extends BaseTest {

    private String username;
    private String password;

    @BeforeTest
    @Parameters({"username1", "password"})
    public void setupParameters(String username1, String password) {
        this.username = username1;
        this.password = password;

    }
    @Test
    public void adjustInventory() throws AWTException, InterruptedException {

        Boxture_LoginPage loginPage = new Boxture_LoginPage(driver);
        loginPage.loginUrl();
        Thread.sleep(3000);
        loginPage.username_enter(username);
        loginPage.password_enter(password);
        loginPage.login_buttonClick();
    }
    @Test(dependsOnMethods = {"adjustInventory"})
    public void inventory() throws InterruptedException {
        Inventory inventory = new Inventory(driver);
        inventory.inventoryClick();
        inventory.adjust_Click();
        inventory.bin_location("AVITESTBIN123");
        inventory.product("Auto Test 123");
        inventory.quantity("1");
        inventory.adjustFinal();
    }

}