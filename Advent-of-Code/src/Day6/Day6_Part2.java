package Day6;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day6_Part2 {
    public static void main(String[] args) {
        BufferedReader reader;
        ArrayList<Character> allAns = new ArrayList<>();
        ArrayList<Integer> validateNums = new ArrayList<>();
        int numYes = 0;
        int totalYes = 0;
        String groupAns = "";
        int numLine = 0;

        allAns.add('a');
        allAns.add('b');
        allAns.add('c');
        allAns.add('d');
        allAns.add('e');
        allAns.add('f');
        allAns.add('g');
        allAns.add('h');
        allAns.add('i');
        allAns.add('j');
        allAns.add('k');
        allAns.add('l');
        allAns.add('m');
        allAns.add('n');
        allAns.add('o');
        allAns.add('p');
        allAns.add('q');
        allAns.add('r');
        allAns.add('s');
        allAns.add('t');
        allAns.add('u');
        allAns.add('v');
        allAns.add('w');
        allAns.add('x');
        allAns.add('y');
        allAns.add('z');

        // initialize
        for(int i = 0; i < 26; i++){
            validateNums.add(0);
        }

        try {
            reader = new BufferedReader(new FileReader("src/Day6/input.txt"));
            String line = reader.readLine();

            while (line != null) {
                if (line.isEmpty()) {
                    validateNums.clear(); // resets

                    // each element signifies how much of each letter has been recorded
                    // reinitialize
                    for(int i = 0; i < 26; i++){
                        validateNums.add(0);
                    }

                    // goes through each char in the group's answer
                    for(int i = 0; i < groupAns.length(); i++){

                        // should always contain a letter from groupAns, but check anyways
                        if(allAns.contains(groupAns.charAt(i))){
                            // temporary stores the number of times the letter has already appeared plus 1
                            // for this iteration
                            int temp = validateNums.get(allAns.indexOf(groupAns.charAt(i))) + 1;

                            // updates value in validateNums
                            validateNums.set(allAns.indexOf(groupAns.charAt(i)), temp);
                        }
                    }

                    // goes though validateNums to see if each person has answered the question
                    // (corresponds to a-z)
                    for(int i = 0; i < 26; i++){
                        // for this to be true, letter must have been recorded value of numLines times
                        // and for extra checking makes sure number of letters is not 0
                        if(validateNums.get(i) >= numLine && validateNums.get(i) != 0){
                            numYes++;
                        }
                    }
                    totalYes += numYes;

                    // reset variables
                    numYes = 0;
                    groupAns = "";
                    numLine = 0;

                } else {
                    // read through string
                    groupAns = groupAns.concat(line);
                    numLine++;
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // same thing as above, but last group does not get looked at in the loop above
        // so must recheck
        validateNums.clear();
        for(int i = 0; i < 26; i++){
            validateNums.add(0);
        }

        // goes through each char
        for(int i = 0; i < groupAns.length(); i++){
            if(allAns.contains(groupAns.charAt(i))){
                int temp = validateNums.get(allAns.indexOf(groupAns.charAt(i))) + 1;
                validateNums.set(allAns.indexOf(groupAns.charAt(i)), temp);
            }
        }

        for(int i = 0; i < 26; i++){
            if(validateNums.get(i) >= numLine && validateNums.get(i) != 0){
                numYes++;
            }
        }

        totalYes += numYes;

        System.out.println("\nNumber of yes: " + totalYes);
    }
}

