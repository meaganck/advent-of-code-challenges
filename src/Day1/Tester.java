package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args){
        // this program checks for two numbers and three numbers whose sum is 2020 in the given input.
        // The answer is given as the product the pairs of numbers.
        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/Day1/input.txt")); // change to papers.txt
            String line = reader.readLine();
            while (line != null) {
                try {
                    // validates input is an integer
                    int num = Integer.parseInt(line);
                    list.add(num);

                } catch (final NumberFormatException e) {
                    System.out.println("Whoops");
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // goes though each line one at a time
        for(int i = 0; i < list.size(); i++){
            // compares that line with the following next lines
            for(int count = i+1; count < list.size(); count++){
                // checks two numbers to see if they equal 2020
                if(list.get(i) + list.get(count) == 2020){
                    System.out.println(list.get(i) + " and " + list.get(count));
                    System.out.println("Answer: " + (list.get(i) * list.get(count)));
                }
                // compares the other two lines with their following line
                for(int count2 = count+1; count2 < list.size(); count2++){
                    // checks three numbers if they equal 2020
                    if(list.get(i) + list.get(count) + list.get(count2) == 2020){
                        System.out.println(list.get(i) + " and " + list.get(count) + " and " + list.get(count2));
                        System.out.println("Answer: " + (list.get(i) * list.get(count) * list.get(count2)));
                    }
                }
            }
        }
    }
}
