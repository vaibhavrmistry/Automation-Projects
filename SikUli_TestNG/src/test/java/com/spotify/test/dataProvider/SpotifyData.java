package com.spotify.test.dataProvider;

import com.spotify.test.TestData;

import org.testng.annotations.DataProvider;

public class SpotifyData {
	
	//Data provider class for parameterized tests	
	
  @DataProvider (name="validCreds")
  public static Object[][] validCreds() {
	  Object[][] retObjArr=TestData.getTableArray(0);
      return(retObjArr);
  }
  
  @DataProvider (name="inValidCreds")
  public static Object[][] inValidCreds() {
	  Object[][] retObjArr=TestData.getTableArray(1);
      return(retObjArr);
  }
  
  @DataProvider (name="searchArtist")
  public static Object[][] searchArtist() {
	  Object[][] retObjArr=TestData.getTableArray(2);
      return(retObjArr);
  }
  
  @DataProvider (name="searchSong")
  public static Object[][] searchSong() {
	  Object[][] retObjArr=TestData.getTableArray(3);
      return(retObjArr);
  }
  
  @DataProvider (name="invalidSearch")
  public static Object[][] invalidSearch() {
	  Object[][] retObjArr=TestData.getTableArray(4);
      return(retObjArr);
  }
  
  
  @DataProvider (name="addSong")
  public static Object[][] addSong() {
	  Object[][] retObjArr=TestData.getTableArray(5);
      return(retObjArr);
  }
  
}
