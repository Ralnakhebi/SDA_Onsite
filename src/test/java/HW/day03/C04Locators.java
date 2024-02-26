package HW.day03;

import org.checkerframework.checker.units.qual.K;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04Locators {
    static WebDriver drive;
    WebElement searchBox;
    @BeforeClass
    public  static void SetUp(){
        drive=new ChromeDriver();
        drive.get("https://www.google.com");
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        drive.manage().window().maximize();
    }
    @AfterClass
    public static void tearDown(){
        drive.quit();
    }
    @Test
    public void Task1() {
        //task01:
        //Create the driver with BeforeClass and make it static inside the class.
        //Go to http://www.google.com
        //Type "Green Mile" in the search box and print the number of results.
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement searchBox=drive.findElement(By.name("q"));
        searchBox.sendKeys("Green Mile",Keys.ENTER);
        WebElement result =drive.findElement(By.id("result-stats"));
        System.out.println("result Number for Green Mile search are = " + result.getText());

        //Type "Premonition" in the search box and print the number of results.
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement searchBox2 = drive.findElement(By.id("APjFqb"));
        searchBox2.clear();
        searchBox2.sendKeys("Premonition",Keys.ENTER);
        WebElement result2=drive.findElement(By.id("result-stats"));
        System.out.println("result Number for Premonition search are = " + result2.getText());


        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement searchBox3 = drive.findElement(By.id("APjFqb"));
        searchBox3.clear();
        searchBox3.sendKeys("The Curious Case of Benjamin Button",Keys.ENTER);
        WebElement result3=drive.findElement(By.id("result-stats"));

        System.out.println("result Number for The Curious Case of Benjamin Button search are = " + result3.getText());

        ////Close with AfterClass.
    }
    @Test
    public void task2() throws InterruptedException {
        //task02:
        //Navigate to website  https://testpages.herokuapp.com/styled/index.html
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        drive.get("https://testpages.herokuapp.com/styled/index.html");

        //Under the Examples
        //Click on Locators - Find By Playground Test Page
        WebElement element1=drive.findElement(By.id("findbytest"));
        WebElement element1ByPartialLinkText=drive.findElement(By.partialLinkText("Locators - Find"));
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        element1.click();
        //Print the URL
        System.out.println("drive.getCurrentUrl() = " + drive.getCurrentUrl());
        //Navigate back
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        drive.navigate().back();
        //Print the URL
        System.out.println("drive.getCurrentUrl() = " + drive.getCurrentUrl());
        //Click on WebDriver Example Page
        WebElement element2 = drive.findElement(By.id("webdriverexamplepage"));
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        element2.click();
        //Print the URL
        System.out.println("drive.getCurrentUrl() = " + drive.getCurrentUrl());
        //Enter value 🡪 20 and Enter to "Enter Some Numbers inputBox"
        WebElement element3= drive.findElement(By.id("numentry"));
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        element3.sendKeys("20", Keys.ENTER);
        //And then verify ‘two, zero’ message is displayed on page
        WebElement message=drive.findElement(By.id("message"));
        //we can ensure that message are been display with isDisplayed() and assertEquals()

        //to make sure that content of the message is ‘two, zero’ ..
        boolean isMessageDisplayed = message.isDisplayed();
        //System.out.println("element4.isDisplayed() = " + element4.isDisplayed());
        Assert.assertTrue("Message is not displayed",isMessageDisplayed);
        Thread.sleep(2000);
        //Close driver.
    }
    @Test
    public void task3() {
        //Task 3:
        //Go to https://id.heroku.com/login.
        drive.get("https://id.heroku.com/login");
        //Enter an e-mail address.
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement field=drive.findElement(By.id("email"));// //input[@id='email']
        field.sendKeys("Ralnakhebi@outlook.com");
        //Enter a password.
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement field2=drive.findElement(By.xpath("//input[@id='password']"));// //input[@id='password']
        field2.sendKeys("112233", Keys.ENTER);
        //Click on the Login button.
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement Button=drive.findElement(By.name("commit"));// //button[@name='commit']
        Button.click();
        String ExpectedUrl="https://id.heroku.com/login";
        //Assert.assertNotEquals("Registration Failed",drive.getCurrentUrl(),ExpectedUrl);

        //There was a problem with your login.
        //If text is visible, print "Registration Failed".
        //If the text is not visible, print "Registered".
        //Close all pages.
    }
    @Test
    public void task4() {
        //Task 4:
        //Navigate to https://testpages.herokuapp.com/styled/index.html
        drive.get("https://testpages.herokuapp.com/styled/index.html");
        //Click on Simple Calculator under Micro Apps.
        drive.findElement(By.xpath("//a[@href='calculator']")).click();
        //Type any number in the first input.
        drive.findElement(By.id("number1")).sendKeys("98");
        //Type any number in the second input.
        drive.findElement(By.id("number2")).sendKeys("5");
        //Click on Calculate.
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        drive.findElement(By.id("calculate")).click();
        //Get the result.
        String result = drive.findElement(By.id("answer")).getText();
        //Print the result.
        System.out.println("result = " + result);
        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals("103",result);
    }
    @Test
    public void task5(){
        //Go to URL: https://www.linkedin.com/
        drive.get("https://www.linkedin.com/");
        //Locate the "Email or phone", "password", "Sign in" button using absolute xpath and relative xpath.
        //absolute path
        WebElement EmailAbslutePath = drive.findElement(
                By.xpath("html/body/main/section/div/div/form/div/div/div/div/input[@id='session_key']"));
        //relative path
        WebElement EmailRelativePath =drive.findElement(
                By.xpath("//*[@id='session_key']"));
        //absolute path
        WebElement PasswordAbslutePath =drive.findElement(
                By.xpath("html/body/main/section/div/div/form/div/div/div/div/input[@id='session_password']"));
        //relative path
        WebElement PasswordRelativePath = drive.findElement(
                By.xpath("//*[@id='session_password']"));
        //absolute path
        WebElement ButtonRelativePath =drive.findElement(
                By.xpath("html/body/main/section/div/div/form/div/button[@data-id='sign-in-form__submit-btn']"));
        //relative path
        WebElement ButtonAbslutePath = drive.findElement(By.xpath("//*[@data-id='sign-in-form__submit-btn']"));


    }

}
