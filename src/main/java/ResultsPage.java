import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultsPage
{
    WebDriver webDriver;

    @FindBy(css = ".rc>.r>a")
    List<WebElement> searchResultsHeaders;

    public ResultsPage(WebDriver driver)
    {
        this.webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
    }

    public String GetResult(int Index)
    {
        if(Index < this.searchResultsHeaders.size())
            return this.searchResultsHeaders.get(Index).getText();

        return "";
    }
}

