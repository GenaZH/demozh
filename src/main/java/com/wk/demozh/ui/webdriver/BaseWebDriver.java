package com.wk.demozh.ui.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseWebDriver {
    private static final int TIME_WAIT_BROWSER = 60;
    private static final String NAME_PROGRESSBAR = "//div[@role='progressbar']";

    public static WebDriver openBrowser() {
        WebDriver driverp;
        //System.setProperty("webdriver.chrome.driver", PropertiesUI.getInstance().getPathChromeDriver());
        WebDriverManager.chromedriver().setup();  // ИЛИ это скачивает последнюю версию автоматически

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");                                        // отменяет ошибку неверного сертификата
        options.addArguments("--start-maximized");                                                  // открывает окно браузера сразу максимально
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});  // убирает надпись в Хроме: Браузером Chrome управляет автоматизированное тестовое ПО
        options.setExperimentalOption("useAutomationExtension", false);

        driverp = new ChromeDriver(options);
        driverp.manage().timeouts().pageLoadTimeout(TIME_WAIT_BROWSER, TimeUnit.SECONDS);
        driverp.manage().timeouts().setScriptTimeout(TIME_WAIT_BROWSER, TimeUnit.SECONDS);
        driverp.manage().timeouts().implicitlyWait(TIME_WAIT_BROWSER, TimeUnit.SECONDS);
        return driverp;
    }

    public static void openPage(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void closeBrowser(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    public static String getTitlePage(WebDriver driver) {
        return driver.getTitle();
    }

    public static boolean waitWebElementInPage(WebDriver driver, WebElement webElement, int pause) {
        try {
            driver.manage().timeouts().implicitlyWait(pause, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(0).plusSeconds(pause));
            wait.until(ExpectedConditions.visibilityOf(webElement)); //.elementToBeClickable(webElement));
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(TIME_WAIT_BROWSER, TimeUnit.SECONDS);
        }
    }

    public static void waitWebElementInPage(WebDriver driver, WebElement webElement) {
        waitWebElementInPage(driver, webElement, TIME_WAIT_BROWSER);
    }

    public static boolean waitWebElementInPage(WebDriver driver, By by, int pause) {
        try {
            driver.manage().timeouts().implicitlyWait(pause, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(0).plusSeconds(pause));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed(); //.elementToBeClickable(webElement));
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(TIME_WAIT_BROWSER, TimeUnit.SECONDS);
        }
    }

    public static boolean waitWebElementInPage(WebDriver driver, By by) {
        return waitWebElementInPage(driver, by, TIME_WAIT_BROWSER);
    }

    public static boolean waitRemoveWebElementInPage(WebDriver driver, By by, int pause) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // при проверки на отсутсвие всегда 0
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(0).plusSeconds(pause));
            return wait.ignoring(StaleElementReferenceException.class, NoSuchElementException.class).until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(TIME_WAIT_BROWSER, TimeUnit.SECONDS);
        }
    }

    public static void waitDownloadPage(WebDriver driver) {
        waitWebElementInPage(driver, By.xpath(NAME_PROGRESSBAR), 1);
        waitRemoveWebElementInPage(driver, By.xpath(NAME_PROGRESSBAR), TIME_WAIT_BROWSER);
    }

    public static void realClickWebElement(WebDriver driver, WebElement element) {
        int counter = 1;
        boolean realClick;
        do {
            if (waitWebElementInPage(driver, element, 1)) {
                try {
                    element.click();
                    realClick = true;
                } catch (Exception e) {
                    realClick = false;
                }
            } else {
                realClick = false;
            }
            counter++;
        } while ((counter < TIME_WAIT_BROWSER) && (!realClick));
    }

    public static void clickElementWaitDisappear(WebDriver driver, WebElement elementMain, WebElement elementFailure) {
        realClickWebElement(driver, elementMain);
        waitDownloadPage(driver);
        if (waitWebElementInPage(driver, elementMain, 1)) {
            realClickWebElement(driver, elementFailure);
        }
        ;
    }

    public static boolean clickUntilSecondElementVisibility(WebDriver driver, WebElement elementFirst, WebElement elementSecond, WebElement elementFailure, Boolean waitloadData) {
        int counter = 1;
        boolean realClick;
        boolean ret;
        waitWebElementInPage(driver, elementFirst);
        do {
            counter++;
            ret = (counter < TIME_WAIT_BROWSER);
            try {
                elementFirst.click();
                realClick = true;
            } catch (Exception e) {
                realClick = false;
            }
        } while ((ret) && ((!realClick) || (!waitWebElementInPage(driver, elementSecond, 1))));
        if((elementFailure != null) && ( !ret )){
            realClickWebElement(driver, elementFailure);
        }
        if ((waitloadData) && (ret)) {
            waitDownloadPage(driver);
        }
        return ret;
    }

    public static boolean clickUntilSecondElementVisibility(WebDriver driver, WebElement elementFirst, By elementSecond, WebElement elementFailure, Boolean waitloadData) {
        int counter = 1;
        boolean realClick;
        boolean ret;
        waitWebElementInPage(driver, elementFirst);
        do {
            counter++;
            ret = (counter < TIME_WAIT_BROWSER);
            try {
                elementFirst.click();
                realClick = true;
            } catch (Exception e) {
                realClick = false;
            }
        } while ((ret) && ((!realClick) || (!waitWebElementInPage(driver, elementSecond, 1))));
        if((elementFailure != null) && ( !ret )){
            realClickWebElement(driver, elementFailure);
        }
        if ((waitloadData) && (ret)) {
            waitDownloadPage(driver);
        }
        return ret;
    }

    public static void clickUntilSecondElementClick(WebDriver driver, WebElement combo, WebElement list, WebElement elementFailure, Boolean waitloadData) {
        clickUntilSecondElementVisibility(driver, combo, list, elementFailure, waitloadData);
        realClickWebElement(driver, list);
    }

    public static void clickUntilSecondElementClick(WebDriver driver, WebElement combo, By listPoz, WebElement elementFailure, Boolean waitloadData) {
        if (clickUntilSecondElementVisibility(driver, combo, listPoz, elementFailure, waitloadData)) {
            realClickWebElement(driver, driver.findElement(listPoz));
        }
        ;
    }

    public static void choiceInComboListContainsIdOption(WebDriver driver, WebElement combo, int poz, WebElement elementFailure, Boolean waitloadData) {
        clickUntilSecondElementClick(driver, combo, By.xpath("//div[@role='presentation']//li[contains(@id, '-option-" + poz + "')]"), elementFailure, waitloadData);
    }

    public static void inputText(WebElement element, String text) {
        element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), text);
    }

    public static int getRandomNumberInt(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }


}

