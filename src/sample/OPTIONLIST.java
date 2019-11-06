package sample;

import java.lang.reflect.Array;

public enum OPTIONLIST {
    TALKTOSOMEONE, LOOKAROUND, GOBACK, QUITPROGRAM;

    private static Option[] optionList = initilizeOptionList();

    private static Option[] initilizeOptionList(){
        Option[] myNewList=new Option[OPTIONLIST.values().length];
        myNewList[TALKTOSOMEONE.ordinal()]=new Option("Talk to someone");
        myNewList[GOBACK.ordinal()]= new Option("Go Back");
        myNewList[QUITPROGRAM.ordinal()]= new Option("Quit Program");
        myNewList[LOOKAROUND.ordinal()]= new Option("Look Around");
        return myNewList;

    }

    public static Option getOption(OPTIONLIST optionEnum){
        return optionList[optionEnum.ordinal()];
    }

    public static OPTIONLIST getOptionEnum(Option option){
        OPTIONLIST optionEnum=null;
        int searchValue = 0;
        for (Option item:optionList
             ) {

            if (option.equals(item)){
                optionEnum =OPTIONLIST.values()[searchValue];
                return optionEnum;
            }
            searchValue++;
            
        }

        //return error message if no option is found
        System.out.println("No option found matching "+option.getName());
        return optionEnum;

    }
}
