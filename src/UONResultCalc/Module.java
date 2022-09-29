package UONResultCalc;

public class Module{

    /**
     * Program: 	UONResultCalc
     * Filename:	Module.java
     * @author:		� Richard Wilsher (2022)
     * Course:		BSC Computing (Software Engineering)
     * Tutor:		Mark Johnson
     * @version:	1.0 final
     * Date:		29/09/2022
     */

    /*
        repurposed Object from a similar project used primarily to convert letter grades to their numerical equivalent
     */

    private String code;
    private String title;
    private String grade;

    public Module(String code, String title, String grade) {
        this.code = code;
        this.title = title;
        this.grade = grade;
    }

    public Module() {

    }

    public Module(String grade){
        this.grade = grade;
    }

    public double convertGrade() {
        // method to take the letter grade and return a double value
        double value = 0;

        switch(grade) {
            case "A+":
                value = 25.0;
                break;
            case "A":
                value = 23.0;
                break;
            case "A-":
                value = 21.0;
                break;
            case "B+":
                value = 20.0;
                break;
            case "B":
                value = 19.0;
                break;
            case "B-":
                value = 18.0;
                break;
            case "C+":
                value = 17.0;
                break;
            case "C":
                value = 16.0;
                break;
            case "C-":
                value = 15.0;
                break;
            case "D+":
                value = 14.0;
                break;
            case "D":
                value = 13.0;
                break;
            case "D-":
                value = 12.0;
                break;
            case "F+":
                value = 11.0;
                break;
            case "F":
                value = 8.0;
                break;
            case "F-":
                value = 2.0;
                break;
            case "G":
                value = 0;
                break;
            default:
                value =0;
                break;
        }

        return value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
