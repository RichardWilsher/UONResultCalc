package UONResultCalc;

/**
 * Program: 	UONResultCalc
 * Filename:	Result.java
 * @author:		� Richard Wilsher (2022)
 * Course:		BSC Computing (Software Engineering)
 * Tutor:		Mark Johnson
 * @version:	1.0 final
 * Date:		29/09/2022
 */

/*
    Object used to perform necessary steps to calculate final award
 */

public class Result {

    private double[] secondYear;

    private double[] thirdYear;

    private double dissertation;

    public Result(double[] secondYear, double[] thirdYear, double dissertation) {
        this.secondYear = secondYear;
        this.thirdYear = thirdYear;
        this.dissertation = dissertation;
    }

    public Result() {
    }

    public double[] getSecondYear() {
        return secondYear;
    }

    public void setSecondYear(double[] secondYear) {
        this.secondYear = secondYear;
    }

    public double[] getThirdYear() {
        return thirdYear;
    }

    public void setThirdYear(double[] thirdYear) {
        this.thirdYear = thirdYear;
    }

    public double getDissertation() {
        return dissertation;
    }

    public void setDissertation(double dissertation) {
        this.dissertation = dissertation;
    }

    private double[] sortGrades(double[] grades){
    // Used to sort the arrays
        int n = grades.length;
        double temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (grades[j - 1] > grades[j]) {
                    temp = grades[j - 1];
                    grades[j - 1] = grades[j];
                    grades[j] = temp;
                }

            }
        }
        return grades;
    }

    private double[] dropResults(double[] secondYear, double[] thirdYear){
        // drops the lowest 3 grades (cannot drop dissertation or 2 3rd year grades
        double[] grades = new double[15];
        int position = 0;

        if(secondYear[1] < thirdYear[0]){
            secondYear[0] = -1;
            secondYear[1] = -1;
            secondYear[2] = -1;
        } else {
            secondYear[0] = -1;
            thirdYear[0] = -1;
        }
        for (int i=0; i<6; i++){
            if (secondYear[i] != -1){
                grades[position] = secondYear[i];
                position++;
            }
        }
        for (int i=0; i<4; i++){
            if (thirdYear[i] != -1){
                grades[position] = thirdYear[i];
                position++;
                grades[position] = thirdYear[i];
                position++;
            }
        }

        grades[11] = dissertation;
        grades[12] = dissertation;
        grades[13] = dissertation;
        grades[14] = dissertation;

        return grades;
    }

    private double calculateMean(double[] sortedResults){
        // calculates the mean value
        double tally = 0;
        for(int i=0; i<15; i++){
            tally += sortedResults[i];
        }
        return (tally/15);
    }

    private double calculateMedian(double[] sortedResults){
        // calculates the median value
        return sortedResults[7];
    }

    private String calculateAward(double average){
        // returns the classification based on passed in value
        if (average >= 20.50) {
            return "First Class Degree";
        }else if (average >= 17.50) {
            return "Upper Second Class Degree";
        }else if (average >= 14.50) {
            return "Lower Second Class Degree";
        }else if (average >= 11.50) {
            return "Third Class Degree";
        }else {
            return "Fail";
        }
    }

    public String generateResult(){
        /*
        Used to take the values passed into the constructor,
        sort them, then drop the 3 lowest values,
        add the dissertation and resort the values
        before calculating the mean and median values
        taking the highest, using that to calculate the degree classification
         */

        double[] sortedSecondYear = sortGrades(secondYear);
        double[] sortedThirdYear = sortGrades(thirdYear);

        double[] resultArray = new double[15];
        resultArray = dropResults(sortedSecondYear, sortedThirdYear);

        double[] sortedResultArray = sortGrades(resultArray);

        double mean = calculateMean(sortedResultArray);
        double median = calculateMedian(sortedResultArray);

        if (mean >= median){
            return calculateAward(mean);
        } else {
           return calculateAward(median);
        }
    }
}
