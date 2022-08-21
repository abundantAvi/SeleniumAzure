package com.sel.tests;

import com.sel.pages.Boxture_LoginPage;
import com.sel.pages.Boxture_Purchase;
import com.sel.pages.Boxture_Sales;
import com.sel.pages.Sidebar_Click;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.awt.*;

public class Boxture_PurchaseOrder extends BaseTest {

    private String username;
    private String password;



    @BeforeTest
    @Parameters({"username1", "password"})
    public void setupParameters(String username1, String password) {
        this.username = username1;
        this.password = password;

        //change parameter for PURCHASE ORDER
    }

    @Test
    public void loginPage() throws AWTException, InterruptedException {

        Boxture_LoginPage loginPage = new Boxture_LoginPage(driver);
        loginPage.loginUrl();
        Thread.sleep(3000);
        loginPage.username_enter(username);
        loginPage.password_enter(password);
        loginPage.login_buttonClick();
    }
    @Test(dependsOnMethods = {"loginPage"})
    public void sidebarClicks() throws InterruptedException {
        Sidebar_Click sidebarclick = new Sidebar_Click(driver);
        sidebarclick.order_click();
        sidebarclick.create_Order();
        Boxture_Purchase clickOnPurchaseOrder = new Boxture_Purchase(driver);
        clickOnPurchaseOrder.new_purchase_Order();
        clickOnPurchaseOrder.destination("BTX-ALM");
        clickOnPurchaseOrder.product("BXT-SNXX29999270");
        clickOnPurchaseOrder.createPurchase();
        Boxture_Sales createPage = new Boxture_Sales(driver);
        Thread.sleep(5000);
        createPage.orderNumGenerated();
        String orderNum = createPage.orderNumGenerated();
        System.out.println(orderNum);
        this.driver.navigate().refresh();
        createPage.confirmOrderClick();
        Thread.sleep(2000);
        this.driver.navigate().refresh();
        clickOnPurchaseOrder.receive("box 1", "BXT-SNXX29999270");

    }


}