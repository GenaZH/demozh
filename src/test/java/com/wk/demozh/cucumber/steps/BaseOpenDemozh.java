package com.wk.demozh.cucumber.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$x;

public class BaseOpenDemozh {
    private static final int TIME_WAIT_BROWSER = 60000;

    public static boolean waitWebElementInPage(SelenideElement element, int pause) {
        try {
            Configuration.timeout = pause; //driver.manage().timeouts().implicitlyWait(pause, TimeUnit.SECONDS);
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(0).plusSeconds(pause));
            element.click();
            return element.isDisplayed(); //return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed(); //.elementToBeClickable(webElement));
        } catch (Exception e) {
            return false;
        } finally {
            Configuration.timeout = TIME_WAIT_BROWSER;
        }
    }

    public static void waitWebElementInPage(SelenideElement element) {
        waitWebElementInPage(element, TIME_WAIT_BROWSER);
    }

    public static boolean waitRemoveWebElementInPage(SelenideElement element, int pause) {
        try {
            Configuration.timeout = pause; //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // при проверки на отсутсвие всегда 0
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(0).plusSeconds(pause));
            int tm = 0;
            do {
                Thread.sleep(1000);
                tm = tm + 1000;
            } while ((element.isDisplayed()) & (tm < pause));
            return element.isDisplayed(); //return wait.ignoring(StaleElementReferenceException.class, NoSuchElementException.class).until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            return false;
        } finally {
            Configuration.timeout = TIME_WAIT_BROWSER;
        }
    }
    private static final SelenideElement nameProgressBar = $x("//div[@role='progressbar']");
    public static void waitDownloadPage() {
        waitWebElementInPage(nameProgressBar, 1000);
        waitRemoveWebElementInPage(nameProgressBar, TIME_WAIT_BROWSER);
    }
    public static void inputText(SelenideElement element, String text) {
        element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), text);
    }

    @Когда("Oткрываем браузер {string}")
    public void openBrowser(String url) {
        Configuration.timeout = TIME_WAIT_BROWSER;
        //Configuration.startMaximized = true;
        Configuration.browserSize = "1920x1080";
        Selenide.open(url);
    }
    private final SelenideElement inputUserLogin = $x("//input[@name='username']");
    private final SelenideElement inputUserPassword = $x("//input[@name='password']");
    private final SelenideElement buttonSubmit = $x("//input[@name='submit']");

    @И("Вводим логин и пароль администратора {string} и {string}")
    public void EnterPasswordAdmin(String login, String pas) {
        inputUserLogin.sendKeys(login);
        inputUserPassword.sendKeys(pas);
        buttonSubmit.click();
    }

    private final SelenideElement inputUserToken = $x("//input[@id='psw']");
    private final SelenideElement buttonSubmitToken = $x("//input[@name='submitt']");

    @И("Вводим токен администратора {string}")
    public void EnterTokenAdmin(String token) {
        inputUserToken.sendKeys(token);
        buttonSubmitToken.click();
    }

    private final SelenideElement buttonModeUserOrAdmin = $x("//div[@id='root']//div[@class='MainView-module-switchCheckboxNo__2xkpms4']");

    @Тогда("Нажимаем кнопку переключения с режима {string}")
    public void clickButtonModeUser(String mode) {
        if (!buttonModeUserOrAdmin.getText().equalsIgnoreCase(mode)) {
            buttonModeUserOrAdmin.click();
        }
    }

    private final SelenideElement buttonSave = $x("//button[@type='button']//span[normalize-space(.) = 'Save']");

    @И("Нажимаем кнопку Save")
    public void clickButtonSave() {
        buttonSave.click();
    }

}
