package com.spotify.test;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;


public class Login {
	
	private Screen m_screen;
	
	public Login() {
		// TODO Auto-generated constructor stub
		
		try{
			m_screen = new Screen();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public Screen setupAndGetScreen(){
	
		//Launch Spotify App
		App.open("Spotify");
		//wait for a few seconds
		m_screen.wait(2.0);
		//return screen
		return m_screen;
		
	}
	
	
	public void enterUsernameAndPassword(Screen screen, String username, String password){
		try{
			

		//clear the username field. Here since we are testing on Mac, Keys used are CMD+Backspace. For Windows it will be CTRL+Delete
		  screen.type(Util.m_username,Key.BACKSPACE,KeyModifier.CMD);
		//enter username
		  screen.type(Util.m_username,username);
		//clear the password field. Here since we are testing on Mac, Keys used are CMD+Backspace. For Windows it will be CTRL+Delete
		  screen.type(Util.m_password,Key.BACKSPACE,KeyModifier.CMD);
		//enter username
		  screen.type(Util.m_password,password);
		  
		}
		catch(FindFailed e){
			e.printStackTrace();
		}
		
		
	}
	
	
	public void loginWithRememberMe(Screen s, String username, String password){
		
		enterUsernameAndPassword(s, username, password);
		//find remember me icon
		try{
			//check if the remember me button is on
			if(s.exists(Util.m_rememberMeButton.exact()) != null){
				System.out.println("Remember me button on");
				s.click(Util.m_loginButton);
				
			}
			else{
				
				s.click(Util.m_rememberMeText.targetOffset(242, 0));
				System.out.println("Remember me button off");
				s.click(Util.m_loginButton);
			}

		}
		catch(FindFailed e){
			//remember me button must be off click on the remember me text

				e.printStackTrace();
		}
		
		
		
		
	}
	
public void loginWithoutRememberMe(Screen s, String username, String password){
		
		enterUsernameAndPassword(s, username, password);
		//find remember me icon
		try{
			//check if the remember me button is on
			if(s.exists(Util.m_rememberMeButton.exact()) != null){
				s.click(Util.m_rememberMeText.targetOffset(242, 0));
				System.out.println("Remember me button on");
				s.click(Util.m_loginButton);
				
			}
			else{
				System.out.println("Remember me button off");
				s.click(Util.m_loginButton);
			}

		}
		catch(FindFailed e){
			//remember me button must be off

				e.printStackTrace();
		}
		
	}



	
	
	public Screen loginWithFacebook(Screen s){
		
		try{
			s.click(Util.m_facebookLogin);
			s.wait(Util.m_loginOptions,10.0);
			s = new Screen();
			
		}
		catch(FindFailed e){
				e.printStackTrace();
		}
		return s;
	}
	
	public Screen rememberTestsReOpenApp(Screen s){
		 
		try{	
		  App.close("Spotify");
		  //wait for 3 secs
		  s.wait(3.0);
		  //re open app
		  App.open("Spotify");
		  s = new Screen();
		  //wait until searchbar appears. Max time 10 secs
		  s.wait(Util.m_loginOptions,10.0);
		}
		catch(FindFailed e){
			e.printStackTrace();
		}
		return s;
		
	}
	
}
