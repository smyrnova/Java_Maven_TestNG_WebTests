import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;


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

        driver.manage().window().maximize();

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

        driver.manage().window().maximize();

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

    @Test
    public void testCheckFirstSubmenuOfBrowseLang() {
        System.out.println("'CheckFirstSubmenuOfBrowseLang' test is started.");
        /**
         * TC_11_04 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/abc.html , первый пункт подменю называется 0-9
         *
         * Шаги:
         * 1. Открыть вебсайт на странице
         * 2. Считать название первого подзаголовка
         * 3. Подтвердить, что название подменю соответствует ожидаемому
         * 4. Закрыть браузер
         */
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/tools/chromeDriver/chromedriver_v102/chromedriver.exe";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "http://www.99-bottles-of-beer.net/abc.html";

        driver.get(url);

        WebElement subMenu = driver.findElement(By.xpath("//ul[@id='submenu']/li/a[text()='0-9']"));
        String expectedresult = "0-9";
        String actualResult = subMenu.getText();

        Assert.assertEquals(actualResult, expectedresult);

        driver.quit();
        System.out.println("The end of test.");
    }


    @Test
    public void testCheckNamesSiteOwners() {
        /**
         * TC_11_06 Подтвердите, что имена создателей сайта:
         * Oliver Schade
         * Gregor Scheithauer
         * Stefan Scheler
         *
         * Шаги:
         * 1.Открыть сайт на главной
         * 2.Перейти в субменю Team
         * 3.Подтвердить, имена создателей.
         * 4.Закрыть браузер
         */
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/tools/chromeDriver/chromedriver_v102/chromedriver.exe";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "http://www.99-bottles-of-beer.net/";

        driver.get(url);

        WebElement teamSubmenu = driver.findElement(By.xpath("//ul[@id='submenu']/li/a[text()='Team']"));
        teamSubmenu.click();

        WebElement oliver = driver.findElement(By.xpath("//div[@id='main']/h3[text()='Oliver Schade']"));
        WebElement gregor = driver.findElement(By.xpath("//div[@id='main']/h3[text()='Gregor Scheithauer']"));
        WebElement stefan = driver.findElement(By.xpath("//div[@id='main']/h3[text()='Stefan Scheler']"));

        String expectedresult = "Oliver Schade";
        String actualResult = oliver.getText();
        Assert.assertEquals(actualResult, expectedresult);

        expectedresult = "Gregor Scheithauer";
        actualResult = gregor.getText();
        Assert.assertEquals(actualResult, expectedresult);

        expectedresult = "Stefan Scheler";
        actualResult = stefan.getText();
        Assert.assertEquals(actualResult, expectedresult);

        driver.quit();
        System.out.println("The end of test.");

    }

}
