package com.spotify.test.login;

import org.testng.annotations.Test;

import com.spotify.test.AddToMySongs;
import com.spotify.test.Util;
import com.spotify.test.dataProvider.SpotifyData;

import org.testng.annotations.BeforeClass;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AddtoMySongsTest {
	
	Screen screen;
	// Extra feature testing
  @Test(priority= 1,dataProvider = "addSong", dataProviderClass=SpotifyData.class)
  public void addToMySongs(String song) {
	  //add a song to my songs and check if the song exists in the my songs 
	  AddToMySongs add = new AddToMySongs();
	  add.addToMySongs(screen, song);
	  Assert.assertTrue(screen.exists(Util.m_song2_search) != null);
  }
  
  @Test(priority=2,dataProvider = "addSong", dataProviderClass=SpotifyData.class)
  public void removeFromMySongs(String song) {
	//Remove the added song from my songs and check if the song is removed 
	  AddToMySongs add = new AddToMySongs();
	  add.removeFromMySongs(screen, song);
	  Assert.assertTrue(screen.exists(Util.m_song2_search) != null);
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  		//login and verify
	  		screen = Util.loginSpotify(screen);
			Assert.assertTrue(screen.exists(Util.m_searchbar) != null);
  }

  @AfterClass
  public void afterClass() {
	  
	  //logout and close app
	  Util.logout(screen);
	  Util.closeApp();
  }

}
