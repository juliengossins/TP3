import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;

public class ResultsPage
{
    WebDriver webDriver;

    //@FindAll()
    //WebElement[] searchResults;

    public ResultsPage(WebDriver driver)
    {
        this.webDriver = driver;
    }

    public String GetResult(int Index)
    {
        return "";
    }
}

