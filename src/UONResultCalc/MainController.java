package UONResultCalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Program: 	UONResultCalc
 * Filename:	MainController.java
 * @author:		� Richard Wilsher (2022)
 * Course:		BSC Computing (Software Engineering)
 * Tutor:		Mark Johnson
 * @version:	1.0 final
 * Date:		29/09/2022
 */

public class MainController implements Initializable {

    @FXML private ChoiceBox secondYearChoiceBox1;
    @FXML private ChoiceBox secondYearChoiceBox2;
    @FXML private ChoiceBox secondYearChoiceBox3;
    @FXML private ChoiceBox secondYearChoiceBox4;
    @FXML private ChoiceBox secondYearChoiceBox5;
    @FXML private ChoiceBox secondYearChoiceBox6;
    @FXML private ChoiceBox thirdYearChoiceBox1;
    @FXML private ChoiceBox thirdYearChoiceBox2;
    @FXML private ChoiceBox thirdYearChoiceBox3;
    @FXML private ChoiceBox thirdYearChoiceBox4;
    @FXML private ChoiceBox dissertationChoiceBox;

    public MainController() throws Exception {

    }

    @FXML
    private void handleCalculateButtonAction(ActionEvent event) throws IOException {

        double[] secondYear = new double[6];
        double[] thirdYear = new double[4];
        double dissertation = 0.0;

        // Set up the arrays to store the grades into
        Module[] secondYearModule = new Module[6];
        Module[] thirdYearModule = new Module[4];

        //read in the grades
        secondYearModule[0] = new Module(secondYearChoiceBox1.getValue().toString());
        secondYearModule[1] = new Module(secondYearChoiceBox2.getValue().toString());
        secondYearModule[2] = new Module(secondYearChoiceBox3.getValue().toString());
        secondYearModule[3] = new Module(secondYearChoiceBox4.getValue().toString());
        secondYearModule[4] = new Module(secondYearChoiceBox5.getValue().toString());
        secondYearModule[5] = new Module(secondYearChoiceBox6.getValue().toString());

        thirdYearModule[0] = new Module(thirdYearChoiceBox1.getValue().toString());
        thirdYearModule[1] = new Module(thirdYearChoiceBox2.getValue().toString());
        thirdYearModule[2] = new Module(thirdYearChoiceBox3.getValue().toString());
        thirdYearModule[3]= new Module(thirdYearChoiceBox4.getValue().toString());

        Module dissertationModule = new Module(dissertationChoiceBox.getValue().toString());

        //Convert the letter grades to the numeric values for calculation
        for (int i=0; i<6; i++) {
            secondYear[i] = secondYearModule[i].convertGrade();
        }

        for (int i=0; i<4; i++) {
            thirdYear[i] = thirdYearModule[i].convertGrade();
        }

        dissertation = dissertationModule.convertGrade();

        // perform the grade prediction calculation
        Result resultCalculation = new  Result(secondYear, thirdYear, dissertation);

        // Display the predicted result
        JOptionPane.showMessageDialog(null,  "Note award calculation is an estimation, actual award can be different\n" + resultCalculation.generateResult());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // initialise the choice boxes
        secondYearChoiceBox1.getItems().addAll("A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G");
        secondYearChoiceBox1.setValue("G");
        secondYearChoiceBox2.getItems().addAll("A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G");
        secondYearChoiceBox2.setValue("G");
        secondYearChoiceBox3.getItems().addAll("A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G");
        secondYearChoiceBox3.setValue("G");
        secondYearChoiceBox4.getItems().addAll("A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G");
        secondYearChoiceBox4.setValue("G");
        secondYearChoiceBox5.getItems().addAll("A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G");
        secondYearChoiceBox5.setValue("G");
        secondYearChoiceBox6.getItems().addAll("A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G");
        secondYearChoiceBox6.setValue("G");
        thirdYearChoiceBox1.getItems().addAll("A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G");
        thirdYearChoiceBox1.setValue("G");
        thirdYearChoiceBox2.getItems().addAll("A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G");
        thirdYearChoiceBox2.setValue("G");
        thirdYearChoiceBox3.getItems().addAll("A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G");
        thirdYearChoiceBox3.setValue("G");
        thirdYearChoiceBox4.getItems().addAll("A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G");
        thirdYearChoiceBox4.setValue("G");
        dissertationChoiceBox.getItems().addAll("A+","A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G");
        dissertationChoiceBox.setValue("G");
    }


}