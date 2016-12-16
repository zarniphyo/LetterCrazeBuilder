package controller;
 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
 
import boundary.Application;
import boundary.LightningBuilderPanel;
import boundary.PuzzleBuilderPanel;
import model.BoardBuilder;
import model.LightningBuilder;
import model.Model;
import model.PuzzleBuilder;
import model.ScoreBoardBuilder;
 
/**
 * <h1>EditLightningController class</h1>
 * <p> The controller to edit one of the lightning levels from the menu 
 * of the pre-built levels</p>
 *
 * @author Palladium
 * @since 2016-12-15
 */
public class EditLightningController extends MouseAdapter {
    Application app;
    Model model;
    int lvl;
    Scanner sc;
 
    /**
     * The constructor for the EditLightningController
     * @param a The top level application
     * @param m The model
     * @param lvl The specific level to be edited
     */
    public EditLightningController(Application a, Model m, int lvl) {
        this.app = a;
        this.model = m;
        this.lvl = lvl;
    }
 
    /**
     * The method to edit the specific lightning level by preserving the information of 
     * already pre-built level 
     */
    @Override
    public void mousePressed(MouseEvent me) {
        // Initiate new score board builder and board builder
        ScoreBoardBuilder scoreBoard = new ScoreBoardBuilder();
        BoardBuilder board = new BoardBuilder();
 
        // Initiate new Lightning builder and lightning view
        LightningBuilder lightBuilder = new LightningBuilder(board, scoreBoard);
        LightningBuilderPanel lightView = new LightningBuilderPanel(this.model, this.app);
 
        try {
            StringFileIterator(new File (lvl+".txt"));
        } catch (FileNotFoundException e) {
            System.out.println("This file doesn't exist you fool.");
        }
 
        next();
 
        // The counter to keep track of number of the button that should be selected 
        int j=0;
 
        // Access rows one by one and preserves the status of tiles of the pre-built board
        // i.e. whether the tile is selected or not
         
        String row1 = next(); //**00**
        for(int i=0; i<6; i++, j++) { 
            // Check if char is zero at position i in the row(which means that the tile at that position
            // on the board should be disabled, when we will get to building the levels)
            if (row1.charAt(i) == '0') {
                // Mark the button as selected
                lightView.setSelectedTiles(j);
            }
        }
         
        // Make the same procedure with all the other rows
        String row2 = next(); //***0**
        for(int i=0; i<6; i++, j++){
            if (row2.charAt(i) == '0') {
                lightView.setSelectedTiles(j);
            }
        }
        String row3 = next();
        for(int i=0; i<6; i++, j++){
            if (row3.charAt(i) == '0') {
                lightView.setSelectedTiles(j);
            }
        }
        String row4 = next();
        for(int i=0; i<6; i++, j++){
            if (row4.charAt(i) == '0') {
                lightView.setSelectedTiles(j);
            }
        }
        String row5 = next();   
        for(int i=0; i<6; i++, j++){
            if (row5.charAt(i) == '0') {
                lightView.setSelectedTiles(j);
            }
        }
        String row6 = next();
        for(int i=0; i<6; i++, j++){
            if (row6.charAt(i) == '0') {
                lightView.setSelectedTiles(j);
            }
        }
 
        // Extract the following information from the file to use later
        int time = Integer.parseInt(next());
        int thresh1 = Integer.parseInt(next());
        int thresh2 = Integer.parseInt(next());
        int thresh3 = Integer.parseInt(next());
 
        // Assign lightning builder status to model
        this.model.assignBuilder(lightBuilder);
 
        // We want to call some method on current application that will switch to just created 
        // lightning view
        app.modifyFrameSize(100, 100, 750, 575);
        app.switchPanel(lightView);
 
        // Set the fields with pre-built level information
        lightView.setLevelNumber(lvl);
        lightView.setTimer(time);
        lightView.setOneStar(thresh1);
        lightView.setTwoStar(thresh2);
        lightView.setThreeStar(thresh3);    
 
        // Refresh the screen 
        lightView.validate();
 
    }
 
    /**
     * The method to Iterate the file (i.e. scan the file)
     * @param f The file to be scanned
     * @throws FileNotFoundException The exception to be thrown if the file passed does not exist
     */
    public void StringFileIterator(File f) throws FileNotFoundException {
        sc = new Scanner(f);
    }
 
    /**
     * The method to read the next line from the file
     * @return String The string to be extracted from as the line from the file
     * @throws NoSuchElementException The exception to be thrown if the file reached the end
     */
    public String next() throws NoSuchElementException {
 
        if (sc == null) {
            throw new NoSuchElementException ("End of file reached.");
        }
 
        String s = sc.nextLine();
        System.out.println(s);
 
        if (!sc.hasNextLine()) {
            sc.close();
            sc = null;
        }
        return s;
    }
}
