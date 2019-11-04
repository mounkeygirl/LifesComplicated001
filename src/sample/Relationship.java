package sample;

import java.util.ArrayList;

public class Relationship {
    //variables
    private int level;
    private ArrayList<Dialog> characterSpecificConversation=new ArrayList<>();


    //constructers
   public Relationship(int level){
        this.level = level;
   }

   public Relationship(){
        this.level = 1;
   }

   //getters, setters, and basic calls
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUp(int level){
        this.level+=level;
    }
    public void levelUp(){
        levelUp(1);
    }

    public ArrayList<Dialog> getCharacterSpecificConversation() {
        return characterSpecificConversation;
    }


    public void addToBackOfCharacterSpecificConversation(Dialog dialog){
        characterSpecificConversation.add(dialog);
    }

    public void addToBackOfCharacterSpecificConversation(ArrayList<Dialog> dialogArrayList){
        characterSpecificConversation.addAll(dialogArrayList);
    }

    public void addToFrontOfCharacterSpecificConversation(Dialog dialog){
        ArrayList<Dialog> conversation = new ArrayList<>();
        conversation.add(dialog);
        conversation.addAll(characterSpecificConversation);
        characterSpecificConversation = conversation;
    }

    public void addToFrontOfCharacterSpecificConversation(ArrayList<Dialog> dialogArrayList){
        ArrayList<Dialog> conversation = new ArrayList<>();
        conversation.addAll(dialogArrayList);
        conversation.addAll(characterSpecificConversation);
        characterSpecificConversation = conversation;
    }

    public Dialog dequeCharacterSpecificConversation(){
        Dialog nextLine = characterSpecificConversation.get(0);
       characterSpecificConversation.remove(0);
       return nextLine;
    }

}
