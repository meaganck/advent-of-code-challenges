package Day7;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class day7 {
    public static void main(String[] args) {
        BufferedReader reader;
        int index = 0;
        int total = 0;
        String key = "";
        String value = "";
        String[] bags;
        HashMap<String, ArrayList<String>> rules = new HashMap<>(); /// all the rules for every bag
        HashMap<Integer, ArrayList<String>> allBags = new HashMap<>(); // contains all the bags that can contain shiny gold bag

        try {
            reader = new BufferedReader(new FileReader("src/Day7/input.txt"));
            String line = reader.readLine();

            while (line != null) {
                // resets
                key = "";
                value = "";

                // separates the input in the line
                index = line.indexOf("contain");
                key = line.substring(0, index);
                value = line.substring(index + 8);


                // if the bag colour does not exist yet, create a key
                if (!rules.containsKey(key)) {
                    rules.put(key, new ArrayList<>());
                }

                bags = value.split(", "); // gets bag colour

                // adds bags to total bags
                for (String b : bags) {
                    //System.out.println("adding bag: " + b + " to KEY " + key);
                    rules.get(key).add(b);
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // first gets all the bags that directly contain the shiny gold bag
        ArrayList<String> shinyGold = new ArrayList<>();

        for (String keys : rules.keySet()) {
            //System.out.println("Rule: " + keys);
            for (String s : rules.get(keys)) {
                //System.out.println(s);
                if(s.contains("shiny gold")){
                    shinyGold.add(keys);
                    //System.out.println("Added key to shiny bag " + keys);
                }
            }
        }

        // gets all bags that contain shiny gold, directly and indirectly
        allBags.put(0, shinyGold);
        int i = 1;
        boolean empty = false;

        // keeps on checking bags that contain bags that contain shiny gold bags...
        while(!empty){
            ArrayList<String> newBags = Check.CheckingBags(rules, allBags.get(i-1));

            if(!newBags.isEmpty()){
                for(Integer keys : allBags.keySet()){
                    // makes sure there are no duplicate bags
                    newBags.removeAll(allBags.get(keys));
                }
                allBags.put(i, newBags);
                //System.out.println(newBags);
                i++;
            }else{
                // got all the bags needed, stop checking
                empty =true;
            }
        }

        // gets total number of bags that can contain shiny gold
       for(Integer keys: allBags.keySet()) {
          total += allBags.get(keys).size();
       }

        System.out.println("Size: " + total); // Answer: 259
    }
}

