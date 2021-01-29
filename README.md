## About the Project
The purpose of this project was to create a simple minecraft mod which, when the user dies or joins the game, a notification is sent to twitter. A secondary feature of the mod is any chat message is also broadcasted to their twitter.
This project uses [forge](https://mcforge.readthedocs.io/en/1.16.x/gettingstarted/) and gradle.
## File Structure

TweetDeath.java :
The main file. Sets up the mod & connects to the other two files.

EventHandling.java :
The file that checks for the events & runs the code for when each one occurs.

TwitterConfigs.java :
Sets up the configurations for twitter4j. In this code the spaces have placeholders text -- in order to run the code you'll need to replace the placeholder text with the api keys from twitter.
