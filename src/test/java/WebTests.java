import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

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
        String driverPath = "C:/tools/chromeDriver/chromedriver_v105/chromedriver.exe";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();

        //1. Открыть вебсайт на базовой странице
        String url = "http://www.99-bottles-of-beer.net/";
        driver.get(url);

        //2. Считать заголовок в правом верхнем углу
        WebElement h1 = driver.findElement(By.xpath("//div[@id='header']/h1"));

        //3. Подтвердить, что текст заголовка соответствует ожидаемому
        String expectedResult = "99 Bottles of Beer";
        String actualResult = h1.getText();
        Assert.assertEquals(actualResult, expectedResult);


        //4. Закрыть браузер
        driver.quit();
        System.out.println("The end of test");

    }


    @Test
    public void testCheckLastMenuItem() {

        /**
         * TC_11_02 Подтвердите, что на странице по базовой ссылке последний пункт меню называется Submit new Language
         * Шаги:
         * 1. Открыть вебсайт на базовой странице
         * 2. Считать название последнего пункта меню
         * 3. Подтвердить, что название последнего пункта меню соответствует ожидаемому
         * 4. Закрыть браузер
         */
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/tools/chromeDriver/chromedriver_v105/chromedriver.exe";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "http://www.99-bottles-of-beer.net/";
        driver.get(url);
        //the LAST li element
        WebElement lastMenuItem = driver.findElement(By.xpath("//ul[@id='menu']/li[last()]"));
        String expectedResult = "Submit new Language";
        String actualResult = lastMenuItem.getText();

        Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        driver.quit();
    }

    @Test
    public void testCheckSubmitNewLanguageSubTitle() {
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
        String driverPath = "C:/tools/chromeDriver/chromedriver_v105/chromedriver.exe";
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

    }

    @Test
    public void testCheckFirstSubmenuOfBrowseLang() {

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
        String driverPath = "C:/tools/chromeDriver/chromedriver_v105/chromedriver.exe";
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
        String driverPath = "C:/tools/chromeDriver/chromedriver_v105/chromedriver.exe";
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

        String expectedresult1 = "Oliver Schade";
        String actualResult1 = oliver.getText();
        Assert.assertEquals(actualResult1, expectedresult1);

        String expectedresult2 = "Gregor Scheithauer";
        String actualResult2 = gregor.getText();
        Assert.assertEquals(actualResult2, expectedresult2);

        String expectedresult3 = "Stefan Scheler";
        String actualResult3 = stefan.getText();
        Assert.assertEquals(actualResult3, expectedresult3);

        driver.quit();

    }

    @Test
    public void testCheckErrorPage() {
        /**
         * TC_11_11 Подтвердите, что если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,  пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях, будет показана ошибка
         *
         * Error: Precondition failed - Incomplete Input.
         *
         * Шаги:
         * 1. Открыть вебсайт на странице
         * 2. Нажать на кнопку Submit Language
         * 3. Подтвердить, что на странице показана ошибка
         * 4. Подтвердить, что текст ошибки соответствует ожидаемому
         * 5. Закрыть браузер
         */
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/tools/chromeDriver/chromedriver_v105/chromedriver.exe";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        String url = "http://www.99-bottles-of-beer.net/";

        driver.get(url);
        WebElement submitNewLanguages = driver.findElement(By.xpath("//ul[@id='menu']/li/a[text()='Submit new Language']"));
        submitNewLanguages.click();

        WebElement submitLanguageBtn = driver.findElement(By.xpath("//input[@name='submitlanguage']"));
        submitLanguageBtn.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='main']/p"));

        String expectedResult = "Error: Precondition failed - Incomplete Input.";
        String actualResult = errorMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();


    }

    @Test
    public void testCheckErrorMessageWithEmptyFieldsInSubmitNewLanguage() {
        /**TC_11_12 Precondition: Если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,  пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях, будет показана ошибка с текстом

         Error: Precondition failed - Incomplete Input.

         Подтвертите, что в тексте ошибки слова Error, Precondition, Incomplete и Input написаны с большой буквы, а слово failed  написано  с маленькой буквы.
         Так же подтвердите, что в тексте ошибки содержатся знаки :, -  и .

         Шаги:
         1. Открыть вебсайт на странице
         2. Нажать на кнопку Submit Language
         3. Считать текст ошибки
         4. Подтвердить requirenments
         5. Закрыть браузер
         */

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/tools/chromeDriver/chromedriver_v105/chromedriver.exe";
        //Create driver
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        //maximize browser window
        driver.manage().window().maximize();
        //define base url
        String url = "http://www.99-bottles-of-beer.net";
        //go to url
        driver.get(url);
        //find element Submit Language and click on it
        WebElement submitNewLanguageMenu = driver.findElement(By.xpath("//ul[@id='menu']/li/a[text()='Submit new Language']"));
        submitNewLanguageMenu.click();
        //find element "Submit Language"button and click on it
        WebElement submitLanguageBtn = driver.findElement(By.xpath("//input[@name='submitlanguage']"));
        submitLanguageBtn.click();
        //find element with Error text
        WebElement errorText = driver.findElement(By.xpath("//div[@id='main']/p"));
        //set er and ar
        String expectedResult = "Error: Precondition failed - Incomplete Input.";
        String actualResult = errorText.getText();

        Assert.assertEquals(actualResult, expectedResult);


    }

}
