import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class WebTests {

    private static final String BASE_URL = "http://www.99-bottles-of-beer.net/";
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "C:/tools/chromeDriver/chromedriver_v105/chromedriver.exe";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    private void setUpDriver(){
        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    private void closeBrowser(){
        driver.quit();
    }

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
        driver.get(BASE_URL);

        WebElement h1 = driver.findElement(By.xpath("//div[@id='header']/h1"));

        Assert.assertEquals(h1.getText(), "99 Bottles of Beer");
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
        driver.get(BASE_URL);

        WebElement lastMenuItem = driver.findElement(By.xpath("//ul[@id='menu']/li[last()]"));

        Assert.assertEquals(lastMenuItem.getText(), "Submit new Language".toUpperCase());
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
        driver.get(BASE_URL);

        WebElement submitNewLanguageMenu = driver.findElement(By.xpath("//ul[@id='menu']/li/a[text()='Submit new Language']"));
        submitNewLanguageMenu.click();

        WebElement submitNewLanguageSubmenu = driver.findElement(By.xpath("//ul[@id='submenu']/li/a[text()='Submit New Language']"));

        Assert.assertEquals(submitNewLanguageSubmenu.getText(), "Submit New Language");
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
        driver.get("http://www.99-bottles-of-beer.net/abc.html");

        WebElement subMenu = driver.findElement(By.xpath("//ul[@id='submenu']/li/a[text()='0-9']"));

        Assert.assertEquals(subMenu.getText(), "0-9");
    }

    @Test
    public void testCheckNamesSiteOwners() {

         /** TC_11_06 Подтвердите, что имена создателей сайта:
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
        driver.get(BASE_URL);

        driver.findElement(By.xpath("//ul[@id='submenu']/li/a[text()='Team']")).click();

        WebElement oliver = driver.findElement(By.xpath("//div[@id='main']/h3[text()='Oliver Schade']"));
        WebElement gregor = driver.findElement(By.xpath("//div[@id='main']/h3[text()='Gregor Scheithauer']"));
        WebElement stefan = driver.findElement(By.xpath("//div[@id='main']/h3[text()='Stefan Scheler']"));

        Assert.assertEquals(oliver.getText(), "Oliver Schade");
        Assert.assertEquals(gregor.getText(), "Gregor Scheithauer");
        Assert.assertEquals(stefan.getText(), "Stefan Scheler");
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
        driver.get(BASE_URL);

        WebElement submitNewLanguages = driver.findElement(By.xpath("//ul[@id='menu']/li/a[text()='Submit new Language']"));
        submitNewLanguages.click();

        WebElement submitLanguageBtn = driver.findElement(By.xpath("//input[@name='submitlanguage']"));
        submitLanguageBtn.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='main']/p"));

        String expectedResult = "Error: Precondition failed - Incomplete Input.";
        String actualResult = errorMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCheckErrorMessageWithEmptyFieldsInSubmitNewLanguage() {
        /**TC_11_12 Precondition: Если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
         *  пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях, будет показана
         *  ошибка с текстом

         Error: Precondition failed - Incomplete Input.

         Подтвертите, что в тексте ошибки слова Error, Precondition, Incomplete и Input написаны с большой буквы,
         а слово failed  написано  с маленькой буквы.
         Так же подтвердите, что в тексте ошибки содержатся знаки :, -  и .

         Шаги:
         1. Открыть вебсайт на странице
         2. Нажать на кнопку Submit Language
         3. Считать текст ошибки
         4. Подтвердить requirenments
         5. Закрыть браузер
         */
        driver.get(BASE_URL);
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

    @Test
    public void testTC_11_13 () {
        /**TC_11_13 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html в
         *  первом пункте списка пользователь видит текст

         IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and
         description), the easier it will be for us and the faster your language will show up on this page.
         We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.

         Шаги:
         1. Открыть вебсайт на странице
         2. Считать текст
         3. Подтвердить, что текст соответствует ожидаемому
         4. Закрыть браузер
         */
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        driver.get(url);
        WebElement message = driver.findElement(By.xpath("//div[@id='main']/ul/li[1]"));
        String expectedResult = "IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description), the easier it will be for us and the faster your language will show up on this page. We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.";
        String actualResult = message.getText();
        System.out.println(message.getText());

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testTC_11_14 () {
        /**
         * TC_11_14 Подтвердите, что нажав на пункт меню Browse Languages, пользователь увидит таблицу со следующими названиями для первого и второго столбцов:
         * Language
         * Author
         *
         * Шаги:
         * 1. Открыть вебсайт на базовой странице
         * 2. Нажать на пункт меню Browse Languages
         * 3. Считать названия первого и второго столбцов таблицы
         * 3. Подтвердить, что названия соответствует ожидаемым
         * 4. Закрыть браузер
         */
        driver.get(BASE_URL);

        WebElement menu = driver.findElement(By.xpath("//ul[@id='menu']/li/a[text()='Browse Languages']"));
        menu.click();

        WebElement firstColumn = driver.findElement(By.xpath("//table[@id='category']/tbody/tr/th[1]"));
        WebElement secondColumn = driver.findElement(By.xpath("//table[@id='category']/tbody/tr/th[2]"));

        String expectedResult1 = "Language";
        String expectedResult2 = "Author";
        String actualResult1 = firstColumn.getText();
        String actualResult2 = secondColumn.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
    }
}
