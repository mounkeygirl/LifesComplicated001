package sample;

public enum CHARACTERNAME {
    JINDRICH, NOEL, CACILIUS,
    MAY, ZEA, JAMES;

    //variables
    private static Human[] characterList=initilizeCharacterList();

    //initlizing variables
    private static Human[] initilizeCharacterList(){
        Human[] list = new Human[CHARACTERNAME.values().length];
        //add characters to world
        setCharacterToList(CHARACTERNAME.JINDRICH,list);
        setCharacterToList(CHARACTERNAME.NOEL,list);
        setCharacterToList(CHARACTERNAME.CACILIUS,list);
        setCharacterToList(CHARACTERNAME.MAY,list);
        setCharacterToList(CHARACTERNAME.ZEA,list);
        setCharacterToList(CHARACTERNAME.JAMES,list);


        return list;
    }

    //getters and setters

    private static void setCharacterToList(CHARACTERNAME charactername,Human[]tempList){


        try {


            int number = charactername.ordinal();
//            characterList[charactername.ordinal()] = new Human(charactername);
            Human human =new Human(charactername);
            tempList[number] = human;
        } catch (Error error){
            System.out.println("Failure Adding characterlist["+charactername.ordinal()+"]"+"with human" + "charactername to list section of the GameData section");

//            System.out.println("Adding characterlist["+number  +"]"+"with human" + charactername);

            System.out.println(error.getMessage());
        }
    }

    public static Human getCharacterFromWorld(CHARACTERNAME charactername){
        return characterList[charactername.ordinal()];
    }

    public static Human[] getCharacterList(){
        return characterList;
    }

    //return name version of enum
    public String getName(){
                            /*convert Enum name to string,
            Convert string to lower case
            Make first letter capitalized
             */
        String name =this.toString().toLowerCase();
        return name.substring(0,1).toUpperCase()+name.substring(1);
    }


}
