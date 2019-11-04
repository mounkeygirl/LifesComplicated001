package sample;

import java.util.ArrayList;

public class Human {

    //variables
    private String name;
    private int level=1;
    private String defaultIntroduction;
    private Relationship[][] Relationships= new Relationship[CHARACTERNAME.values().length][CHARACTERNAME.values().length];
    private Location currentLocation;
    //Enum Number will be useful to have on hand for reference
    private int enumLocation;
    //I want to make dialog system for each possible character so...
    //dialog can be of any length, but there are set relationships
    //so I think the best thing to do is make a seperate system




    //constructors
    public Human (CHARACTERNAME charactername){
        name = charactername.getName();
        enumLocation=charactername.ordinal();
        defaultIntroduction=name+": Hello my name is "+name +" it is nice to meet you";
        //Create relationship with self. Currently no plan to, but might be an interesting feature,
        //No reason to stop program if called
        Relationships[enumLocation][enumLocation]=new Relationship();
    }


    //getters and setters
    public String getName() {
        return name;
    }

    public String getDefaultIntroduction() {
        return defaultIntroduction;
    }

    public void setDefaultIntroduction(String defaultIntroduction) {
        this.defaultIntroduction = defaultIntroduction;
    }

    public Relationship[][] getRelationships() {
        return Relationships;
    }
    //get/set single relationships
    public Relationship getRelationship(CHARACTERNAME charactername){
        if(charactername.ordinal()==enumLocation){
            System.out.println("You are currently looking at the relationship one character has with himself or herself\n" +
                    "Was this intentional?");
        }

            return Relationships[enumLocation][charactername.ordinal()];
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    //meta help

    public String whereAmI(){
        String answer = currentLocation.whereAmI();
        return answer;
    }

    public String whoIsHere(){
        String answer = currentLocation.whoIsHere();
        return answer;
    }


    //interact with world
    public Dialog greet(CHARACTERNAME charactername){
        Relationship relationship = getRelationship(charactername);
        Dialog output= new Dialog();
        String greeting = "Hello "+charactername.getName();
        //if there is no established relationship create a new one,
        // set 2 dim array in both directions,
        // and give introductions
        if (relationship==null){
            output = checkIfFirstMeeting(charactername);


        } else if(charactername.ordinal()==enumLocation){
            greeting="Hello me.";
            output.addLine(greeting);
        } else {
            output =checkSpecialDialog(charactername);
        }

        //save traverse option for gamedata implmentation
//        output.traverse();
        return output;

    }

    //returns greeting as string
    private Dialog checkIfFirstMeeting(CHARACTERNAME charactername){
        Relationship relationship = getRelationship(charactername);
        String greeting = "";
        Dialog dialog = new Dialog();
        //if there is no established relationship create a new one,
        // set 2 dim array in both directions,
        // and give introductions
        if (relationship==null){
            relationship=new Relationship();
            Relationships[enumLocation][charactername.ordinal()]=
                    Relationships[charactername.ordinal()][enumLocation]=relationship;

            dialog.addLine(defaultIntroduction);
            dialog.addLine(charactername,"And my name is "+charactername.getName()+". It is nice to meet you.");

        }
        //if relationship isn't null, will return blank

        return dialog;

    }

    private Dialog checkSpecialDialog(CHARACTERNAME charactername){
        Relationship relationship = Relationships[enumLocation][charactername.ordinal()];

        if (!relationship.getCharacterSpecificConversation().isEmpty()){
            return relationship.dequeCharacterSpecificConversation();


        } else  {
            Dialog dialog = new Dialog();
            String speech = "This is a test for the special dialog system. There is no special dialog between "+name+ " and "+charactername.getName()+".";
            dialog.addLine(speech);
            return dialog;
        }

    }

}
