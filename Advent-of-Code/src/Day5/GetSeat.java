package Day5;

public class GetSeat {
    public static int getSeat(String s, boolean row){
        int start = 0;
        int end;
        int i = 0;
        int seat = 0;
        int size;

        char upper;
        char lower;

        if (row){
            end = 127;
            size = 7;
            upper = 'B';
            lower = 'F';

        }else{
            end = 7;
            size = 3;
            upper = 'R';
            lower = 'L';
        }

        while(i < size){
            /*
            System.out.println("\n" + s.charAt(i));
            System.out.println("Seat " + seat);
            System.out.println("Start " + start);
            System.out.println("End " + end);

             */
            seat = start + (end - start)/2;
            if(s.charAt(i) == lower){
                //System.out.println("R");
                end = seat - 1;

            }else if(s.charAt(i) == upper) {
                //System.out.println("B");
                start = seat + 1;
            }
            i++;
        }
        //System.out.println("At the end t Start " + start);
        //System.out.println("End " + end);


        if(start != end){
            //System.out.println("NOT EQUAL");
            if(s.charAt(i - 1) == upper){
                seat++;
            }
        }else{
            seat = start;
        }

        //System.out.println("SEAT :" + seat + "\n\n");
        return seat;
    }

}
