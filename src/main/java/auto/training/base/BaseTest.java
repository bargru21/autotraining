package auto.training.base;

import auto.training.drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private final String APP_URL = "https://www.scrum.org/classes";
    protected WebDriver driver;

    public BaseTest() {
        driver = DriverManager.getDriver();
    }

    @BeforeMethod
    public void setUp() {
        driver.get(APP_URL);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
