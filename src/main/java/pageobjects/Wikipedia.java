package pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wikipedia extends AbstractMethods {

	WebDriver driver;

	public Wikipedia(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "searchInput")
	WebElement WikiSearch;

	@FindBy(xpath = "//div[contains(text(),'Release date')]/parent::th/following-sibling::td")
	WebElement WikiReleaseDate;

	@FindBy(xpath = "//th[contains(text(),'Country')]/following-sibling::td")
	WebElement WikiCountry;

	public void goTo() throws IOException {
		String WikiURL = getDataProperty("WikiPediaURL");
		driver.get(WikiURL);
	}

	public void searchMovieOnWiki() throws IOException {
		String MovieName = getDataProperty("MovieName");
		WikiSearch.sendKeys(MovieName, Keys.DOWN, Keys.ENTER);
	}

	public String getReleleaseDateWiki() {
		return WikiReleaseDate.getText();
	}

	public String getCountryWiki() {
		return WikiCountry.getText();
	}

}
