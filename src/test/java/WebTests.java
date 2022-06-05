import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebTests {
    @Test
    public void testCheckH1() {
        /**
         * TC_11_01 Подтвердите, что на странице по базовой ссылке в правом верхнем углу пользователь видит заголовок 99 Bottles of Beer
         * Шаги:
         * 1. Открыть вебсайт на базовой странице
         * 2. Считать заголовок в правом верхнем углу
         * 3. Подтвердить, что текст заголовка соответствует ожидаемому
         * 4. Закрыть браузер
         */
        System.out.println("'Check H1' test is started.");
        //Create driver
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/tools/chromeDriver/chromedriver_v102/chromedriver.exe";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();

        //1. Открыть вебсайт на базовой странице
        String url = "http://www.99-bottles-of-beer.net/";
        driver.get(url);
        System.out.println("Page is opened.");

        //2. Считать заголовок в правом верхнем углу
        WebElement h1 = driver.findElement(By.xpath("//div[@id='header']/h1"));

        //3. Подтвердить, что текст заголовка соответствует ожидаемому
        String expectedResult = "99 Bottles of Beer";
        String actualResult = h1.getText();
        Assert.assertEquals(actualResult, expectedResult);


        //4. Закрыть браузер
        driver.quit();
        System.out.println("Page is closed.");
        System.out.println("The end of test");

    }


    @Test
    public void testCheckLastMenuItem() {
        System.out.println("'CheckLastMenuItem' test is started.");
        /**
         * TC_11_02 Подтвердите, что на странице по базовой ссылке последний пункт меню называется Submit new Language
         * Шаги:
         * 1. Открыть вебсайт на базовой странице
         * 2. Считать название последнего пункта меню
         * 3. Подтвердить, что название последнего пункта меню соответствует ожидаемому
         * 4. Закрыть браузер
         */
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/tools/chromeDriver/chromedriver_v102/chromedriver.exe";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        String url = "http://www.99-bottles-of-beer.net/";
        driver.get(url);
        WebElement lastMenuItem = driver.findElement(By.xpath("//ul[@id='menu']/li/a[text()='Submit new Language']"));
        String expectedResult = "SUBMIT NEW LANGUAGE";
        String actualResult = lastMenuItem.getText();
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
        System.out.println("The end of test.");
    }

    @Test
    public void testCheckSubmitNewLanguageSubTitle() {
        System.out.println("'CheckSubmitNewLanguageSubTitle' test is started.");
        /**
         * TC_11_03 Подтвердите, что на странице по базовой ссылке последний пункт меню имеет подзаголовок Submit new Language
         *
         * Шаги:
         * 1. Открыть вебсайт на базовой странице
         * 2. Нажать на пункт меню Submit new Language
         * 3. Считать название подзаголовка последнего пункта меню
         * 4. Подтвердить, что название подзаголовка последнего пункта меню соответствует ожидаемому
         * 5. Закрыть браузер
         */
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/tools/chromeDriver/chromedriver_v102/chromedriver.exe";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        String url = "http://www.99-bottles-of-beer.net/";

        driver.get(url);
        WebElement submitNewLanguageMenu = driver.findElement(By.xpath("//ul[@id='menu']/li/a[text()='Submit new Language']"));
        submitNewLanguageMenu.click();

        WebElement submitNewLanguageSubmenu = driver.findElement(By.xpath("//ul[@id='submenu']/li/a[text()='Submit New Language']"));
        String actualResult = submitNewLanguageSubmenu.getText();
        String expectedResult = "Submit New Language";

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
        System.out.println("The end of test.");


    }


}
