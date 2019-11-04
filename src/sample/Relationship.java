package sample;

import java.util.ArrayList;

public class Relationship {
    //variables
    private int level=1;
    private ArrayList<Dialog> characterSpecificConversation=new ArrayList<>();


    //constructers
   public Relationship(int level){
        this.level = level;
   }

   public Relationship(){

   }

   //if relationship initilized with a dialog, that is the first conversation
   public Relationship(Dialog dialog){
       characterSpecificConversation.add(dialog);
   }

   //might just want to have a two line exchange as first conversation, so I'll initlize that form
   public Relationship(CHARACTERNAME charactername1, String string1, CHARACTERNAME charactername2, String string2){
       Dialog dialog = new Dialog();
       dialog.addLine(charactername1,string1);
       dialog.addLine(charactername2,string2);
       characterSpecificConversation.add(dialog);

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
