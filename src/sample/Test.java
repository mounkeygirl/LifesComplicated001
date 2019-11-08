package sample;

public class Test {
    public static void main(String[] args) {
        GameData gameData = new GameData(EPISODELIST.JAMES_GOES_TO_MAGIC_SCHOOL,CHARACTERNAME.JAMES);


        gameData.lookAround();

        while(true==true){

            gameData.selectAction();

        }

    }
}
