package HW.day06;

import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Challenge {


    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void tearDown (){
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");


        WebElement email =driver.findElement(By.id("email"));
        WebElement password =driver.findElement(By.id("password"));
        WebElement Submit =driver.findElement(By.id("submit"));

        Faker faker=new Faker();

        email.sendKeys("sda@sample.com");
        password.sendKeys("1122334");
        Submit.click();
        Thread.sleep(2000);

        Assert.assertNotEquals("User cann't sginIn !!",driver.getCurrentUrl(),
                "https://thinking-tester-contact-list.herokuapp.com/addUser");


        for(int i =0 ; i<3 ; i++) {
            WebElement addContactButton =driver.findElement(By.id("add-contact"));
            addContactButton.click();
            WebElement firstName = driver.findElement(By.id("firstName"));
            WebElement lastName = driver.findElement((By.id("lastName")));
            WebElement brithdate = driver.findElement(By.id("birthdate"));
            WebElement email1 = driver.findElement(By.id("email"));
            WebElement City =driver.findElement(By.id("city"));
            WebElement State = driver.findElement(By.id("stateProvince"));
            WebElement PostalCode = driver.findElement(By.id("postalCode"));
            WebElement Country = driver.findElement(By.id("country"));
            WebElement phone = driver.findElement(By.id("phone"));
            WebElement address1 = driver.findElement(By.xpath("//input[@id='street1']"));
            WebElement address2 = driver.findElement(By.xpath("//input[@id='street2']"));
            firstName.sendKeys(faker.name().firstName());
            lastName.sendKeys(faker.name().lastName());
            brithdate.sendKeys("2000-02-20");
            email1.sendKeys(faker.internet().emailAddress());
            phone.sendKeys("1122335175");
            address1.sendKeys(faker.address().streetAddress());
            address2.sendKeys(faker.address().streetAddress());

            City.sendKeys(faker.address().city());
            State.sendKeys(faker.address().state());
            PostalCode.sendKeys(faker.address().zipCode());
            Country.sendKeys(faker.address().country());

            WebElement sumbit = driver.findElement(By.xpath("//button[@id='submit']"));
            sumbit.click();
            Assert.assertNotEquals(driver.getCurrentUrl(),"https://thinking-tester-contact-list.herokuapp.com/addContact/");
            Thread.sleep(2000);
        }

        WebElement element =driver.findElement(By.xpath("//tr[@class='contactTableBodyRow'][1]"));

        deleteContactInfo(element);
    }
    public void deleteContactInfo(WebElement element) throws InterruptedException {
        String mainPage = driver.getCurrentUrl();
        element.click();
        WebElement deleteButton = driver.findElement(By.id("delete"));

        deleteButton.click();
        System.out.println("Message : " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),mainPage);
        Thread.sleep(1000);

    }
}
