import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultsPage
{
    WebDriver webDriver;

    @FindBy(className = "iUh30")
    List<WebElement> searchResultsLinks;

    public ResultsPage(WebDriver driver)
    {
        this.webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
    }

    public String GetResultLink(int Index)
    {
        return this.searchResultsLinks.get(Index).getText();
    }
}

