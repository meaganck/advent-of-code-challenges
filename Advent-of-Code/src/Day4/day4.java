package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day4 {

    public static void main(String[] args){
        BufferedReader reader;
        int validPassword = 0;
        String passport = "";

        try {
            reader = new BufferedReader(new FileReader("src/Day4/input.txt"));
            String line = reader.readLine();

            while (line != null) {
                if(!line.isEmpty()){
                    passport = passport.concat(line);
                }else{
                    //System.out.println("\nChecking: " + passport);
                    if(ValidatePassword.validate(passport)){
                        validPassword++;
                    }
                    passport = "";
                }
                line = reader.readLine();
                }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // will have a remaining string after finished reading file
        if(!passport.isEmpty()){
            if(ValidatePassword.validate(passport)){
                validPassword++;
            }
        }
        System.out.println("Number of Valid Passwords: " + validPassword); // needs to be less than 128
    }
}
