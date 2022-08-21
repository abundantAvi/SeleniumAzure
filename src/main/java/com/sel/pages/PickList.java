package com.sel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PickList {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//div[@class='page page-current']//div[@class='item-title'][normalize-space()='All']")
    private WebElement clickAll;


    public PickList(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }


    public void pickAll() {
        this.wait.until(ExpectedConditions.visibilityOf(clickAll));
        this.clickAll.click();

    }

}
