# Spotify Automation Assignment

This automation framework is build using TestNG and Sikuli Java API to test the desktop client of Spotify on Mac OS X.

#### Scenarios covered:
- Login
- Search
- Play
- My Songs (Add/Remove) - My Extra Feature 

#### My Songs (Add/Remove) 

> I chose to test this feature because personally I use this feature on regular basis. Whenever I come across a new song (via friends suggestion or personal exploration) I add the song to "My Songs". So the next time I want to hear that song I dont have to search for it again.

### Requirements / Assumtions
* Spotify desktop client installed on Mac OS X
* Active internet connection
* Spotify Backend services working
* A valid Facebook account logged in the default browser (for facebook login test)

### Limitations
As Sikuli is based on OCR technology and Tessaract which are still in development stages and not too reliable, a few of the Search Tests and Play Tests have images as verifications. Although the tests are parameterized though data from Excel, if a new song/artist search needs to be added, a screen capture of that song/artist need to be added in the code.

### Installation

* Install Java 1.6 or higher
* Eclipse and TestNG plugin installed for Eclipse to run the tests.

Refer http://toolsqa.com/selenium-webdriver/install-testng/ for installation of TestNG plugin

### Run
Import the project in Eclipse and Right click on testNG.xml 
```sh
Run As > TestNG Suite
```
### Results

Results can be viewed either in console or an HTML page (index.html) is created in the test-output folder.