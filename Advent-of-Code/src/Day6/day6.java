package Day6;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day6 {
    public static void main(String[] args) {
        BufferedReader reader;
        ArrayList<Character> allAns = new ArrayList<>();
        int numYes = 0;
        int totalYes = 0;
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

        try {
            reader = new BufferedReader(new FileReader("src/Day6/input.txt"));
            String line = reader.readLine();

            while (line != null) {
                if (line.isEmpty()) {
                    totalYes += numYes;

                    // reset
                    allAns.clear();
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

                    numYes = 0;

                } else {
                    // part 1
                    // goes though each line
                    for(int i = 0; i < line.length(); i++){
                        if(allAns.contains(line.charAt(i))){
                            // removes letter that has already appeared
                            allAns.remove(allAns.indexOf(line.charAt(i)));
                            numYes++;
                        }
                    }
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        totalYes += numYes;
        System.out.println("\nNumber of yes: " + totalYes);
    }
}
