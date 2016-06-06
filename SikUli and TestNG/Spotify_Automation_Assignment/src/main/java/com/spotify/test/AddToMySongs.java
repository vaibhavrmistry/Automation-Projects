package com.spotify.test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class AddToMySongs {
	
	//class to support the addToMySongsTest
	
	
	//return screen after adding a song to my Songs
	public Screen addToMySongs(Screen screen, String song){
		
		try{
			screen.type(Util.m_searchbar, song);
			screen = new Screen();
			screen.click(Util.m_song2_suggest);
			screen.wait(1.0);
			screen.click(Util.m_song2_search);
			screen.wait(1.0);
			screen.click(Util.m_mySongs);
			screen.wait(1.0);
			screen = new Screen();
			
		}
		catch(FindFailed e){
			e.printStackTrace();
		}
		
		return screen;
		
	}
	
	//return screen after removing the song from the my songs
	public Screen removeFromMySongs(Screen screen, String song){
		
		try{
			screen.click(Util.m_mySongs);
			screen.wait(1.0);
			screen.click(Util.m_song2_search.targetOffset(-123, 0));
			screen = new Screen();
			
		}
		catch(FindFailed e){
			e.printStackTrace();
		}
		
		return screen;
		
		
	}
	
	
	
}
