package HW.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.JScriptUtilities;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task3 extends TestBase {
    @Test
    public void test() throws IOException, InterruptedException {
        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //Login page valid credentials.
        By nameField = By.name("username");
        By passField = By.name("password");
        By PIM =By.xpath("//li[@class='oxd-main-menu-item-wrapper'][2]");
        By configbtn = By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent']");
        By dataIm =By.xpath("//a[normalize-space()='Data Import']");
        By download =By.xpath("//a[@class='download-link']");
        String user = System.getProperty("user.home");
        String separator =System.getProperty("file.separator");
        String path=user+separator+"Downloads"+ separator+"importData.csv";

        WebElement pass =driver.findElement(passField);
        WebElement name = driver.findElement(nameField);

        name.sendKeys("Admin");
        pass.sendKeys("admin123"+ Keys.ENTER);
        WebElement PIMButton =driver.findElement(PIM);
        //Click PIM on the left side bar
        PIMButton.click();
        //Click Configuration and select Data Import
        WebElement config = driver.findElement(configbtn);
        config.click();
        WebElement DataImport = driver.findElement(dataIm);
        DataImport.click();
        //Download sample CSV file.
        WebElement downloadFile =driver.findElement(download);
        //Verify if the file downloaded successfully.

        Files.deleteIfExists(Path.of(path));
        downloadFile.click();
        Thread.sleep(1000);
        boolean exists = Files.exists(Path.of(path));
        Assert.assertTrue(exists);
        Files.deleteIfExists(Path.of(path));

    }
}
