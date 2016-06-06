package com.spotify.test.login;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spotify.test.Login;
import com.spotify.test.Util;
import com.spotify.test.dataProvider.SpotifyData;

public class LoginTest {
	
	private Login loginTests;
	private Screen screen;
	
	public LoginTest() {
		// TODO Auto-generated constructor stub
		loginTests = new Login();
	}
	
	
	@BeforeClass
	public void setupTest(){
		//get screen 
		screen = loginTests.setupAndGetScreen(); 
		//check if Spotify logo exists
		Assert.assertTrue(screen.exists(Util.m_spotify_logo) != null);
	
	}
	
	@BeforeMethod
	public void betweenTests(){
		//add a wait time of 2 seconds between tests
		screen.wait(2.0);
	}
	
	

  @Test (priority = 2, dataProvider = "validCreds", dataProviderClass=SpotifyData.class)
  public void validUserTestWithRememberMe(String username, String password) throws FindFailed {
	  
	  //login with remember me
	  loginTests.loginWithRememberMe(screen, username, password);
	  screen = Util.waitAndTakeAScreenCapture(screen);
	  //check on login if the options exists
	  Assert.assertTrue(screen.exists(Util.m_loginOptions) != null);

  }
  
  @Test (priority = 3)
  public void checkRememberMe() throws FindFailed {
	  //check if remember me works by reopening the app
	  screen = loginTests.rememberTestsReOpenApp(screen);
	  Assert.assertTrue(screen.exists(Util.m_loginOptions) != null);
	  Util.logout(screen);
  }
  

  
  @Test (priority = 4, dataProvider = "validCreds", dataProviderClass=SpotifyData.class)
  public void validUserTestWithoutRememberMe(String username, String password) throws FindFailed {
	  
	  //login without remember me
	  loginTests.loginWithoutRememberMe(screen, username, password);
	  screen = Util.waitAndTakeAScreenCapture(screen);
	  Assert.assertTrue(screen.exists(Util.m_loginOptions) != null);

  }
  
  
  
  @Test (priority = 5)
  public void checkWithoutRememberMe() throws FindFailed {

	  screen = loginTests.rememberTestsReOpenApp(screen);
	  Assert.assertTrue(screen.exists(Util.m_spotify_logo) != null);
	  Util.logout(screen);
  }
  
  
  @Test (priority = 1, dataProvider = "inValidCreds", dataProviderClass=SpotifyData.class)
  public void invalidUserTest1(String username, String password) {
	  
	  //login with invalid user
	  loginTests.loginWithRememberMe(screen, username, password);
	  //wait for 1 sec
	  screen.wait(1.0);
	  //take a new screen capture
	  screen = new Screen();
	  Assert.assertTrue(screen.exists(Util.m_invalidMessage) != null);
	 
  }
  
  
  @Test	(priority = 6)
  public void facebookUserTest() {
	  
	
	  //login with facebook assuming that the user is logged in the facebook on browser
	  screen  = loginTests.loginWithFacebook(screen);
	  screen.wait(4.0);
	  Assert.assertTrue(screen.exists(Util.m_loginOptions) != null);
	  Util.logout(screen);
	  
	  
	  
  }

  @AfterClass
  public void endTasks(){
	  
	  App.close("Spotify");
  }

  
}
