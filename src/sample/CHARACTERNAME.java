package sample;

public enum CHARACTERNAME {
    JINDRICH, NOEL, CACILIUS,
    MAY, ZEA, JAMES;


    public String getName(){
                            /*convert Enum name to string,
            Convert string to lower case
            Make first letter capitalized
             */
        String name =this.toString().toLowerCase();
        return name.substring(0,1).toUpperCase()+name.substring(1);
    }


}
