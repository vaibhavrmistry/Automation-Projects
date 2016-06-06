package com.spotify.test.login;

import org.testng.annotations.Test;


import com.spotify.test.Play;
import com.spotify.test.Util;
import com.spotify.test.dataProvider.SpotifyData;

import org.testng.annotations.BeforeClass;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class PlayTest {
  
	Screen screen;
	Play play;
	
	public PlayTest() {
		// TODO Auto-generated constructor stub
		play = new Play();
	}
	
  @BeforeClass
  public void beforeClass() {
	  
	  		//login into spotify and check if login is successful
	  		screen = Util.loginSpotify(screen);
			Assert.assertTrue(screen.exists(Util.m_loginOptions) != null);
			System.out.println("Login Sucessful");
  }
  
  @Test(priority = 1)
  public void playGeneral() {
	  
	  //check the playback on last played song
	  screen = play.playGeneral(screen);
	  Assert.assertTrue(screen.exists(Util.m_pause_general) != null);
	  play.pauseSong(screen);
  }
  
  @Test(priority = 2, dataProvider = "searchSong", dataProviderClass=SpotifyData.class)
  public void playSong(String song) {
	  
	  //search for a song and play it from the search results
	  screen = play.playSong(screen, song);
	  Assert.assertTrue(screen.exists(Util.m_pause_hover) != null);
	  play.pauseSong(screen);
  }
  
  @Test(priority = 3, dataProvider = "searchSong", dataProviderClass=SpotifyData.class)
  public void playAlbum(String song) {
	  
	  //search for the song and play the album
	  screen = play.playAlbum(screen, song);
	  Assert.assertTrue(screen.exists(Util.m_pause_song) != null);
	  play.pauseSong(screen);
  }
  @AfterMethod
  public void betweenTests(){
	  //add a wait time of 1 second between tests
	  screen.wait(1.0);
  }
  
  
  @AfterClass
  public void afterClass() {
	  //logout and close the app
	  Util.logout(screen);
	  Util.closeApp();
	  
  }

}
