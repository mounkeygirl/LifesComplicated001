package sample;

import java.util.ArrayList;

public class Location {
    private String name;
    private String desctiption;
    private ArrayList<Human> peoplePresent= new ArrayList<>();


    //constructors
    public Location(String name) {
        this.name = name;
    }

    public Location(String name, String desctiption) {
        this.name = name;
        this.desctiption = desctiption;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }

    public ArrayList<Human> getPeoplePresent() {
        return peoplePresent;
    }

    public void setPeoplePresent(ArrayList<Human> peoplePresent) {
        this.peoplePresent = peoplePresent;
    }

    //fiddly bits
    public void addPersonPresent(Human human){

        peoplePresent.add(human);
    }

    public void removePersonPreesent(Human human){

        peoplePresent.remove(human);
    }

    public String whoIsHere(){
        String output="Other characters present: ";
        for (Human personInRoom: this.getPeoplePresent()
        ) {
            output+=personInRoom.getName()+", ";

        }
        output+="\n";

        return  output;
    }

    public String whereAmI(){
        Location location = this;

        String name = location.getName();
        String description = location.getDesctiption();
        String output="Current Location: "+name+".";

        if (description != null){
            output +="\n"+description ;
        }
        if (location.getPeoplePresent().isEmpty()!=true){
            output+="\n"+whoIsHere();
        }

        return output;
    }

    public boolean isAnyoneHere(){
        if(peoplePresent.isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }
}
