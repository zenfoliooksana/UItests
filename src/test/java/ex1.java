import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by pro-28 on 21.03.2018.
 */
public class ex1 {
    WebDriver driver;

    @Test
    public void test1() {
        WebElement taskElement = driver.findElement(By.id("dnn_ContentPane"));
        boolean t = taskElement.isDisplayed();

        Assert.assertTrue(t);
        //Assert.assertEquals(8,c);
    }

    @Test
    public void test2() throws InterruptedException {
        WebElement ham = driver.findElement(By.className("s2h-expand"));
        boolean t = ham.isDisplayed();
        Actions scenario = new Actions(driver);
        scenario.moveToElement(ham)
                .click()
                .pause(1000)
                .perform();
        String logurl ="a[href=\"http://www.a.zenfolio.us/u/e/dashboard.aspx\"]";
          WebElement log = driver.findElement(By.cssSelector(logurl));
          Actions clicklogin = new Actions(driver);
          clicklogin.moveToElement(log)
                  .click()
                  .perform();
          WebElement username = driver.findElement(By.id("_ab-username"));
          WebElement password = driver.findElement(By.id("_ab-password"));
          WebElement login = driver.findElement(By.cssSelector("a[href=\"javascript:_zf_ab.submit();\"]"));
        Actions typename = new Actions(driver);
        typename.moveToElement(username)
                .sendKeys("crazybee").moveToElement(password).click().sendKeys("541308")
                .moveToElement(login).click().pause(5000).perform();
        WebElement name = driver.findElement(By.cssSelector("#dropdown-menu-link2 span"));
       // name.getText();
        Assert.assertEquals("crazybee",name.getText());



       // Assert.assertTrue(t);
    }

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "res/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://en.a.zenfolio.us/");
    }

    @After
    public void close() {
        driver.close();
    }
}
