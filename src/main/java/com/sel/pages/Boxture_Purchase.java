package com.sel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Boxture_Purchase {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(linkText = "New purchase order")
    private WebElement newPurchaseOrder;
    @FindBy(css = "input[placeholder='Destination location']")
    private WebElement destination;
    @FindBy(css = "input[placeholder='Product']")
    private WebElement product;
    @FindBy(css = "button[value='save']")
    private WebElement createButton;
    @FindBy(css = "satis-copyable[scrub='#']")
    private WebElement orderNum;

    @FindBy(xpath = "//main/div/div/div/div/div/div/div[2]/h3/satis-copyable")
    private WebElement orderNumNew;

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


    public Boxture_Purchase(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void new_purchase_Order() {
        newPurchaseOrder.click();
    }

    public void destination(String destinationLOcation) throws InterruptedException {

        this.wait.until(ExpectedConditions.visibilityOf(this.destination));
        this.destination.click();
        this.destination.clear();
        this.destination.sendKeys(destinationLOcation);
        Thread.sleep(3000);
    }

    public void product(String product) throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.product));
        this.product.click();
        this.product.sendKeys(product);
        Thread.sleep(3000);

    }

    public void createPurchase() throws InterruptedException {
        this.createButton.click();
        Thread.sleep(3000);
    }

    public void receive(String box, String prod) throws InterruptedException {
        Thread.sleep(6000);
        this.driver.navigate().refresh();
        this.driver.navigate().refresh();
        if (pending.isEnabled()) {
            System.out.println("inside pending");
            Actions act = new Actions(driver);
            act.moveToElement(mouseHover).perform();
            Thread.sleep(3000);
            this.receiveClick.click();
        }
        else if (confirming.isEnabled()) {
            this.driver.navigate().refresh();
            this.driver.navigate().refresh();
            Thread.sleep(3000);
            System.out.println("inside confirming");
            Actions act = new Actions(driver);
            act.moveToElement(mouseHover).perform();
            Thread.sleep(3000);
            this.receiveClick.click();


        }

        Thread.sleep(3000);
        this.packingMaterial.click();
        this.packingMaterial.clear();
        this.packingMaterial.sendKeys(box);
        Thread.sleep(2000);
        this.product.click();
        this.product.clear();
        this.product.sendKeys(prod);
        Thread.sleep(2000);
        this.finalReceive.click();
        Thread.sleep(2000);
        this.driver.navigate().refresh();
        this.wait.until(ExpectedConditions.visibilityOf(this.status));

    }


}
