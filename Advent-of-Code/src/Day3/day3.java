package Day3;

import java.io.IOException;

public class day3 {
    public static void main(String[] args) throws IOException {

        int trial1 = CountTrees.numTrees(1,1);
        int trial2 = CountTrees.numTrees(3,1);
        int trial3 = CountTrees.numTrees(5, 1);
        int trial4 = CountTrees.numTrees(7,1);
        int trial5 = CountTrees.numTrees(1,2);

        System.out.println("Number of Trees: " + trial1); 
        System.out.println("Number of Trees: " + trial2); 
        System.out.println("Number of Trees: " + trial3);
        System.out.println("Number of Trees: " + trial4);
        System.out.println("Number of Trees: " + trial5);

        int ans = trial1 * trial2 * trial3 * trial4 * trial5;
        System.out.println("Answer: " + ans);
    }
}
