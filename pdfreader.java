import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.net.URL;

public class pdfreader {
    @Test
    public void read() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.africau.edu/images/default/sample.pdf");
        //String urlString = driver.getCurrentUrl();
        URL url = new URL("https://www.africau.edu/images/default/sample.pdf");
        PDDocument pdfdocument = PDDocument.load(url.openStream());
        System.out.println(pdfdocument.getPages().getCount());
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        pdfTextStripper.setStartPage(1);
        pdfTextStripper.setEndPage(1);
        String docText = pdfTextStripper.getText(pdfdocument);
        System.out.println(docText);
        pdfdocument.close();
        driver.quit();
    }
}
