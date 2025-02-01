import java.util.ArrayList;
import java.util.Random;

/**
 * The BirthdayProgram class is responsible for calculating the probability that 2 people share the same birthday in a
 * class. It does this through running a configurable amount of trials.
 * @author Rachel Hussmann
 */
public class BirthdayProgram {

    //Initializes the variable that holds the total number of birthday matches
    private int countOfMatches;

    /**
     * The generatePeople method creates an ArrayList of people filled with Person objects, which all have randomized
     * birthdays and birth months.
     * @param numberOfPeople The number of people that need to be created.
     * @return An ArrayList of the newly generated people.
     */
    private ArrayList<Person> generatePeople(int numberOfPeople){

        //Initializes the ArrayList that will hold all the generated people
        ArrayList<Person> people = new ArrayList<>();

        //Initializes a random object to pick random integers for birthdays and birth months
        Random random = new Random();

        //loop until all people have been created and added to the list
        for(int i = 0; i < numberOfPeople; i++){

            //Picks a random number between 1 and 12 for birth month
            int birthMonth = random.nextInt(1, 13);

            //Initializes the birthday integer
            int birthday = 0;

            //Checks the month to change the bound of the randomly generated birthday
            if(birthMonth == 4 || birthMonth == 6 || birthMonth == 9 || birthMonth == 11){

                //If the birth month is april, june, september or november

                //Pick a random integer between 1 and 30
                birthday = random.nextInt(1, 31);
            }else if (birthMonth == 2){

                // if the birth month is february

                //Pick a random integer between 1 and 28
                birthday = random.nextInt(1, 29);
            }else{

                //Otherwise the month is a month that has 31 days

                //Pick a random integer between 1 and 31
                birthday = random.nextInt(1, 32);
            }

            //Add the newly created person to the people ArrayList
            people.add(new Person(birthday, birthMonth));

        }

        //Return the list of people
        return people;
    }


    /**
     * The runTrials method runs the configurable number of trials and figures out the percentage of birthday matches in
     * a class.
     * @param trials The number of trials to be run.
     * @param people The number of people in the class.
     * @return The decimal percentage of birthday matches.
     */
    public double runTrials(int trials, int people){

        //Run through the number of trials
        for(int i = 0; i < trials; i++){

            //Generate a new list of people for each trial
            ArrayList<Person> listOfPeople = generatePeople(people);

            int j = 0;
            while(j < listOfPeople.size()){

                Person person1 = listOfPeople.get(j);

                for(int x = 1; x < listOfPeople.size(); x++){

                    Person person2 = listOfPeople.get(x);

                    //Make sure they are not the same Person object
                    if(person1 != person2){

                        //Check to see if they have the same birthday and birth month
                        if(person1.getBirthday() == person2.getBirthday() &&
                                person1.getBirthMonth() == person2.getBirthMonth()){

                            //If they have the same birthday and birth month, add one to the number of matches
                            countOfMatches++;
                        }
                    }
                }

                listOfPeople.remove(person1);

            }

        }

        System.out.println(countOfMatches);

        //Calculate the percentage of matches birthdays and return it
        return calculatePercentage(countOfMatches, trials, people);
    }


    /**
     * The calculatePercentage method accepts the number of matches birthdays, the number of trials and the size of
     * the class to figure out the percentage of times two people had the same birthday in the same class.
     * @param matchedBirthdays The number of times two people had the same birthday in a class.
     * @param numberOfTrials The number of trials run.
     * @param classSize The number of students in the class.
     * @return The decimal percentage of the number of times two people had the same birthday.
     */
    private double calculatePercentage(int matchedBirthdays, int numberOfTrials, int classSize){

        return (double)matchedBirthdays / (double)(numberOfTrials*classSize);

    }
}
