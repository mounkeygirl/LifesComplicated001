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
        myEpisodeList[EPISODELIST.TESTING.ordinal()] = new Episode("Episode 1",WORLD.getLocationFromWorld(WORLD.SHIELDSHOME_KITCHEN));
        Episode modEpisode = myEpisodeList[EPISODELIST.TESTING.ordinal()];
        modEpisode.addCharacterToLocation(CHARACTERNAME.ZEA,WORLD.SHIELDSHOME_KITCHEN);
        modEpisode.addCharacterToLocation(CHARACTERNAME.JAMES,WORLD.SHIELDSHOME_KITCHEN);

        myEpisodeList[EPISODELIST.JAMES_GOES_TO_MAGIC_SCHOOL.ordinal()] = new Episode("James Goes to Magic School",getLocation(WORLD.MAGICSCHOOL));
        modEpisode =myEpisodeList[EPISODELIST.JAMES_GOES_TO_MAGIC_SCHOOL.ordinal()];
        modEpisode.addCharacterToLocation(CHARACTERNAME.JAMES,WORLD.MAGICSCHOOL);

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
                gameData.addPersonToLocation(charactername,location);
            }

        } else {
            System.out.println("No Episode object slated to this EPISODELIST slot: "+episodelistItem.toString());
        }

    }
}