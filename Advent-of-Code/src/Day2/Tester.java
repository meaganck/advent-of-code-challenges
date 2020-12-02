package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tester {
    public static void main(String[] args) {
        // this program checks a valid password
        int validPass = 0;
        int validPass2 = 0; // part two
        int min = 0;
        int max = 0;
        int letterAppears;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/Day2/input.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] input = line.split(" "); // first splits up into substrings
                // Splits up the first set of substrings  which contains two numbers separated by '-'
                String[] nums = input[0].split("-");

                // converts the numbers tp integers
                try{
                    min = Integer.parseInt(nums[0]);
                    max = Integer.parseInt(nums[1]);

                }catch (final NumberFormatException e) {
                    System.out.println("Whoops");
                }

                char letter = input[1].charAt(0); // gets the char that is used to validate the password
                String password = input[2];
                letterAppears = 0; // resets

                // part one
                // checks the number of time the letter appears in the password
                for(int i = 0; i < password.length(); i++){
                    if(password.charAt(i) == letter){
                        letterAppears++;
                    }
                }

                // checks if it meets the requirements for the password
                if(letterAppears >= min && letterAppears <= max){
                    validPass++;
                }

                // part two
                // validates that a password must have the letter at the min position and not at the max
                // position or does not contain the letter at the min position, and contains the letter at the
                // min position (with the positions starting at 1 instead of 0)
                if((password.charAt(min-1) == letter  && password.charAt(max-1) != letter) ||
                        (password.charAt(min-1) != letter  && password.charAt(max-1) == letter)){
                    validPass2++;
                }

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // outputs answer
        System.out.println("Number of valid passwords:");
        System.out.println("Part 1: " + validPass);
        System.out.println("Part 2: " + validPass2);
    }
}
