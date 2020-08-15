import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class SeleniumHelper {
    public WebDriver driver;

    public SeleniumHelper(String browser) {
        switch (browser) {
            case "chrome":
                System.out.println("---CREATING NEW CHROME DRIVER INSTANCE---");
                System.setProperty("webdriver.chrome.driver",
                        "D:/qa automation/Utils/ChromeDriver/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        driver.manage().window().maximize();
    }

    public SeleniumHelper() {

    }

    public void navigateToURL(String applicationURL) {
        driver.get(applicationURL);
    }

    public WebElement getElement(String locator) {
        if (locator.startsWith("//")) {
            return driver.findElement(By.xpath(locator));
        } else {
            return driver.findElement(By.id(locator));
        }

    }

    public void loginInApplication(String emailCreated, String loginPassword) throws InterruptedException {

        WebElement loginButton = getElement("login");
        highLighterMethod(driver, loginButton);
        Thread.sleep(2000);
        getElement("login").click();
        WebElement loginUser = getElement("login_email");
        highLighterMethod(driver, loginUser);
        Thread.sleep(2000);
        getElement("login_email").sendKeys(emailCreated);
        WebElement loginPsw = getElement("login_password");
        highLighterMethod(driver, loginPsw);
        Thread.sleep(2000);
        getElement("login_password").sendKeys(loginPassword);
        Thread.sleep(2000);

        WebElement logClick = driver.findElement(By.xpath("//*[@type='submit']"));
        highLighterMethod(driver, logClick);
        logClick.click();

    }

    public void verifyUserHasLoggedIn() throws InterruptedException {
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.id("books")).isDisplayed());
    }

    public static void highLighterMethod(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: powderblue; border: 10px solid red;');", element);
    }

    public void lendBook_SHelper() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        getElement("view_200").click();
        WebElement carte = driver.findElement(By.className("mat-line"));
        carte.click();
        Thread.sleep(1000);
        Select dropdown = new Select(driver.findElement(By.id("select_lender")));
        dropdown.selectByVisibleText(" MarianP_tester1 ");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("lend_book")));
        element.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void create_EMPTYBook_Method_SEHelper() throws InterruptedException {
        Thread.sleep(2000);
        Select dropdown = new Select(driver.findElement(By.id("select_authors")));
        dropdown.selectByVisibleText("George COSBUC");
        getElement("create_book").click();
    }

    public void deletedBook_SeleniumHelper() throws InterruptedException {
        getElement("delete_200").click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void editBook_SHelper() throws InterruptedException {
        getElement("edit_200").click();
        Thread.sleep(2000);
        getElement("edit_name").sendKeys("Second Book Edited");
        getElement("edit_total").sendKeys("11");
        getElement("update_book").click();
    }


}
