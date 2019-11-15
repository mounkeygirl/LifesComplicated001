package sample;

import java.util.HashMap;

public enum EPISODELIST{
    TESTING, JAMES_GOES_TO_MAGIC_SCHOOL;

    //varibles
    private static Episode[] episodeList = setUpEpisode();

    //getters and setters
    public static Episode[] getEpisodeList() {
        return episodeList;
    }

    //setup variables
    private static Episode[] setUpEpisode(){
        Episode [] myEpisodeList = new Episode[EPISODELIST.values().length];

        //Add episodes to episodeList[]
        myEpisodeList[EPISODELIST.TESTING.ordinal()] = new Episode("Episode 1",CHARACTERNAME.MAY,(WORLD.SHIELDSHOME_KITCHEN));
        Episode modEpisode = myEpisodeList[EPISODELIST.TESTING.ordinal()];
        modEpisode.addCharacterToLocation(CHARACTERNAME.ZEA,WORLD.SHIELDSHOME_KITCHEN);
        modEpisode.addCharacterToLocation(CHARACTERNAME.JAMES,WORLD.SHIELDSHOME_KITCHEN);


        //I need to set starting location, starting main character, and episode title.
        //I Also need to make sure the main character is in the starting location
        myEpisodeList[EPISODELIST.JAMES_GOES_TO_MAGIC_SCHOOL.ordinal()] = new Episode("James Goes to Magic School",CHARACTERNAME.JAMES,WORLD.MAGICSCHOOL);
        modEpisode =myEpisodeList[EPISODELIST.JAMES_GOES_TO_MAGIC_SCHOOL.ordinal()];

        return myEpisodeList;
    }


    private static Location getLocation(WORLD world){
        return WORLD.getLocationFromWorld(world);

    }

    //for use in GameData
    public static Episode getEpisodeFromList(EPISODELIST episodeEnum){
        return episodeList[episodeEnum.ordinal()];
    }

    public static void startEpisode(EPISODELIST episodelistItem, GameData gameData){
        gameData.setEpisode(episodelistItem);
        //get player
        Human player = gameData.getPlayer();
        Episode episode = gameData.getEpisode();



        if(episode!=null){
            player.setCurrentLocation(episode.getStartingLocation());
            HashMap<CHARACTERNAME,WORLD> newLocations=gameData.getEpisode().getNewCharacterLocations();

            //retrieve character locations from episode details and update world locations
            for(HashMap.Entry<CHARACTERNAME,WORLD> entry : newLocations.entrySet()) {
                CHARACTERNAME charactername = entry.getKey();
                WORLD location = entry.getValue();
                addPersonToLocation(charactername,location);
            }

        } else {
            System.out.println("No Episode object slated to this EPISODELIST slot: "+episodelistItem.toString());
        }

    }


    //setting up location
    public static void addPersonToLocation(CHARACTERNAME charactername, WORLD location){
        //remove person from their last location
        Human human = CHARACTERNAME.getCharacterFromWorld(charactername);
        Location thisLocation = WORLD.getLocationFromWorld(location);

        if (human==null){
            System.out.println("No such character: "+charactername.toString());
        }

        Location oldLocation=human.getCurrentLocation();
        if(oldLocation !=null){
            oldLocation.removePersonPreesent(human);
        }
        //update episode data
        if (thisLocation == null){
            System.out.println("No such Location object in WORLD enum that for "+location.toString());
        } else {

            thisLocation.addPersonPresent(human);

        }

        //update character data
        human.setCurrentLocation(thisLocation);

    }
}