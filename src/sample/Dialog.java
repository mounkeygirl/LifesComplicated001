package sample;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Dialog {

    //variables
    private ArrayList<String>text = new ArrayList<>();

    //constrctor
    public Dialog(){

    }
    public Dialog(String string){
        text.add(string);
    }

    //getters and setters
    public void setText(ArrayList<String> text){
        this.text = text;
    }

    public ArrayList<String> getText(){
        return text;
    }


    //add, or retrieve onesy style
    public void addLine(CHARACTERNAME speaker, String line){
        String output = speaker.getName()+": "+line;
        text.add(output);
    }

    public void addLine(String line){
        String output = line;
        text.add(output);
    }

    public String deque(){
        if(!text.isEmpty()){
            return text.remove(0);

        }else{
            return null;
        }

    }

    //output contents in system.out.println when button is clicked
    public void traverse(){
        System.out.println("System: Press the enter key to traverse through the text");
        while (!text.isEmpty()){
            try {
                System.in.read();
                System.out.println(deque());

            }catch (Exception e){
                System.out.println("Traverse exception in dialog class");
            }
        }


    }



}
