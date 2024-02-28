package day06;

import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01JavaFakerClass {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        Faker faker=new Faker();
        String name = faker.name().fullName();
        String name2 = faker.name().fullName();
        System.out.println("faker.name() = " + name);
        System.out.println("faker.name() = " + name2);

        String phone = faker.phoneNumber().phoneNumber();
        System.out.println("phone = " + phone);

        String phone2 = faker.phoneNumber().phoneNumber();
        System.out.println("phone = " + phone2);

        String domainName = faker.internet().domainName();
        System.out.println("domainName = " + domainName);

        String password =faker.internet().password(6,10,true,true,false);
        System.out.println("password = " + password);


    }
}

