package sample;

public class Quest {
    //variables
    private String name;
    private SpecialConditions endConditions;
    private boolean completed=false;

    //constructers
    public Quest(String name){
        this.name = name;

    }

    //getters and setters
    public boolean getCompleted(){
        return completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpecialConditions getEndConditions() {
        return endConditions;
    }

    public void setEndConditions(SpecialConditions endConditions) {
        this.endConditions = endConditions;
    }

    //simple tasks
    public void completeTask(){
        completed=true;
    }

    //complex tasks

}
