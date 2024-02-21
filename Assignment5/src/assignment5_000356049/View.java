package assignment5_000356049;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.InputStream;

/**
 * This assignment is about using GUI components to create a user-friendly view for an object or
 * set of objects that serve as the model.
 *
 * @author TRUNG KIEN, BUI
 */
public class View extends Application {

    // TODO: Instance Variables for View Components and Model
    /**
     * Declare buttons for rock, paper and scissors
     */
    private Button rockButton, paperButton, scissorsButton;
    /**
     * Declare text field for updating player score, computer score, and computer choice
     */
    private TextField resultText, computerText;
    /**
     * Declare an instruction message for the game
     * "Please choose one of those 3 selections above"
     */
    private Text instructionMessage;
    /**
     * Association relationship of Model class, used to call methods and return Model
     * toString to update player/comp score and computer choice each play
     */
    private Model model;
    /**
     * Declare canvas to draw background color
     */
    private Canvas canvas;
    /**
     * Declare label for how to play instruction
     */
    private Label label;
    /**
     * Declare gc to draw canvas
     */
    private GraphicsContext gc;

    // TODO: Private Event Handlers and Helper Methods

    /**
     * Represent Rock button
     *
     * @param "rock"
     */
    private void handlerRockButton(ActionEvent e) {
        userPlays("rock"); //display "rock" as user choice when user clicks Rock button
    }

    /**
     * Represent Paper button
     *
     * @param "paper"
     */
    private void handlerPaperButton(ActionEvent e) {
        userPlays("paper"); //display "paper" as user choice when user clicks Paper button
    }

    /**
     * Represent Scissors button
     *
     * @param "scissors"
     */
    private void handlerScissorsButton(ActionEvent e) {
        userPlays("scissors"); //display "scissors" as user choice when user clicks Scissors button
    }

    /**
     * Method used to print in TextField and return what computer choice is by
     * calling getComputerPlays() method from Model class.
     */
    public void getComputerMove() {
        String computerChoice = model.getComputerPlays(); // get computer choice by calling getComputerPlays method from Model class save it to computerChoice String
        computerText.setText("Computer played: " + computerChoice.toUpperCase()); //set computerText TextField to "String" + computerChoice String
    }

    /**
     * Method for updating score of player and computer.
     */
    private void updateScoreBoard() {
        String scoreBoard = model.getScoreboard(); //call toString method from Model class to return new comp + player score each play and save it to scoreBoard String
        resultText.setText(resultText.getText() + scoreBoard); // overwrite new resultText TextField over the old resultText TextField
    }

    /**
     * Method is for connecting to 3 button handlers, returning the winner, updating score board, and updating computer choice.
     *
     * @param playerMove
     */
    private void userPlays(String playerMove) {
        String result = model.play(playerMove); // pass the player choice when they click a button, play method is called in Model class save it to String(result)
        resultText.setText(result + " ");       // and compare the computer/ player choice and return the result message(who wins).
                                                // play method also has the point counter, +1 to who wins that round. setText is used to update a winner message and add a space between
        updateScoreBoard(); // call updateScoreBord method to update current score for player and computer.
        getComputerMove(); // called to update the CURRENT computer choice message
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 800); // set the size here
        stage.setTitle("Rock Paper Scissors Game"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model

        //Create the object named "model"
        model = new Model();

        //This is the link for method that is not taught in class: https://stackoverflow.com/questions/32825846/how-to-set-image-using-javafx
        //The reason I chose this method is that I want to have images for my rock, paper, and scissors buttons from a folder not by a direct path (this will not display image on your computer)
        //Create the object for Rock image
        InputStream rock = getClass().getResourceAsStream("Images/ic_stone.png");
        Image rockPicture = new Image(rock);
        ImageView rockImage = new ImageView(rockPicture);

        //Create the object for Paper image
        InputStream paper = getClass().getResourceAsStream("Images/ic_paper.png");
        Image paperPicture = new Image(paper);
        ImageView paperImage = new ImageView(paperPicture);

        //Create the object for Scissors image
        InputStream scissors = getClass().getResourceAsStream("Images/ic_scissors.png");
        Image scissorsPicture = new Image(scissors);
        ImageView scissorsImage = new ImageView(scissorsPicture);

        // 2. Create the GUI components
        //Create label how to play the game
        label = new Label("*How to play: click on 3 buttons to play the game, computer randomly plays \n                 rock, paper, or scissors. Score will be updated.*");

        //create display name for Rock button
        rockButton = new Button("Rock");

        //create display name for Paper button
        paperButton = new Button("Paper");

        //create display name for Scissors button
        scissorsButton = new Button("Scissors");

        //create display messages for result TextField
        resultText = new TextField("Hello there, welcome to the Rock Paper and Scissors game!");

        //create display messages for Text instructionMessage
        instructionMessage = new Text("Please choose one of those 3 selections above");

        //set canvas size
        canvas = new Canvas(800, 800);

        //draw canvas
        gc = canvas.getGraphicsContext2D();

        //create display messages for computer TextField
        computerText = new TextField("Computer plays will show here");

        // 3. Configure the components (colors, fonts, size, location)
        //Locating Rock image
        rockImage.relocate(65, 280);
        //Locating Paper image
        paperImage.relocate(320, 280);
        //Locating Scissors image
        scissorsImage.relocate(570, 280);

        //Locating and stying instruction How to play
        label.setFont(Font.font(20));
        label.relocate(80, 100);
        //Locating and styling Rock Button
        rockButton.setFont(Font.font(20));
        rockButton.relocate(80, 400);
        //Locating and styling Paper Button
        paperButton.setFont(Font.font(20));
        paperButton.relocate(320, 400);
        //Locating and styling Scissors Button
        scissorsButton.setFont(Font.font(20));
        scissorsButton.relocate(560, 400);

        //Locating and styling instruction message (Please choose on of the 3 selections)
        instructionMessage.setFont(Font.font(22));
        instructionMessage.relocate(150, 480);

        //Locating and styling Orange TextField where returns score
        resultText.setStyle("-fx-background-color: orange");
        resultText.setPrefSize(600, 50);
        resultText.setAlignment(Pos.CENTER);
        resultText.setEditable(false);
        resultText.setFont(Font.font(19));
        resultText.relocate(110, 180);

        //Setting color and location where to draw canvas
        gc.setFill(Color.PAPAYAWHIP);
        gc.fillRect(0, 0, 800, 800);

        //styling and locating computerText where it reports what is computer choice
        computerText.setStyle("-fx-background-color: yellow");
        computerText.setPrefSize(280, 50);
        computerText.setAlignment(Pos.CENTER);
        computerText.setEditable(false);
        computerText.setFont(Font.font(19));
        computerText.relocate(250, 620);

        // 4. Add components to the root
        root.getChildren().addAll(canvas, rockButton, paperButton, scissorsButton, resultText, instructionMessage, label, rockImage, paperImage, scissorsImage, computerText);

        // 5. Add Event Handlers and do final setup
        rockButton.setOnAction(this::handlerRockButton);
        paperButton.setOnAction(this::handlerPaperButton);
        scissorsButton.setOnAction(this::handlerScissorsButton);

        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
