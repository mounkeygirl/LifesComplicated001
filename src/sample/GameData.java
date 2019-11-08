package sample;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameData {
    //private class for internal use
    private class MetaData{
        //variables
        String string;
        int position;
    }



    private Human player;
    private Human[] characterList= new Human[CHARACTERNAME.values().length];
    private Location[] world = WORLD.getWorld();
    private Episode[] episodeList = EPISODELIST.getEpisodeList();
    private Episode episode;
    private String textOutput="testing";
    private static ArrayList<Option> tempOptionList=new ArrayList<>();



    //Initiate Gamedata
    public GameData(EPISODELIST startingEpisode, CHARACTERNAME charactername){
        //add characters to world
        setCharacterToList(CHARACTERNAME.JINDRICH);
        setCharacterToList(CHARACTERNAME.NOEL);
        setCharacterToList(CHARACTERNAME.CACILIUS);
        setCharacterToList(CHARACTERNAME.MAY);
        setCharacterToList(CHARACTERNAME.ZEA);
        setCharacterToList(CHARACTERNAME.JAMES);

        //establish Player(Who is one of the characters)
        player=getCharacter(charactername);

        //establish starting episode
        startEpisode(startingEpisode);
    }

    public GameData(){
        new GameData(EPISODELIST.TESTING, CHARACTERNAME.MAY);
    }



    //getters and setters
    public Human getPlayer() {
        return player;
    }

    public Human[] getCharacterList() {
        return characterList;
    }

    public Human getCharacter(CHARACTERNAME charactername){
        return characterList[charactername.ordinal()];

    }

    private void setCharacterToList(CHARACTERNAME charactername){
        int number = charactername.ordinal();
        characterList[number] = new Human(charactername);
    }


    public void setEpisode(EPISODELIST episodeEnum){
        this.episode =episodeList[episodeEnum.ordinal()];

    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public Episode getEpisode() {
        return episode;
    }

    public String getTextOutput() {
        return textOutput;
    }

    //setting up location
    public void addPersonToLocation(CHARACTERNAME charactername, WORLD location){
        //remove person from their last location
        Human human = characterList[charactername.ordinal()];

        if (human==null){
            System.out.println("No such character: "+charactername.toString());
        }

        Location oldLocation=human.getCurrentLocation();
        if(oldLocation !=null){
            oldLocation.removePersonPreesent(characterList[charactername.ordinal()]);
        }
        //update episode data
        Location newLocation = world[location.ordinal()];

        if (newLocation == null){
            System.out.println("No such Location object in WORLD enum that for "+location.toString());
        } else {

            newLocation.addPersonPresent(human);

        }

        //update character data
        characterList[charactername.ordinal()].setCurrentLocation(world[location.ordinal()]);

    }

    public static void addOptionToTempOptionList(OPTIONLIST option){
        tempOptionList.add(OPTIONLIST.getOption(option));
    }


    //interact with world
    public String lookAround(){
        String output =player.whereAmI();
        System.out.println(output);

        return output;

    }

    public String whereAmI(){
        return lookAround();
    }

    public String whoIsHere(){
        String output =player.whoIsHere();
        System.out.println(output);
        return output;

    }

    public Dialog talkTo(CHARACTERNAME charactername){
        Dialog output=player.greet(charactername);
        output.traverse();
        return output;
    }
    public Dialog talkTo(Human charactername){
            CHARACTERNAME optionEnum=null;
            int searchValue = 0;
            Dialog output = new Dialog("No option found matching "+charactername.getName());
            for (Human item:characterList
            ) {
                if (charactername.equals(item)){
                    optionEnum =CHARACTERNAME.values()[searchValue];

                    //if I get a hit call the CHARACTERNAME version of talk to
                    return output=talkTo(optionEnum);

                }
                searchValue++;
            }
                // if I don't get a hit, return error message if no option is found
        output.traverse();
        return output;
    }

    public void talkToBySelection(){
        System.out.println("I CHOOSE TO TALK TO THE PIPOOPLES!!!");
        String talkToOutput="";
        int optionNumber = 0;
        ArrayList<Human> peoplePresent = new ArrayList<>();
        for (Human human: player.getCurrentLocation().getPeoplePresent()
        ) {
            if (optionNumber>0){
                talkToOutput+="\n";
            }

            talkToOutput+=optionNumber++ +") "+human.getName();
            peoplePresent.add(human);

        }
        System.out.println("Who do you want to talk to?");
        System.out.println(talkToOutput);

        //select person
        Scanner scanner = new Scanner(System.in);
        boolean realChoice=false;

        while (realChoice==false) {

            try {

                System.out.println("Please select an action");
                int selection = scanner.nextInt();

                int maxSize = peoplePresent.size() - 1;
                if (selection < 0 || selection > maxSize) {
                    System.out.println("Please select from the available numbers.");
                    continue;
                }

                realChoice = true;


                Human option= peoplePresent.get(selection);
                String output = "You selected "+selection+": "+option.getName();
                System.out.println(output);
                talkTo(option);

            } catch (InputMismatchException e) {
                System.out.println("That is not a valid number. Please try again.");
                //discard all data entered by the user
                scanner.nextLine();
                continue;
            }
        }
    }


    private String whatCanIDo(){

        //I needed to update a multiple things after running a function,
        //So i made a special metadata class
        MetaData metaData = new MetaData();

        String output=metaData.string="";
        int optionNumber=metaData.position=0;
        //make sure to flush temp option list before filling it out again
        tempOptionList=new ArrayList<>();

        // list out options
        metaData=addOption(OPTIONLIST.LOOKAROUND,metaData);

        //only add talk to someone if there are options present
        if(player.getCurrentLocation().isAnyoneHere()==true){
            metaData=addOption(OPTIONLIST.TALKTOSOMEONE,metaData);
        }


        //always add goback after the if statments
        metaData=addOption(OPTIONLIST.GOBACK,metaData);

        //add quit to end
        metaData=addOption(OPTIONLIST.QUITPROGRAM,metaData);


        output = metaData.string;
        System.out.println(output);
        return output;
    }

    private MetaData addOption(OPTIONLIST newOptionEnum, MetaData metaData){
        addOptionToTempOptionList(newOptionEnum);
        Option newOption = OPTIONLIST.getOption(newOptionEnum);
         metaData.string += "\n"+metaData.position++ + ") "+ newOption.getName();
         return metaData;
    }

    public void goTo(WORLD location){
        player.setCurrentLocation(world[location.ordinal()]);
        whereAmI();
    }


    //To make this more game like, the player needs some choices
    public void selectAction(int actionNumber){
        Option option= tempOptionList.get(actionNumber);
        String output = "You selected "+actionNumber+": "+option.getName();
        System.out.println(output);

        //get enum for switch statement
        OPTIONLIST optionEnum=OPTIONLIST.getOptionEnum(option);

        //select next move based on what was selected
        switch (optionEnum){
            case TALKTOSOMEONE:
                talkToBySelection();
                break;
            case GOBACK:
                System.out.println("I GO BACK NOWSSS!");
                break;
            case QUITPROGRAM:
                System.exit(0);
                break;
            case LOOKAROUND:
                lookAround();
                break;
            default:
                System.out.println("MY OPTION HAS NOT BEEN PROGRAMEDEDED!!!?!! ANNA! DO THE THING!!!");

        }

    }

    public void selectAction(){
        Scanner scanner = new Scanner(System.in);
        boolean realChoice=false;
        System.out.println("Here are your options:");
        whatCanIDo();

        while (realChoice==false){

            try{

                System.out.println("Please select an action");
                int selection = scanner.nextInt();

                int maxSize= tempOptionList.size()-1;
                if (selection<0 || selection>maxSize){
                    System.out.println("Please select from the available numbers.");
                    continue;
                }

                realChoice=true;
                selectAction(selection);

            }
            catch (InputMismatchException e){
                System.out.println("That is not a valid number. Please try again.");
                //discard all data entered by the user
                scanner.nextLine();
                continue;
            }

        }




    }

    private void startEpisode(EPISODELIST episode){
        EPISODELIST.startEpisode(episode,this);

    }










}
