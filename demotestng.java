import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demotestng {
    WebDriver driver;
    String Tab = "Desktop";
    String subTab = "Mac";
    @BeforeTest
    public void launch(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void fetchAllTabs(){
        WebElement menuElement = driver.findElement(By.xpath("//nav[@id='menu']"));
        String responseText = menuElement.getText();
        System.out.println(responseText);

    }
    @Test(priority = 2)
    public void Navigate(){
        driver.findElement(By.partialLinkText(Tab)).click();
        driver.findElement(By.partialLinkText(subTab)).click();

    }
    @Test(priority = 3)
    public void Validate(){
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(subTab,expectedTitle,"Failed to open  the New tab");
        System.out.println("New tab successfully opened");
    }
    @AfterTest
    public void close(){
        driver.navigate().back();
        driver.quit();
    }
}
