package com.sel.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sel.pages.Boxture_LoginPage;
import com.sel.pages.Boxture_Sales;
import com.sel.pages.Sidebar_Click;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import resources.ExtentReporterNG;
import tests.BaseTest;

import java.awt.*;
import java.io.IOException;


public class Boxture_SalesOrder extends BaseTest {


    private String username;
    private String password;
    private String customer;
    private String product;
    private String tote;


    @BeforeTest
    @Parameters({"username1", "password", "customer", "product", "tote"})
    public void setupParameters(String username1, String password, String customer, String product, String tote) {
        this.username = username1;
        this.password = password;
        this.customer = customer;
        this.product = product;
        this.tote = tote;

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
    public void sidebarClicks() {
        Sidebar_Click sidebarclick = new Sidebar_Click(driver);
        sidebarclick.order_click();
        sidebarclick.create_Order();
        sidebarclick.new_sales_Order();
    }

    @Test(dependsOnMethods = {"sidebarClicks"})
    public void salesOrdercontents() throws InterruptedException {
        Boxture_Sales createPage = new Boxture_Sales(driver);
        createPage.customer(customer);
        createPage.product(product);
        createPage.createSales();
        Thread.sleep(5000);
        createPage.orderNumGenerated();
        String orderNum = createPage.orderNumGenerated();
        System.out.println(orderNum);
        createPage.confirmOrderClick();
        createPage.pickOnClick();
        createPage.pickListClick();
        createPage.mobileWebsite();
        createPage.scanTote(tote);
        createPage.pickAfterScan();

    }


}