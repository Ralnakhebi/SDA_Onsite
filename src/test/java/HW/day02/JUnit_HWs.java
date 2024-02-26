package HW.day02;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JUnit_HWs {
    WebDriver driver;

    @BeforeClass
    public static void beforeClassTest(){
        System.out.println("beforeClassTest() is running");
        System.out.println("Test has started");
    }
    @AfterClass
    public static void afterClassTest(){
        System.out.println("afterClassTest() is running");
        System.out.println("Test finished");
    }
    @Before
    public void beforeTest(){
        System.out.println("beforeTest() is running");
        driver =new ChromeDriver();
        System.out.println("Before test create new Chrome driver");
        System.out.println("Test is running");
        System.out.println("Tests are starting to run");
        System.out.println("STARTED");

    }
    @After
    public void afterTest(){
        System.out.println("afterTest() is running");
        driver.quit();
        System.out.println("After test close driver");
        System.out.println("Test finished");
        System.out.println("Tests have finished running");
        System.out.println("FINISHED");
    }
    @Test
    public void testCase01(){
        System.out.println("testCase01() is running");
        // Invoke Chrome Browser
        //it will be created in beforeTest() method ..

        // Navigate to URL: https://www.w3schools.com/
        driver.get("https://www.w3schools.com/");
        System.out.println("driver.getTitle().toString() = " + driver.getTitle());
        // Navigate to URL: https://stackoverflow.com/
        driver.navigate().to("https://stackoverflow.com/");
        System.out.println("driver.getTitle().toString() = " + driver.getTitle());
        // Come back to the w3schools using the back command.
        driver.navigate().back();
        System.out.println("driver.getTitle().toString() = " + driver.getTitle());
        // Again go back to the stackoverflow website using forward command
        driver.navigate().forward();
        System.out.println("driver.getTitle().toString() = " + driver.getTitle());
        // Refresh the Browser using refresh command.
        //wait 2 Second before refresh the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //refresh the page
        driver.navigate().refresh();
        System.out.println("driver.getTitle().toString() = " + driver.getTitle());
        // Close the Browser.
        // Closed by afterTest() method ..



    }

    @Test
    public void testCase02() throws InterruptedException {
        System.out.println("testCase02() is running");
        //it will be created in beforeTest() method ..

        // Go to www.yahoo.com
        driver.navigate().to("https://de.yahoo.com/?p=us");
        // Maximize Window
        driver.manage().window().maximize();
        String yahooTitle= driver.getTitle();
        System.out.println("yahooTitle = " + yahooTitle);
        boolean Test1= yahooTitle.contains("Yahoo");
        if (Test1){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }
        // Go to www.amazon.com
        Thread.sleep(1000);
        String amazonUrl= "https://www.amazon.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.navigate().to(amazonUrl);

        String amazonTitle= driver.getTitle();
        System.out.println("amazonTitle.toString() = " + amazonTitle);
        boolean Test2= amazonTitle.contains("Amazon");
        if (Test2){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }
        // Maximize Window
        driver.manage().window().maximize();
        // Navigate Back
        //Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.navigate().back();
        String yahooTitle2= driver.getTitle();
        boolean Test3= yahooTitle2.contains("Yahoo");
        if (Test3){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }
        // Navigate Forward
        //Thread.sleep(1000); or
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.navigate().forward();
        String amazonTitle2= driver.getTitle();
        boolean Test4= amazonTitle2.contains("Amazon");
        if (Test4){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }
        // Refresh The Page
        // Thread.sleep(1000);or
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.navigate().refresh();

    }
    @Test
    public void testCase03(){
        System.out.println("testCase03() is running");
        // Expected Title
        String ExpectedTitle="Online IT Bootcamp; Learn Coding, " +
                "Data Science, AWS, DevOps, " +
                "Cyber Security & Salesforce";
        // Set Path of the Chrome driver

        String url="https://clarusway.com";
        // Launch Chrome browser
        //it will be created in beforeTest() method ..
        // Open URL of Website
        driver.get(url);
        // Maximize Window
        driver.manage().window().maximize();
        // Get Title of current Page
        String currentTitle=driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);
        // Validate/Compare Page Title
        if (currentTitle.equals(ExpectedTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        // Close Browser
        // Closed by afterTest() method ..



    }
    @Test
    public void testCase04(){
        System.out.println("testCase04() is running");
        // Go to the w3school URL : https://www.w3schools.com/
        driver.get("https://www.w3schools.com/");
        // Print the position and size of the page.
        Point positionOfThePage =driver.manage().window().getPosition();
        Dimension sizeOfThePage =driver.manage().window().getSize();
        System.out.println("sizeOfThePage = " + sizeOfThePage);
        System.out.println("positionOfThePage = " + positionOfThePage);


        // Adjust the position and size of the page as desired.
        driver.manage().window().setSize(new Dimension(1554,882));
        driver.manage().window().setPosition(new Point(8,8));

        // Test that the page is in the position and size you want.
        Point positionOfThePage1 =driver.manage().window().getPosition();
        Dimension sizeOfThePage1 =driver.manage().window().getSize();
        System.out.println("sizeOfThePage = " + sizeOfThePage1);
        System.out.println("positionOfThePage = " + positionOfThePage1);
        //
        // Close the page.
        // Closed by afterTest() method ..


    }
    @Test
    public void testCase05() throws InterruptedException {
        System.out.println("testCase05() is running");
        // Invoke Chrome Browser
        //it will be created in beforeTest() method ..

        // Open URL: https: https://www.w3schools.com/
        String w3schoolUrl="https://www.w3schools.com/";
        driver.get(w3schoolUrl);
        // Maximize the window.
        driver.manage().window().maximize();
        // Print the position and size of the page.
        Point positionOfThePage =driver.manage().window().getPosition();
        Dimension sizeOfThePage =driver.manage().window().getSize();
        System.out.println("sizeOfThePage = " + sizeOfThePage);
        System.out.println("positionOfThePage = " + positionOfThePage);
        // Minimize the page.
        driver.manage().window().minimize();
        // Wait 7 seconds in the icon state and maximize the page.
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        Thread.sleep(7000);
        driver.manage().window().maximize();
        // Print the position and dimensions of the page in maximized state.
        Point positionOfThePage1 =driver.manage().window().getPosition();
        Dimension sizeOfThePage1 =driver.manage().window().getSize();
        System.out.println("sizeOfThePage = " + sizeOfThePage1);
        System.out.println("positionOfThePage = " + positionOfThePage1);
        // Make the page fullscreen.
        driver.manage().window().fullscreen();
        // Close the Browser.



    }
    @Test
    public void testCase06(){
        System.out.println("testCase06() is running");
        // Invoke FireFox Driver
        //it will be created in beforeTest() method ..
        // Go to https://www.youtube.com/
        String youtubeUrl="https://www.youtube.com/";
        driver.get(youtubeUrl);
        // Maximize the window
        driver.manage().window().maximize();
        // Verify the page title contains the word video.
        String youtubePageTitle = driver.getTitle();
        System.out.println("youtubePageTitle = " + youtubePageTitle);
        if(youtubePageTitle.contains("video")){
            System.out.println("Title page contains \"video\"");
        }else {
            System.out.println("Title page doesn't contains \"video\"");
        }
        // Minimize the window
        driver.manage().window().minimize();
        // Verify the page title contains the word video.
        String youtubePageTitle1 = driver.getTitle();
        if(youtubePageTitle1.contains("video")){
            System.out.println("Title page contains \"video\"");
        }else {
            System.out.println("Title page doesn't contains \"video\"");
        }
        // Make the page fullscreen
        driver.manage().window().fullscreen();
        // Close the driver.
        // Closed by afterTest() method ..

    }
    @Test
    public void testCase07(){
        System.out.println("testCase07() is running");
        // Go to YouTube homepage
        String youtubeUrl="https://www.youtube.com/";
        driver.get(youtubeUrl);
        // Do the following tasks by creating 4 different test methods.
        //*- Print "Test is running" before each test() method
        //beforeTest();
        //*- Print "Test finished" after each test() method
        //afterTest();
        // Test if the currentURL contains "youtube"
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("youtube")){
            System.out.println("currentURL contains \"youtube\"");
        }else{
            System.out.println("currentURL doesn't contains \"youtube\"");
        }
        // Test if the title does not contain "Video".
        String currentTitle = driver.getTitle();
        if(currentTitle.contains("Video")){
            System.out.println("current Title contains \"Video\"");
        }else{
            System.out.println("current Title doesn't contains \"Video\"");
        }
        // Test if the URL contains "youtube".
        if(youtubeUrl.contains("youtube")) {
            System.out.println("youtube Url contains \"youtube\"");
        }else{
            System.out.println("youtube Url doesn't contains \"youtube\"");
        }
        // Test if the sourcePage contains "youtube".
        String youtubeSourcePage=driver.getPageSource();
        if(youtubeSourcePage.contains("youtube")) {
            System.out.println("youtube SourcePage contains \"youtube\"");
        }else{
            System.out.println("youtube Source Page doesn't contains \"youtube\"");
        }



    }
    @Test
    public void testCase08(){
        System.out.println("testCase08() is running");
        // Go to google homepage
        String googleUrl = "https://google.com";
        driver.get(googleUrl);
        // Do the following tasks by creating 3 different test methods.
        //*- Print "Tests are starting to run" before each test() method
        //beforeTest();
        //*- Print "Tests have finished running" after each test() method
        //AfterTest();
        // Test if the title is the same when the page window is maximize and minimize
        driver.manage().window().maximize();
        String pageTitleMax = driver.getTitle();
        driver.manage().window().minimize();
        String pageTitleMin= driver.getTitle();
        if(pageTitleMax.equals(pageTitleMin)){
            System.out.println("Title is the same when the page window is maximize and minimize");
        }else {
            System.out.println("Title is not the same when the page window is maximize and minimize");
        }

        // Test if the title does not contain "Video" when the page window is fullscreen
        driver.manage().window().fullscreen();
        String pageTitle = driver.getTitle();
        if (pageTitle.contains("Video")){
            System.out.println("Title does contains \"Video\" word");
        }else {
            System.out.println("Title doesn't contains \"Video\" word");
        }
        // Test if the URL contains "google"
        String pageUrl = driver.getCurrentUrl();
        if (pageUrl.contains("google")){
            System.out.println("the URL contains \"google\"");
        }else {
            System.out.println("the URL doesn't contains \"google\"");
        }


    }
    @Test
    public void testCase09(){
        System.out.println("testCase09() is running");
        // Go to w3school homepage
        String w3schoolUrl="https://www.w3schools.com/";
        driver.get(w3schoolUrl);

        // Do the following tasks by creating 3 different test methods.
        //*- Print "STARTED" before all test() methods run
        //In beforeTest(); method
        //*- Print "FINISHED" after all test() methods run.
        // In afterTest(); method
        //*- Before all test() methods run, print "Test has started"
        //In beforeClassTest() method
        //*- Print "method name + running" in all test methods
        //*- After all test() methods run, print "Test finished"
        // In afterClassTest() method

        // Test if the title contains "w3school" when the page window is minimize
        driver.manage().window().minimize();
        String w3schoolTitle= driver.getTitle();
        //I used toLowerCase() to simplify the comparison
        if (w3schoolTitle.toLowerCase().contains("w3school")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        // Test if the title does not contain "boss" when the page window is fullscreen
        driver.manage().window().fullscreen();
        String w3schoolTitle1= driver.getTitle();
        if (!(w3schoolTitle1.toLowerCase().contains("boss"))){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }


    }

    @Test
    public void testCase10(){
        System.out.println("testCase10() is running");

        // Go to Automation Exercises homepage
        String automationExercisesUrl="https://automationexercise.com/";
        driver.get(automationExercisesUrl);
        // Find the locators of the relevant areas and click on them
        // https://automationexercise.com/
        // Task 01 --> " Home "
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]"));
        // Task 02 --> " Products "
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Task 03 --> " Cart "
        //driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]"));
        // Task 04 --> " Signup / Login "
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]"));
        // Task 05 --> " Test Cases "
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]"));
        // Task 06 --> " API Testing "
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[6]"));
        // Task 07 --> " Video Tutorials "
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[7]/a"));
        // Task 08 --> " Contact us "
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a"));

        //Extra
        driver.findElement(By.partialLinkText("Video Tutorials")).click();
        List<WebElement> webElement=driver.findElements(By.tagName("head"));
        System.out.println("webElement.size() = " + webElement.size());


    }
}
