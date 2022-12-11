package testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Imdb;
import pageobjects.Wikipedia;
import testcomponents.BaseComponents.BaseTest;

public class TestSuite extends BaseTest {

	@Test
	public void ReleaseDateValidation() throws IOException, InterruptedException {

		//driver initialization - (Before Method -Base Test) respective to browser detail from Properties file 
	
		
		// WikiPedia Steps

		Wikipedia wikihome = new Wikipedia(driver);
		wikihome.goTo();                                              // navigating to Wikipedia homepage
		wikihome.searchMovieOnWiki();                                 // Search movie on wiki
		String releasedateWiki = wikihome.getReleleaseDateWiki();     // fetching Release Date from Wiki
		String countryWiki = wikihome.getCountryWiki();               // fetching Country from Wiki

		// IMDB Steps

		Imdb imdbhome = new Imdb(driver);
		imdbhome.navigateTo();                                        // navigating to IMDB homepage
		imdbhome.searchMovieOnImdb();                                 // Search movie on IMDB
		String releasedateIMDB = imdbhome.getReleleaseDateImdb();     // fetching Release Date from IMDB and spliting String
		String countryIMDB = imdbhome.getCountryImdb();               // fetching Country from IMDB

		Assert.assertEquals(releasedateWiki, releasedateIMDB);
		Assert.assertEquals(countryWiki, countryIMDB);

		System.out.println("Validation has been completed successfully");
		
		
	}

}
