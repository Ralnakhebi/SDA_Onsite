package HW.day07;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task3 {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {

        //driver.quit();
    }

    @Test
    public void test() {
        //Task 3:
        //navigate to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        //click on "Click me, to Open an alert after 5 seconds" button
        WebElement button =driver.findElement(By.id("alert"));
        button.click();

        //click on accept alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();


        //click on "Change Text to Selenium Webdriver"
        WebElement button1 =driver.findElement(By.id("populate-text"));
        button1.click();
        //verify "Selenium Webdriver" message is displayed
        WebElement isChange =driver.findElement(By.id("h2"));

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.textToBePresentInElement(isChange,"Selenium Webdrive"));

        System.out.println("isChange content Now is: " + isChange.getText());
        Assert.assertTrue("message didn't change",isChange.getText().contains("Selenium Webdrive"));


        //6. click on "Display button after 10 seconds" button
        WebElement button2 = driver.findElement(By.id("display-other-button"));
        button2.click();

        //7. verify the button is displayed
        WebElement button3 = driver.findElement(By.id("hidden"));

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOf(button3));

        Assert.assertTrue("Button aren't Displayed",button3.isDisplayed());


        //8. click on "Enable button after 10 seconds" button
        WebElement button4 = driver.findElement(By.id("enable-button"));
        button4.click();

        WebElement button5 =driver.findElement(By.id("disable"));
        //9. verify the button is enabled
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait4.until(ExpectedConditions.elementToBeClickable(button5));

        boolean isClickable = button5.isEnabled();
        Assert.assertTrue(isClickable);

        //10. click on "Check Checkbox after 10 seconds" button
        WebElement checkboxButton = driver.findElement(By.id("checkbox"));
        checkboxButton.click();

        WebElement checkbox = driver.findElement(By.id("ch"));

        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait5.until(ExpectedConditions.elementToBeSelected(checkbox));

        //11. verify the check box is checked
        Assert.assertTrue("CheckBox is not selected yet .. ",checkbox.isSelected());


    }
}
