package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02BrowserControlCommands {
    public static void main(String[] args) {
          /*
    Selenium automates browsers. That's it!
    What you do with that power is entirely up to you.
     */
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com");

        //If we want to open a website with a driver, we use the get() method of our driver object.

        // BROWSER CONTROL COMMANDS

        //getTitle() returns the title of the current tab. It returns a String.
        String title = driver.getTitle();
        System.out.println("Title: "+title);

        //getCurrentURL() returns the URL of the current tab. It returns a String.
        String currentUrl= driver.getCurrentUrl();
        System.out.println("Url: "+currentUrl);

        // getPageSource() retrieves the source HTML code of the current page. It returns a String.
        String pageSource= driver.getPageSource();
        System.out.println("PageSource: "+pageSource);
        // close() closes the current tab. If it's the only tab open, it also closes the browser.
        driver.close();

        // quit() closes all tabs and the browser.
        driver.quit();
    }
}
