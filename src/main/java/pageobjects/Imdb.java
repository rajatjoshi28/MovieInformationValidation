package pageobjects;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Imdb extends AbstractMethods {
	
	WebDriver driver;
	
	public Imdb(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div/input[@id='suggestion-search']")
	WebElement ImdbSearch;
	
	@FindBy(xpath="//a[contains(text(),'Release date')]/following-sibling::div")
	WebElement ImdbReleaseDate;
	
	@FindBy(xpath="//button[contains(text(),'Country of origin')]/following-sibling::div")
	WebElement ImdbCountry;
	
	@FindBy(css="li[id='react-autowhatever-1--item-0'] a")
	WebElement Imdbfirstmovieselect;
	
	public void navigateTo() throws IOException
	{
		String ImdbURL = getDataProperty("ImdbURL");
		driver.navigate().to(ImdbURL);
	}
	
	
	public void searchMovieOnImdb() throws InterruptedException, IOException
	{
		String MovieName = getDataProperty("MovieName");
		ImdbSearch.sendKeys(MovieName);    //searching movie in IMDB
		Imdbfirstmovieselect.click();

	}
	
	public String getReleleaseDateImdb()
	{
		String IMDBfullreleaseDate= ImdbReleaseDate.getText();
		return trimImdbReleaseDate(IMDBfullreleaseDate);    //trimming IMDB release date to make similar to Wikipedia Date Format
	}
	
	public String getCountryImdb()
	{
		return ImdbCountry.getText();
	}
	
	public String trimImdbReleaseDate(String IMDBfullreleaseDate)
	{
		String[] splitDate = IMDBfullreleaseDate.split(" \\(");   //Splitting String for Date only
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);  

		LocalDate date = LocalDate.parse(splitDate[0], formatter);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd LLLL yyyy");   //converting required Date Time format
		String formattedString = date.format(formatter1);
		return formattedString;
	}
	



}
