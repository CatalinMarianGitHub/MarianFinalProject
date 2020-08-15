import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class Methods extends SeleniumHelper {


    public Methods(String driver) {
        super(driver);
    }

    public Methods() {
    }


    public void lendBook() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        getElement("view_1").click();

        WebElement carte =driver.findElement(By.className("mat-line"));
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

    public void lendBook2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        getElement("//*[@id=\"books\"]").click();
        getElement("books").click();
        Thread.sleep(2000);
        getElement("view_200").click();
        Thread.sleep(1000);
        Select dropdown = new Select(driver.findElement(By.id("select_lender")));
        dropdown.selectByValue("CatalinMorariu_tester1");
        WebElement element = driver.findElement(By.id("lend_book"));
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }


    }
}