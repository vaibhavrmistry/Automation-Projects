package com.spotify.test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;

public class Search {
	
	//Search class with methods supporting the searchTest
	
	
	//return screen after a search text is entered to check suggestions
	public Screen searchSuggest(Screen s, String searchString){
		
		try{
		//clear the search field
		s.type(Util.m_searchbar,Key.BACKSPACE,KeyModifier.CMD);
		//enter the text 
		s.type(Util.m_searchbar, searchString);
		s = new Screen();
		
		}
		catch(FindFailed e){
			e.printStackTrace();
		}
		return s;
		
	}
	
	//return screen after a search text and show all pressed
	public Screen searchAll(Screen s, String searchString, boolean key){
		
		try{
		s = searchSuggest(s, searchString);
		if(!key)
			s.click(Util.m_showAll_suggest);
		else
			s.type(Util.m_searchbar,Key.ENTER);
		s.wait(2.0);
		s = new Screen();
		}
		catch(FindFailed e){
			e.printStackTrace();
		}
		return s;
	}
	
	//return screen after search field is clicked for recent searches
	public Screen searchRecent(Screen s){
		
		try{
			s.click(Util.m_searchbar);	
			s.wait(Util.m_showAll_suggest, 2.0);
			s = new Screen();
			}
			catch(FindFailed e){
				e.printStackTrace();
			}
			return s;
		
	}
	
	
	//search song and return screen of suggestions
	public Screen searchSong(Screen s, String song){
		
		try{
			s = searchSuggest(s, song);
			s.click(Util.m_song_suggest);
			s = new Screen();
			
		}
		catch(FindFailed e){
			e.printStackTrace();
		}
		
		return s;
		
	}
	
	
	
	
	
	

}
