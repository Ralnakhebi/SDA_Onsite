package HW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05WindowsCommands03 {
    public static void main(String[] args) {
         /*
        Create main method
        Create chrome driver
        Open google home page: https://www.google.com
        Print Title on page
        Print Current URL on page
        Close/Quit the browser
        */

        WebDriver driver= new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        driver.quit();

        // Differences between get() method and navigate to() method?

        // while both methods serve the same purpose reaching to a specific URL,
        // get(): you cannot retrieve any information about the current page or handle any intermediate navigation steps.
        // navigate().to(): returns a Navigation object, allowing you to perform additional navigation actions such as navigating back
        // navigate().to(): it does not wait for the page to load completely before returning control to your script.
        // while get() waits for the page to load completely before returning control to your script.

        /*
        Invoke Chrome Driver
        Navigate to Facebook homepage URL: https://www.facebook.com/
        Verify expected URL equals to the actual URL.
        Verify  page source of FaceBook contains "Facebook" .
     */
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.facebook.com/");
        String expectedUrl = "https://www.facebook.com/";
        String actualUrl = driver1.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)){
            System.out.println("They are the same");
        } else {
            System.out.println("They are different");
        }

        String pageSource =driver1.getPageSource();
        boolean containsSubstring = pageSource.contains("Facebook");

        if (containsSubstring) {
            System.out.println("The pageSource contains the Facebook");
        } else {
            System.out.println("The pageSource does not contain the Facebook");
        }

        driver1.quit();
    }
}
