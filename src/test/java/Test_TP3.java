import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.transform.Result;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

public class Test_TP3
{
    private WebDriver webDriver;

    @Before
    public void Setup()
    {
        this.webDriver = new ChromeDriver();
        this.webDriver.get("https://www.google.com");
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void TearDown()
    {
        this.webDriver.quit();
    }

    @Test
    public void Test1()
    {
        HomePage homePage = new HomePage(this.webDriver);
        homePage.Search("Bordeaux");
        ResultsPage resultsPage = new ResultsPage();
        Assert.assertThat(resultsPage.GetResult(0), is("Site officiel de la ville de Bordeaux | Bordeaux"));
    }
}
