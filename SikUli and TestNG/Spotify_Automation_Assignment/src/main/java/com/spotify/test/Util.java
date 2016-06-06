package com.spotify.test;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class Util {
	//Util class for common operations
	
	
	// Images for validations
	public static final Pattern m_spotify_logo = new Pattern("./images/spotify_logo.png");
	public static final Pattern m_username = new Pattern("./images/or.png").targetOffset(138, 35);
	public static final Pattern m_facebookButton = new Pattern("./images/facebook_login.png");
	public static final Pattern m_facebookLogin = new Pattern("./images/facebook_login.png");
	public static final Pattern m_rememberMeButton = new Pattern("./images/rememberMeButton.png");
	public static final Pattern m_rememberMeText = new Pattern("./images/rememberMeText.png");
	public static final Pattern m_invalidMessage = new Pattern("./images/invalidPopUp.png");
	public static final Pattern m_loginButton = new Pattern("./images/loginButton.png");
	public static final Pattern m_password = m_facebookButton.targetOffset(134, 137);
	public static final Pattern m_searchbar = new Pattern("./images/search_field.png");
	public static final Pattern m_menuIcon = new Pattern("./images/menu_icon.png");
	public static final Pattern m_menuList = new Pattern("./images/menuList.png");
	public static final Pattern m_fbEmail = new Pattern("./images/fb_emailField.png");
	public static final Pattern m_fbLogin = new Pattern("./images/fbLoginButton.png");
	public static final Pattern m_fbPassword = new Pattern("./images/fbPassword.png");
	public static final Pattern m_loginOptions = new Pattern("./images/options.png");
	
	public static final Pattern m_artist_suggest = new Pattern("./images/coldplay_suggest.png");
	public static final Pattern m_artist_search = new Pattern("./images/coldplay_search.png");
	public static final Pattern m_artist_recent = new Pattern("./images/coldplay_recent.png");
	public static final Pattern m_song_suggest = new Pattern("./images/hymn_suggest.png");
	public static final Pattern m_song_search = new Pattern("./images/hymn_search.png");
	public static final Pattern m_search_found = new Pattern("./images/searchResults.png");
	public static final Pattern m_search_notFound = new Pattern("./images/noResults.png");
	public static final Pattern m_topResults_suggest = new Pattern("./images/topResults_suggest.png");
	public static final Pattern m_showAll_suggest = new Pattern("./images/showAllResults.png");
	
	public static final Pattern m_play_general = new Pattern("./images/playGeneral.png");
	public static final Pattern m_play_song = new Pattern("./images/playSong.png");
	public static final Pattern m_pause_general= new Pattern("./images/pauseGeneral.png");
	public static final Pattern m_pause_hover = new Pattern("./images/pauseSongHover.png");
	public static final Pattern m_pause_song = new Pattern("./images/pauseSongButton.png");
	public static final Pattern m_song2 = new Pattern("./images/song2.png");
	
	public static final Pattern m_song2_suggest= new Pattern("./images/song2_suggest.png");
	public static final Pattern m_song2_search = new Pattern("./images/song2_search.png").targetOffset(-119, 0);
	public static final Pattern m_mySongs = new Pattern("./images/mySongs.png");
	public static final Pattern m_song2Added = new Pattern("./images/song2Added.png");
	
	
	
	public static Screen waitAndTakeAScreenCapture(Screen s){
		//wait for 2 secs
		s.wait((double)2.0);
		//take a new Screenshot
		s = new Screen();
		return s;
	}
	
	public static Screen openAppAndGiveScreen(){
		
		App.open("Spotify");
		
		Screen screen = new Screen();
		screen.wait((double)2.0);//wait for 2 seconds 
		return screen;
		
	}
	
	public static void logout(Screen s){
		
		try{
			s.click(Util.m_menuIcon);
			s.click(Util.m_menuList.targetOffset(0, 75));

		}
		catch(FindFailed e){
				e.printStackTrace();
		}
		
	}
	
	public static void closeApp(){
		
		App.close("Spotify");
	}
	
	public static Screen loginSpotify(Screen screen){
		
		//open App and login
		screen = Util.openAppAndGiveScreen();
		screen.wait(3.0);
		Login login = new Login();
		String [][] creds = TestData.giveValidCreds();
		String username = creds[0][0];
		String password = creds[0][1];
		
		login.loginWithRememberMe(screen, username, password);
		screen = Util.waitAndTakeAScreenCapture(screen);
		return screen;
	}
	
	
	
}
