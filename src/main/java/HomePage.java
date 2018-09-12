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

    public void SearchByPressingEnter()
    {
        this.searchBar.sendKeys(Keys.ENTER);
    }

    public void SearchByClickingEmbeddedButton()
    {
        this.embeddedSearchButton.click();
    }

    public void SearchByClickingMainButton()
    {
        this.mainSearchButton.click();
    }

    public void CloseSearchSuggestions()
    {
        this.searchBar.sendKeys(Keys.ESCAPE);
    }
}
