package Day7;

import java.util.ArrayList;
import java.util.HashMap;

public class Check {
    public static ArrayList<String> CheckingBags(HashMap<String, ArrayList<String>> rules, ArrayList<String> shinyGold){
        // gives ArrayList of all values bags that contain shiny gold bag or bags that contain shiny gold bags
        ArrayList<String> containBagThatContainsShinyGold = new ArrayList<>();

        for (String keys : rules.keySet()) {
            // bags that can be in key
            boolean checked= false;
            for (String s : rules.get(keys)) {
                // check which bags contain the bags with shiny gold
                // if already checked, then key is already in the list
                if(!checked){
                    for(int i = 0; i < shinyGold.size(); i++){

                        // separate the colour from the string
                        String[] text = shinyGold.get(i).split("bag");
                        String color = text[0];

                        // check if the colour will contain shiny gold bag
                        if(s.contains(color)){
                            containBagThatContainsShinyGold.add(keys);
                            i = shinyGold.size();
                            checked = true; // trying to reduce the number of repetitive elements
                        }
                    }
                }
            }
        }
        return containBagThatContainsShinyGold;
    }
}
