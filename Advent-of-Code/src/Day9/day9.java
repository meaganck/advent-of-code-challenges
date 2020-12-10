package Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day9 {
    public static void main(String[] args) {
        BufferedReader reader;
        final int PREAMBLE_SIZE = 25;
        double num = 0;
        ArrayList<Double> preamble = new ArrayList<>();
        ArrayList<Double> data = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("src/Day9/input.txt"));
            String line = reader.readLine();

            while (line != null) {
                try{
                    num = Double.parseDouble(line);
                    data.add(num);
                }catch (NumberFormatException e){
                    System.out.println("Whoops");
                }

                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean valid;
        boolean checking = true;
        double invalid = 0;

        for(int dataNum = PREAMBLE_SIZE; dataNum < data.size() && checking; dataNum++){

            valid = false; // reset

            // make preamble list
            preamble.clear();
            for(int p = dataNum - PREAMBLE_SIZE; p < dataNum; p++){
                preamble.add(data.get(p));
            }

            // goes through preamble list and compares each element with the rest of the list
            for(int compare = 0; compare < preamble.size() && !valid; compare++){
                for(int index = 0;index < preamble.size() && !valid; index++){
                    if(preamble.get(compare) + preamble.get(index) == data.get(dataNum)){
                        valid = true;
                    }
                }
            }

            // if there was no sum found, then that number is the invalid number
            if(!valid){
                checking = false;
                invalid = data.get(dataNum);
            }
        }
        System.out.println("Invalid number: " + invalid);
    }
}
