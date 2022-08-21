import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Boxture_Sales {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "input[placeholder='Customer']")
    private WebElement customer;
    @FindBy(css = "input[placeholder='Product']")
    private WebElement product;
    @FindBy(css = "button[value='save']")
    private WebElement createButton;
    @FindBy(css = "satis-copyable[scrub='#']")
    private WebElement orderNum;
    @FindBy(css = "#confirm")
    private WebElement confirm;
    @FindBy(xpath = "(//*[name()='svg'][@class='svg-inline--fa fa-ellipsis-vertical'])[1]")
    private WebElement ellipsis;
    @FindBy(xpath = "//span[normalize-space()='Confirm']")
    private WebElement confirmOrder;
    @FindBy(xpath = "//dd[normalize-space()='confirming']")
    private WebElement confirming;
    @FindBy(xpath = "//dd[normalize-space()='processing']")
    private WebElement processing;
    @FindBy(xpath = "//ul[@class='z-10 bg-white dark:bg-gray-400 border dark:border-gray-800 rounded-md shadow-lg min-w-max']//li[1]")
    private WebElement verifyied;


    @FindBy(xpath = "//div[@data-controller='satis-tabs']//div//div//div//button[@type='button']//span")
    private WebElement mouseHover;
    @FindBy(xpath = "//span[normalize-space()='Pick']")
    private WebElement pickClick;



    @FindBy(xpath = "//a[@id='pick_lists']")
    private WebElement pick;

    @FindBy(xpath = "//body/div[@id='app']/div[@id='view']/div[@class='page page-current']/div[@class='page-content ptr-content']/div[@class='list']/ul/li[1]/a[1]/div[1]")
    private WebElement pickAll;
    @FindBy(xpath = "//body/div[@id='app']/div[@id='view']/div[1]/div[3]/div[3]/ul[1]/li[2]/a[1]/div[1]")
    private WebElement pickMyOrder;
    @FindBy(css = "div[class='page page-current'] li:nth-child(1) a:nth-child(1) div:nth-child(1) div:nth-child(2)")
    private WebElement scanLastOrder;

    @FindBy(xpath = "//div[@data-action='scan-barcode.resultFound->fetcher#fetch']//a[@id='scan_barcode']//*[name()='svg']")
    private WebElement toteScan;
    @FindBy(css = "div[class='swipeout-content'] div[class='item-inner']")
    private WebElement swipe;
    @FindBy(xpath = "//a[normalize-space()='Pick all']")
    private WebElement pickAllItems;
    @FindBy(xpath = "//main/div/div/div/div/div/div/div[2]/h3/satis-copyable")
    private WebElement orderNumNew;
//    @FindBy(xpath = "//td[normalize-space()='Order #+ "number"+']")
//    private WebElement picklistClick;

    @FindBy(css = "tr[class='cursor-pointer bg-white dark:bg-gray-800'] td:nth-child(2)")
    private WebElement pickListClick;
    @FindBy(css = "div[class='ml-4 mt-4 flex-shrink-0']")
    private WebElement pickLIstMouseHover;
    @FindBy(xpath = "//span[normalize-space()='Assign']")
    private WebElement assign;
    @FindBy(xpath = "//input[@placeholder='User']")
    private WebElement user;
    @FindBy(xpath = "//span[@title='translation missing: en.pick_lists.assigns.new.assign']")
    private WebElement assignFinalClick;


    public Boxture_Sales(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void customer(String customerName) throws InterruptedException {

        this.wait.until(ExpectedConditions.visibilityOf(this.customer));
        this.customer.click();
        this.customer.clear();
        this.customer.sendKeys(customerName);
        Thread.sleep(3000);
    }

    public void product(String product) throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.product));
        this.product.click();
        this.product.sendKeys(product);
        Thread.sleep(3000);

    }

    public void createSales() {
        this.createButton.click();
    }

    public String orderNumGenerated() {
//        SearchContext shadow = this.orderNum.getShadowRoot();
//        WebElement a = shadow.findElement(By.cssSelector("span"));
//        String k = a.getText().substring(1);
//        return k;

        String b = orderNumNew.getText();
        String[] k = b.split("#");
        String number = k[1].trim();
        return number;

    }


    public void confirmOrderClick() throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.ellipsis));
        this.ellipsis.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmOrder));
        this.confirmOrder.click();
//        for (int i = 0; i <= 5; i++) {
//            driver.navigate().refresh();
//            Thread.sleep(3000);
//        }
    }

    public void pickOnClick() throws InterruptedException {
        Thread.sleep(10000);

        for (int i = 0; i <= 4; i++) {
            if (confirming.isEnabled()) {
                for (int k = 0; k < 5; k++) {
                    this.driver.navigate().refresh();
                    Thread.sleep(5000);
                    System.out.println("inside confirming");
                }

                if (processing.isEnabled()) {
                    System.out.println("inside processing");
                    Actions act = new Actions(driver);
                    act.moveToElement(mouseHover).perform();
                    Thread.sleep(3000);
                    this.pickClick.click();
                    break;

                } else {
                    for (int k = 0; k < 3; k++) {
                        this.driver.navigate().refresh();
                        Thread.sleep(5000);
                        System.out.println("inside confirming");
                    }
                    if (processing.isEnabled()) {
                        System.out.println("inside processing");
                        Actions act = new Actions(driver);
                        act.moveToElement(mouseHover).perform();
                        this.pickClick.click();
                        Thread.sleep(5000);
                        break;

                    }
                }
            }

        }

//        Actions act = new Actions(driver);
//        act.moveToElement(mouseHover).perform();
        //this.wait.until(ExpectedConditions.visibilityOf(this.pickClick));


    }
    public void pickListClick() throws InterruptedException {
        Thread.sleep(5000);

        this.wait.until(ExpectedConditions.visibilityOf(this.processing));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", pick);
        this.pick.click();
        this.pickListClick.click();
        System.out.println("inside PICKLIST");
        Thread.sleep(3000);
        this.wait.until(ExpectedConditions.visibilityOf(this.pickLIstMouseHover));
        Actions act = new Actions(driver);
        act.moveToElement(pickLIstMouseHover).perform();
        Thread.sleep(3000);
        this.assign.click();
        Thread.sleep(3000);
        this.user.sendKeys("av");
        String a = user.getText();
        Thread.sleep(3000);
        System.out.println("Assigned Picker "+ a);
        this.assignFinalClick.click();
    }

    public void mobileWebsite() throws InterruptedException {
        driver.get("https://oms.staging.boxture.com/mobile");
        this.wait.until(ExpectedConditions.visibilityOf(this.pickAll));
        this.pickMyOrder.click();
        Thread.sleep(3000);
        this.wait.until(ExpectedConditions.elementToBeClickable(this.scanLastOrder));
        this.scanLastOrder.click();

    }

    public void scanTote(String tote) throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.toteScan));
        Thread.sleep(5000);
        this.toteScan.click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(tote);
        promptAlert.accept();
        Thread.sleep(5000);
        System.out.println("Scanned TOTE - " + tote);

    }

    public void pickAfterScan(){
        Actions action = new Actions(driver);
        this.wait.until(ExpectedConditions.visibilityOf(this.swipe));
        // ((JavascriptExecutor) driver).executeScript("scroll(0,600)");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", swipe);
        action.clickAndHold(swipe).moveByOffset(186, 21).release().perform();
        this.pickAllItems.click();
        System.out.println("Picked one item");

    }
}
