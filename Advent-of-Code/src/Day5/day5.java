package Day5;

import Day4.ValidatePassword;
import com.sun.applet2.AppletParameters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class day5 {
    public static void main(String[] args){
        BufferedReader reader;
        int row;
        int col;
        int id;
        int bigggest = 0;
        HashMap<Integer,Integer[]> totalSeats = new HashMap<>();
        Integer[] allCols = new Integer[8];

        for(int i = 0; i < allCols.length; i ++){
            allCols[i] = i;
        }

        // intialize total seats
        for(int r = 1; r < 127; r++){
            totalSeats.put(r, allCols);
        }

        try {
            reader = new BufferedReader(new FileReader("src/Day5/input.txt"));
            String line = reader.readLine();

            while (line != null) {

                //System.out.println("Checking Row: " + line.substring(0,7));
                row = GetSeat.getSeat(line.substring(0,7), true);
                col = GetSeat.getSeat(line.substring(7,10), false);
                id = (row * 8) + col;

                System.out.println("Row:" + row);
                System.out.println("Col: " + col);
                System.out.println("ID: " + id + "\n");

                 if(totalSeats.containsKey(row)){

                     for(int i = 0; i < totalSeats.get(row).length; i++){
                         // checks if it contains col
                         //System.out.println("contains" + totalSeats.get(row)[i]);
                         if(totalSeats.get(row)[i] == col){
                             //System.out.println("MATCH: " + col);

                             // then i is the index to remove
                             if((totalSeats.get(row).length) == 0){
                                 totalSeats.remove(row);
                                 //System.out.println("Removing row: " + row);
                                 i = 100000;
                             }else{
                                 Integer[] newList = new Integer[totalSeats.get(row).length -1];

                                 // make new list
                                 int index = 0;
                                 for(int cols = 0; cols < newList.length; cols++){
                                     if(index != i){
                                         newList[cols] = totalSeats.get(row)[index];
                                     }else{
                                         cols--;
                                     }
                                     index++;
                                 }
                                 totalSeats.put(row, newList);
                                 if(newList.length ==1){
                                     System.out.println("NEWLIST: " + newList[0]);
                                     //System.out.println("row: " + newList[0]);
                                 }

                             }
                             i = 10000;

                         }
                     }
                 }

                System.out.println("\n\n");


                if(id > bigggest){
                    bigggest = id;
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        System.out.println("Biggest id: " + bigggest);

     System.out.println("key set "+ totalSeats.keySet());
     for(Integer key: totalSeats.keySet()){
         for(Integer cols : totalSeats.get(key)) {
             //System.out.println(cols);
         }
        //System.out.println("\n\n");
     }

    }
}
