import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.core.Is.is;

public class Test_TP3
{
    private WebDriver webDriver;
    private String searchText = "Bordeaux";
    private String expectedResult = "Site officiel de la ville de Bordeaux | Bordeaux";

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
    public void SearchByPressingEnter()
    {
        HomePage homePage = new HomePage(this.webDriver);
        homePage.Search(this.searchText);
        homePage.SearchByPressingEnter();
        ResultsPage resultsPage = new ResultsPage(this.webDriver);
        Assert.assertThat(resultsPage.GetResult(0), is(this.expectedResult));
    }


    @Test
    public void SearchByClickingSearchButton()
    {
        HomePage homePage = new HomePage(this.webDriver);
        homePage.Search(this.searchText);
        homePage.CloseSearchSuggestions();
        homePage.SearchByClickingMainButton();
        ResultsPage resultsPage = new ResultsPage(this.webDriver);
        Assert.assertThat(resultsPage.GetResult(0), is(this.expectedResult));
    }

    @Test
    public void SearchByClickingEmbeddedSearchButton()
    {
        HomePage homePage = new HomePage(this.webDriver);
        homePage.Search(this.searchText);
        homePage.SearchByClickingEmbeddedButton();
        ResultsPage resultsPage = new ResultsPage(this.webDriver);
        Assert.assertThat(resultsPage.GetResult(0), is(this.expectedResult));
    }
}
