package sample;

public enum WORLD {
    SHIELDSHOME_MAYSROOM, SHIELDSHOME_KITCHEN,
    TENGUHILL,MAGICSCHOOL;

    //variables
    private static Location[] world = setUpWorld();

    //getters and setters
    public static Location[] getWorld() {
        return world;
    }

    public static Location getLocationFromWorld(WORLD locationEnum){
        return world[locationEnum.ordinal()];
    }

    //variable setup
    private static Location[] setUpWorld(){
        Location[] locations = new Location[WORLD.values().length];

        //add locations to the world
        locations[WORLD.SHIELDSHOME_MAYSROOM.ordinal()]=  new Location("May's Room");
        locations[WORLD.SHIELDSHOME_KITCHEN.ordinal()]=  new Location("Shields' Kitchen");
        locations[WORLD.TENGUHILL.ordinal()]=new Location("Tengu Hill");
        locations[WORLD.MAGICSCHOOL.ordinal()]=new Location("Magic School");


        return locations;
    }


//    private static void setLocationToWorld(WORLD locationEnum, String stringName){
//        int number = locationEnum.ordinal();
//        world[number] = new Location(stringName);
//    }
}
