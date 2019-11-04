package sample;

public class RelationshipMap {

    private static Relationship[][] Relationships= new Relationship[CHARACTERNAME.values().length][CHARACTERNAME.values().length];

    //getter
    public Relationship getSingleRelationship(int callerEnumLocation, CHARACTERNAME secondCharacter){
        return Relationships[callerEnumLocation][secondCharacter.ordinal()];
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





}
