package Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day8 {
    public static void main(String[] args) {
        BufferedReader reader;

        final String ACC = "acc";
        final String JMP = "jmp";
        final String NOP = "nop";

        int accumulator = 0;
        ArrayList<String> instructions = new ArrayList<>();


        try {
            reader = new BufferedReader(new FileReader("src/Day8/input.txt"));
            String line = reader.readLine();

            while (line != null) {
                instructions.add(line); // gets instructions
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read instructions
        boolean checking = true;
        int checkingLine = 0;
        int jumps = 0;
        final String REPLACE = "CHRISTMAS";
        String rule;


        while(checking){
            // first check first line
            rule = instructions.get(checkingLine);
            //System.out.println("Checking: "+ rule);

            if(rule.contains(ACC)){
                // increment actuator
                try{
                    String increment = rule.substring(5);

                    int num = Integer.parseInt(increment);
                    if(rule.charAt(4) == '-'){
                        num *= -1;
                    }
                    accumulator += num;
                    instructions.set(checkingLine, REPLACE);

                }catch(NumberFormatException e){
                    System.out.println("Shouldn't happen");
                }

                checkingLine++;

            }else if(instructions.get(checkingLine).contains(JMP)){
                // jump
                try{
                    String jump = rule.substring(5);

                    int num = Integer.parseInt(jump);
                    //System.out.println("Sign of jump "+ rule.charAt(4));
                    if(rule.charAt(4) == '-'){

                        num *= -1;
                    }
                    instructions.set(checkingLine, REPLACE);
                    //System.out.println("Jumping to " + num);
                    checkingLine += num;


                }catch(NumberFormatException e){
                    System.out.println("Shouldn't happen");
                }
            }else if(rule.contains(NOP)){
                checkingLine++;
            }else{
                checking = false; // arrived at same line
            }


        }


        System.out.println("\n\nacctuator: " + accumulator); // not 2226
        /*
        for(String s: instructions){
            System.out.println(s);
        }

         */

    }
}
