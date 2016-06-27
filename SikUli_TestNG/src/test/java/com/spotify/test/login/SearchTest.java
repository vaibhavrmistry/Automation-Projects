package com.spotify.test.login;

import org.testng.annotations.Test;

import com.spotify.test.Search;
import com.spotify.test.Util;
import com.spotify.test.dataProvider.SpotifyData;

import org.testng.annotations.BeforeClass;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SearchTest {
	 
	private Screen screen;
	private Search search;
	
	public SearchTest() {
		// TODO Auto-generated constructor stub
		search = new Search();
	}
	

	@BeforeClass
	public void beforeClass(){  
		
		//login into spotify
		screen = Util.loginSpotify(screen);
		Assert.assertTrue(screen.exists(Util.m_loginOptions) != null);

	  }
	
	
	
	@Test(priority= 1, dataProvider = "searchArtist", dataProviderClass=SpotifyData.class)
	public void searchArtistSuggestionTest(String artist) {
		//search for an artist and check if the name appears in suggest screen
		screen = search.searchSuggest(screen, artist);
		Assert.assertTrue(screen.exists(Util.m_artist_suggest) != null);

	}

	@Test(priority= 2, dataProvider = "searchArtist", dataProviderClass=SpotifyData.class)
	public void searchArtistSearchResultsTest(String artist) {
		//search for the artist and check if the artist is displayed in search all
		screen = search.searchAll(screen, "coldplay", false);
		Assert.assertTrue(screen.exists(Util.m_artist_search) != null);

	}
	
	@Test(priority= 3)
	public void searchRecentTest() {
		//check if the artist is displayed in recent searches
		screen = search.searchRecent(screen);
		Assert.assertTrue(screen.exists(Util.m_artist_recent) != null);

	}

	
	@Test(priority= 4, dataProvider = "searchArtist", dataProviderClass=SpotifyData.class)
	public void searchResultsWithEnterKeyTest(String artist) {
		
		//check if the search can be performed on press of enter key
		screen = search.searchAll(screen, artist, true);
		Assert.assertTrue(screen.exists(Util.m_artist_search) != null);

	}
	
	
	@Test(priority= 5, dataProvider = "invalidSearch", dataProviderClass=SpotifyData.class)
	public void invalidSearchTest(String text) {
		
		//provide some invalid input and check that no results are obtained
		screen = search.searchAll(screen, text, true);
		Assert.assertTrue(screen.exists(Util.m_search_notFound) != null);

	}
	
	@Test(priority= 6, dataProvider = "invalidSearch", dataProviderClass=SpotifyData.class)
	public void searchCharTest(String text) {
		
		//provide some invalid input and check if "show all" option is displayed
		screen = search.searchSuggest(screen, text);
		Assert.assertTrue(screen.exists(Util.m_showAll_suggest) != null);

	}
	
	
	@Test(priority= 7, dataProvider = "searchSong", dataProviderClass=SpotifyData.class)
	public void searchSongSuggestTest(String song) {
		
		//search for a song and check if the song exists in suggestion
		screen = search.searchSuggest(screen, song);
		Assert.assertTrue(screen.exists(Util.m_song_suggest) != null);

	}
	
	@Test(priority= 8, dataProvider = "searchSong", dataProviderClass=SpotifyData.class)
	public void searchSongTest(String song) {
		
		//search for a song and check if the song exists in show all
		screen = search.searchSong(screen, song);
		Assert.assertTrue(screen.exists(Util.m_song_search) != null);

	}
	
  @AfterClass
  public void afterClass() {
	  
	  //logout and close the app
	  Util.logout(screen);
	  Util.closeApp();
	  screen.wait(2.0);
	  
  }

}
