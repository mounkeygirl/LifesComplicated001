package sample;

import java.util.ArrayList;

public class RelationshipMap {

    private static Relationship[][] Relationships= new Relationship[CHARACTERNAME.values().length][CHARACTERNAME.values().length];

    //constructer
    public RelationshipMap(){
        //use for modifying relationships
        Relationship relationship;
        Dialog dialog = new Dialog();
        //add relations to here
        createRelationship(CHARACTERNAME.MAY,CHARACTERNAME.JAMES);
        relationship = getSingleRelationship(CHARACTERNAME.MAY,CHARACTERNAME.JAMES);
        dialog.addLine(CHARACTERNAME.MAY,"Morning James.");
        dialog.addLine(CHARACTERNAME.JAMES,"Morin' May.");
        relationship.addToFrontOfCharacterSpecificConversation(dialog);


    }

    //getter
    public Relationship getSingleRelationship(int callerEnumLocation, CHARACTERNAME secondCharacter){
        return Relationships[callerEnumLocation][secondCharacter.ordinal()];
    }

    public Relationship getSingleRelationship(CHARACTERNAME primaryCharacter, CHARACTERNAME secondCharacter){
        return Relationships[primaryCharacter.ordinal()][secondCharacter.ordinal()];
    }

    //used specifically in the Human class basic build
    public void createSelfRelationship(int enumLocation){
        Relationships[enumLocation][enumLocation]=new Relationship();
    }

    public void createRelationship(int enumLocation, CHARACTERNAME secondaryCharacter){
        Relationship relationship=new Relationship();
        Relationships[enumLocation][secondaryCharacter.ordinal()]=
                Relationships[secondaryCharacter.ordinal()][enumLocation]=relationship;

    }

    public void createRelationship(CHARACTERNAME primaryCharacter, CHARACTERNAME secondaryCharacter){
        Relationship relationship=new Relationship();
        Relationships[primaryCharacter.ordinal()][secondaryCharacter.ordinal()]=
                Relationships[secondaryCharacter.ordinal()][primaryCharacter.ordinal()]=relationship;

    }





}
