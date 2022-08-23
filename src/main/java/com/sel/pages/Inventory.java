package com.sel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Inventory {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(linkText = "Inventory")
    private WebElement inventory;
    @FindBy(xpath = "(//span[@class='sts-sidebar-menu-item__label'][normalize-space()='Adjust'])[2]")
    private WebElement adjust;
    @FindBy(xpath = "//input[@placeholder='Bin location']")
    private WebElement bin;
    @FindBy(xpath = "//input[@placeholder='Product']")
    private WebElement product;
    @FindBy(xpath = "//input[@id='inventory_adjust_quantity']")
    private WebElement quantity;

    @FindBy(xpath = "//button[normalize-space()='Adjust']")
    private WebElement adjustFinalClick;

    @FindBy(xpath = "//div[@data-controller='satis-tabs']//div//div//div//button[@type='button']//span")
    private WebElement mouseHover;

    @FindBy(xpath = "//span[normalize-space()='Receive']")
    private WebElement receiveClick;

    @FindBy(xpath = "//input[@placeholder='Packing material']")
    private WebElement packingMaterial;

    @FindBy(xpath = "//button[@name='commit']//span[@title='translation missing: en.orders.receives.new.receive'][normalize-space()='Receive']")
    private WebElement finalReceive;
    @FindBy(xpath = "//dd[normalize-space()='completed']")
    private WebElement status;

    @FindBy(xpath = "//dd[normalize-space()='confirming']")
    private WebElement confirming;

    @FindBy(xpath = "//dd[normalize-space()='pending']")
    private WebElement pending;


    public Inventory(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void inventoryClick() {
        this.wait.until(ExpectedConditions.visibilityOf(this.inventory));
        inventory.click();
    }
    public void adjust_Click() {
        this.wait.until(ExpectedConditions.visibilityOf(this.adjust));
        adjust.click();
    }


    public void bin_location(String bin) throws InterruptedException {

        this.wait.until(ExpectedConditions.visibilityOf(this.bin));
        this.bin.click();
        this.bin.clear();
        this.bin.sendKeys(bin);
        Thread.sleep(3000);
    }

    public void product(String product) throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.product));
        this.product.click();
        this.product.clear();
        this.product.sendKeys(product);
        Thread.sleep(3000);

    }

    public void quantity(String quantity) throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.quantity));
        this.quantity.click();
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
        Thread.sleep(3000);
    }

    public void adjustFinal() throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.adjustFinalClick));
        adjustFinalClick.click();

    }



}
