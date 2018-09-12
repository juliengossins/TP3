import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver webDriver;

    @FindBy(id = "hplogo")
    WebElement logo;

    @FindBy(name = "q")
    WebElement searchBar;

    @FindBy(className = "lsb")
    WebElement embeddedSearchButton;

    @FindBy(name = "btnK")
    WebElement mainSearchButton;

    public HomePage(WebDriver driver)
    {
        this.webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void Search(String Text)
    {
        this.searchBar.sendKeys(Text);
    }

    public ResultsPage SearchByPressingEnter()
    {
        this.searchBar.sendKeys(Keys.ENTER);
        return new ResultsPage(this.webDriver);
    }

    public ResultsPage SearchByClickingEmbeddedButton()
    {
        this.embeddedSearchButton.click();
        return new ResultsPage(this.webDriver);
    }

    public ResultsPage SearchByClickingMainButton()
    {
        this.mainSearchButton.click();
        return new ResultsPage(this.webDriver);
    }

    public void CloseSearchSuggestions()
    {
        this.searchBar.sendKeys(Keys.ESCAPE);
    }
}
