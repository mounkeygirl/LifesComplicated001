package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Episode {
    //variables
    private Location startingLocation;
    private String title;
    private boolean complete=false;
    private HashMap<CHARACTERNAME, WORLD> newCharacterLocations = new HashMap<>();

    ///constructor
    public Episode(String title, Location startingLocation){
        this.title = title;
        this.startingLocation = startingLocation;
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
