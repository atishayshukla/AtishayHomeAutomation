package com.atishay.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ATISHAY on 27-06-2015.
 */
public class BaseTest {

    protected static final String BROWSER = System.getProperty("BROWSER","chrome");
    protected static final boolean REMOTE_DRIVER = Boolean.valueOf(System.getProperty("REMOTE_DRIVER", "false"));
    protected static final String SELENIUM_HOST = System.getProperty("SELENIUM_HOST", "192.168.1.35");
    protected static final int SELENIUM_PORT = 4444;

    public static RemoteWebDriver driver;

    @BeforeClass
    public static void setup() throws MalformedURLException {

        if (REMOTE_DRIVER){
            DesiredCapabilities capabilities;
            switch (BROWSER) {
                case "firefox":
                   capabilities = DesiredCapabilities.firefox();
                    break;
                case "chrome":
                    capabilities = DesiredCapabilities.chrome();  // The path for chrome exe will be set on the remote machine when starting node
                    break;
                case "internetExplorer":
                    capabilities = DesiredCapabilities.internetExplorer();
                    break;
                default:
                    throw new RuntimeException("Browser type unsupported");
            }
            driver = new RemoteWebDriver(
                    new URL("http://" + SELENIUM_HOST + ":" + SELENIUM_PORT + "/wd/hub"),
                    capabilities );

        } else {
            switch (BROWSER) {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    String path;
                    if (System.getProperty("os.name").contains("Windows")){
                        path = "lib/chromedriver.exe";
                    } else {
                        path = "lib/chromedriver";
                    }
                    System.setProperty("webdriver.chrome.driver", path);
                    driver = new ChromeDriver();
                    break;
                case "internetExplorer":
                    String ieDriverPath;
                    if (System.getProperty("os.name").contains("Windows")){
                        ieDriverPath = "lib/IEDriverServer.exe";
                    } else {
                        ieDriverPath = "lib/IEDriverServer.exe";
                    }
                    System.setProperty("webdriver.ie.driver", ieDriverPath);
                    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                    capabilities.setCapability("ignoreZoomSetting", true);
                    driver = new InternetExplorerDriver(capabilities);
                    break;
                default:
                    throw new RuntimeException("Browser Unsupported");
            }
        }
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadLoginPage() {
        try {
            driver.get("http://www.grofers.com/");
        }catch (Exception e){
            System.out.println("URL Not found" + e.getMessage());
        }
    }

    @AfterMethod
    public void testTearDown() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void suiteTearDown() {
        driver.quit();
    }
}
