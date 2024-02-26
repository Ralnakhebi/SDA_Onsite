package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) throws InterruptedException {
    //System.setProperty("WebDriver.Chrome.driver","");

    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.google.com");

    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());

        //driver.manage().window().setSize(new Dimension(800,600));

    driver.get("https://www.amazon.com/");
    //System.out.println(driver.getPageSource());
    Thread.sleep(5000);

    driver.quit();

    }
}
