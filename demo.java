import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.*;

public class demo{
   // public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
//        Scanner scanner = new Scanner(System.in);
//        String tab = scanner.nextLine();
//        String subtab = scanner.nextLine();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");

        Thread.sleep(3000);
        fetchAllTabs(driver);
        Thread.sleep(3000);

        demo obj = new demo();
        obj. Navigate( driver,"Desktops","Mac");
        Thread.sleep(3000);

        driver.close();
    }
    public static void fetchAllTabs(WebDriver driver) {
        driver.manage().window().maximize();
        WebElement menuElement = driver.findElement(By.xpath("//nav[@id='menu']"));
        String responseText = menuElement.getText();
        System.out.println(responseText);
    }

    public void Navigate(WebDriver driver,String Tab,String subTab) throws InterruptedException {
//        String actualTitle = driver.getCurrentUrl()getTitle();

        WebElement menu = driver.findElement(By.partialLinkText(Tab));
        menu.click();
        Thread.sleep(2000);
        WebElement submenu = driver.findElement(By.partialLinkText(subTab));
        submenu.click();
        String expectedTitle = driver.getTitle();

            if(expectedTitle.equals(subTab)){
               System.out.println("New tab successfully opened ");

            }else {
                System.out.println("Failed to open  the New tab");
        }

        }
    }










