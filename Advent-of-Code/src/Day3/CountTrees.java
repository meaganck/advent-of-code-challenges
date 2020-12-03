package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountTrees {

    public static int numTrees(int numRight, int numDown) throws IOException {
        BufferedReader reader;
        int numTrees = 0;
        int right = 0;
        int down = 0;

        try {
            reader = new BufferedReader(new FileReader("src/Day3/input.txt"));
            String line = reader.readLine();

            while (line != null) {

                // skip first line
                if (right == 0) {
                    right = numRight;
                    down++;
                } else {

                    // only really works for if down is 1 or 2
                    if(down == numDown){
                        String oldLine = line; // remembers line

                        // makes string bigger by concatenating same string over and over until
                        // it is big enough to use
                        while (line.length() <= right) {
                            line = line.concat(oldLine);
                        }

                        // checks if there is a tree
                        if (line.charAt(right) == '#') {
                            numTrees++;
                        }
                        right += numRight; // increase right by specified amount
                    }

                    // updates down -only changes down if numDown > 1
                    if(numDown > 1){
                        if(down == numDown){
                            down = 1;
                        }else if(down == 1){
                            down++;
                        }
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numTrees;
    }
}
