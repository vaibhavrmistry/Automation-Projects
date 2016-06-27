package com.spotify.test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;


public class Play {
		
	//provides methods to support PlayTests
	
	//return screen after playing the last played song
	public Screen playGeneral(Screen s){
		
		try{
			s.click(Util.m_play_general);
			s = new Screen();
			
		}
		catch(FindFailed e){
			e.printStackTrace();
			
		}
		return s;
		
	}
	
	//return screen after searching for a song and playing it
	public Screen playSong(Screen s, String songname){
		
		try{
			Search search = new Search();
			s = search.searchSong(s, songname);
			s.click(Util.m_song_search.targetOffset(-350, 0));
			s = new Screen();
			
		}
		catch(FindFailed e){
			e.printStackTrace();
			
		}
		return s;
		
		
	}
	
	
	//return screen after playing the album 
	public Screen playAlbum(Screen s, String songname) {
		
		try{
			Search search = new Search();
			s = search.searchSong(s, songname);
			s.click(Util.m_play_song);
			s = new Screen();
			
		}
		catch(FindFailed e){
			e.printStackTrace();
			
		}
		return s;
		
	}
	
	
	//pause the song
	public void pauseSong(Screen s){
		
		try{
			s.click(Util.m_pause_general);
			
		}
		catch(FindFailed e){
			e.printStackTrace();
		}
		
	}
	
	
	
}
