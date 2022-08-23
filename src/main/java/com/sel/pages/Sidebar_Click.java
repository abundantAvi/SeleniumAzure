package com.sel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sidebar_Click {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".flex-grow > .flex-1 > .sts-sidebar-menu-item:nth-child(2) > .sts-sidebar-menu-item__link > .sts-sidebar-menu-item__label")
    private WebElement orderButton;
    @FindBy(linkText = "Create")
    private WebElement createOrder;
    @FindBy(linkText = "New sales order")
    private WebElement newSalesOrder;
    @FindBy(linkText = "New purchase order")
    private WebElement newPurchaseOrder;


    public Sidebar_Click(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void order_click() {
        this.wait.until(ExpectedConditions.visibilityOf(this.orderButton));
        orderButton.click();
    }
    public void order_double_click() {
        Actions act = new Actions(driver);
        act.doubleClick(orderButton).perform();
    }
    public void create_Order() {
        createOrder.click();
    }

    public void new_sales_Order() {
        newSalesOrder.click();
    }

    public void new_purchase_Order() {
        newPurchaseOrder.click();
    }


}
