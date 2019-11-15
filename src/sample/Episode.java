package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Episode {
    //variables
    private Location startingLocation;
    private String title;
    private boolean complete=false;
    private Human mainCharacter;
    private HashMap<CHARACTERNAME, WORLD> newCharacterLocations = new HashMap<>();

    //I need to set starting location, starting main character, and episode title.
    //I Also need to make sure the main character is in the starting location
    //Failure to set main character in starting location causes error
    ///constructor
    public Episode(String title, CHARACTERNAME mainCharacterEnum, WORLD startingLocation){
        this.title = title;
        this.startingLocation = WORLD.getLocationFromWorld(startingLocation);
        this.mainCharacter =CHARACTERNAME.getCharacterFromWorld(mainCharacterEnum);

        //update locations of character
        EPISODELIST.addPersonToLocation(mainCharacterEnum,startingLocation);

    }


    //getters and setters
    public Location getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(Location startingLocation) {
        this.startingLocation = startingLocation;
    }

    public boolean getComplete(){
        return complete;
    }

    public Human getMainCharacter(){
        return mainCharacter;
    }

    public HashMap<CHARACTERNAME, WORLD> getNewCharacterLocations() {
        return newCharacterLocations;
    }

    public void completeEpisode(){
        complete = true;
    }

    public void addCharacterToLocation(CHARACTERNAME charactername, WORLD world){
        newCharacterLocations.put(charactername,world);
    }






}
