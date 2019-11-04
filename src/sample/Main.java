package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private GameData gameData = new GameData();
    Label outputLbl = new Label(gameData.getTextOutput());
    Label selectOptionLbl = new Label("");

    @Override
    public void start(Stage primaryStage) throws Exception{
        //set stage
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Life's Complicated");

        //use a border Pane
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10,10,10,10));

        int sceneWidth = 800;
        Scene scene = new Scene(bPane, sceneWidth, 400);

        //create info labels
        VBox infoVBox = new VBox();

        infoVBox.getChildren().add(new Label("Player Name: "));
        infoVBox.getChildren().add(new Label(gameData.getPlayer().getName()));
        infoVBox.getChildren().add(new Label("Current Location: "));
        infoVBox.getChildren().add(new Label(gameData.getPlayer().getCurrentLocation().getName()));
        //add infobox to grid
        bPane.setTop(infoVBox);

        //add text output box
        outputLbl.setBorder(new Border(new BorderStroke(Color.CHOCOLATE,BorderStrokeStyle.SOLID,null,new BorderWidths(5))));
        outputLbl.setPrefSize(sceneWidth,100);
        outputLbl.setPadding(new Insets(5,5,5,5));
        outputLbl.setAlignment(Pos.TOP_LEFT);

        //make a hbox to contain the options
        HBox selectOptionBx = new HBox();
        selectOptionBx.setBorder(new Border(new BorderStroke(Color.DARKGREEN,BorderStrokeStyle.SOLID,null,new BorderWidths(5))));
        selectOptionBx.setPrefSize(300,100);
        selectOptionBx.setPadding(new Insets(5,5,5,5));
        selectOptionBx.setVisible(false);

//        selectOptionLbl.setBorder(new Border(new BorderStroke(Color.DARKGREEN,BorderStrokeStyle.SOLID,null,new BorderWidths(5))));
        selectOptionLbl.setPrefSize(300,100);
        selectOptionLbl.setPadding(new Insets(5,5,5,5));
        selectOptionLbl.setVisible(false);
        bPane.setCenter(selectOptionLbl);

        //create buttons
        Button lookAroundBtn = new Button("Look Around");
        lookAroundBtn.setOnAction(event -> {
            outputLbl.setText(gameData.lookAround());
        });

        Button talkToBtn = new Button("Talk to");
        talkToBtn.setOnAction(event -> {
            talkToBtnClicked();
        });

        Button exitBtn = new Button("Exit");
        exitBtn.setOnAction(event ->exitBtnClicked());

        //put Game buttons in one box
        HBox gameButtons = new HBox(10);
        gameButtons.getChildren().add(lookAroundBtn);
        gameButtons.getChildren().add(talkToBtn);

        //put exit button in seperate box
        HBox windowButtons = new HBox(10);
        windowButtons.getChildren().add(exitBtn);
        windowButtons.setAlignment(Pos.BOTTOM_RIGHT);

        //output box and buttons will be on bottem in vbox
        BorderPane bottomChunk = new BorderPane();
        bottomChunk.setTop(outputLbl);

        //add button boxes to grid
        VBox bottemVBox = new VBox();
        bottomChunk.setBottom(bottemVBox);
        bottemVBox.getChildren().add(gameButtons);
        bottemVBox.getChildren().add(windowButtons);
        bPane.setBottom(bottomChunk);

        //set scene and display stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void talkToBtnClicked(){
        //update output box
        outputLbl.setText(gameData.whoIsHere());
        selectOptionLbl.setText("Who do you want to talk to?");
        selectOptionLbl.setVisible(true);
    }

    private void exitBtnClicked(){
        System.exit(0);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
