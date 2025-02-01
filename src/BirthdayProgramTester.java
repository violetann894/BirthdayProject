/**
 * The BirthdayProgramTester class is used to run trials to figure out the probability that two people in the same class
 * share a birthday.
 * @author Rachel Hussmann
 */
public class BirthdayProgramTester {
    public static void main(String[] args) {

        //Initializes the tester object for the BirthdayProgram
        BirthdayProgram tester = new BirthdayProgram();

        //Initialize the classSize
        int classSize = 100;

        //Print out a formatted string of the probability that two people share a birthday in the same class
        System.out.printf("The probability that two people share a birthday in a %d person sized class: %f", classSize,
                tester.runTrials(10000, classSize)*100);
    }
}
