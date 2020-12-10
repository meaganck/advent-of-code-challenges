package Day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class day10 {
    public static void main(String[] args) {
        BufferedReader reader;
        int num = 0;
        int current;
        int difference;
        int oneDifference = 0;
        int threeDifference = 0;
        boolean foundNothing;
        boolean checking = true;
        ArrayList<Integer> adapters = new ArrayList<>();
        adapters.add(0);

        try {
            reader = new BufferedReader(new FileReader("src/Day10/input.txt"));
            String line = reader.readLine();

            while (line != null) {
                try {
                    num = Integer.parseInt(line);
                    adapters.add(num);
                } catch (NumberFormatException e) {
                    System.out.println("Whoops");
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(adapters); // need to sort array first

        // goes through list of adapters
        for(int i = 0; i < adapters.size() && checking ; i++){
            current = adapters.get(i);
            foundNothing = true; //reset

            // find matching adapter with 1 or 3 difference
            for(int a = i+1; a < adapters.size() && foundNothing; a++){
                difference = adapters.get(a);

                // one difference
                if((current + 1) == difference ){
                    oneDifference++;
                    foundNothing = false; // exit for loop
                    i = a - 1; // change index to a (-1 because i will be incremented)

                // three difference
                }else if((current + 3) == difference){
                    threeDifference++;
                    foundNothing = false; // exit for loop
                    i = a - 1; // change index to a (-1 because i will be incremented)
                }
            }

            // if found nothing, then finished checking
            if(foundNothing){
                checking = false;
            }
        }

        threeDifference++; // last difference is 3
        int ans = oneDifference * threeDifference;

        System.out.println("\nOne difference: " + oneDifference);
        System.out.println("Three difference: " + threeDifference);
        System.out.println("Ans: " + ans);
    }
}
