package Day4;

public class ValidatePassword {
    public static boolean validate(String passport){
        String[] eyeColours = {"amb","blu", "brn", "gry", "grn", "hzl", "oth"};

        if(passport.contains("byr") && passport.contains("iyr") && passport.contains("hgt") && passport.contains("hcl") &&
                passport.contains("eyr") && passport.contains("ecl") && passport.contains("pid")) {

            // checks byr and iyr and exp
            String[] byr = passport.split("byr:");
            String[] iyr = passport.split("iyr:");
            String[] eyr = passport.split("eyr:");
            String[] hgt = passport.split("hgt:");
            String[] hcl = passport.split("hcl:");
            String[] ecl = passport.split("ecl:");
            String[] pid = passport.split("pid:");

            /*
            //Debug
            System.out.println("byr: " + byr[1]);
            System.out.println("iyr: " + iyr[1]);
            System.out.println("eyr: " + eyr[1]);
            System.out.println("hgt: " + hgt[1]);
            System.out.println("hcl: " + hcl[1]);
            System.out.println("ecl: " + ecl[1]);
            System.out.println("pid: " + pid[1]);
             */

            // validates that they are the right length
            if (byr[1].length() >= 4 && iyr[1].length() >= 4 && eyr[1].length() >= 4 &&
            hgt[1].length()>= 4 && hcl[1].length() >= 7 && ecl[1].length() >=3 && pid[1].length() >=9) {

                // height check
                // cm check
                if(hgt[1].contains("cm")){
                    try{
                        int height = Integer.parseInt(hgt[1].substring(0, 3));
                        if(!(height >= 150 && height <= 193)){
                            return false;
                        }
                    }catch(final NumberFormatException e){
                        return false;
                    }

                    // inches check
                }else if(hgt[1].contains("in")){
                    try{
                        int height = Integer.parseInt(hgt[1].substring(0, 2));
                        if(!(height >= 59 && height <= 76)){
                            return false;
                        }
                    }catch (final NumberFormatException e){
                        return false;
                    }
                }else{
                    return false;
                }

                // hair colour check
                if(!(hcl[1].substring(1,7).toUpperCase().matches("[A-F0-9]+") && hcl[1].substring(0,1).contains("#"))){
                    //System.out.println("Invalid hair:");
                    return false;
                }

                // eye colour check
                boolean validEye = false;
                for(String s: eyeColours){
                    if(ecl[1].substring(0,3).equals(s)){
                        validEye = true;
                    }
                }

                if(!validEye){
                    //System.out.println("Invalid eye");
                    return false;
                }

                // validates passport id
                // makes sure there is only 9 numbers, if there are more numbers, invalid
                for(int i = 0; i < pid[1].length(); i++){
                    try{
                        int num = Integer.parseInt(String.valueOf(pid[1].charAt(i)));
                    }catch(final NumberFormatException e){
                        if(!(i == 9)){
                            //System.out.println("Invalid ID");
                            return false;
                        }else{
                            i = pid[1].length();
                        }
                    }
                }

                // validates birth year and issue year
                try {
                    // first check if they are valid integers
                    int birthYear = Integer.parseInt(byr[1].substring(0, 4));
                    int issueYear = Integer.parseInt(iyr[1].substring(0, 4));
                    int expYear = Integer.parseInt(eyr[1].substring(0,4));

                    // second check if they have a valid value
                    if (!(birthYear >= 1920 && birthYear <= 2002) ||
                            !(issueYear >= 2010 && issueYear <= 2020) ||
                            !(expYear >= 2020 && expYear <= 2030)) {
                        //System.out.println("Invalid number");
                        return false;
                    }
                } catch (final NumberFormatException e) {
                    return false;
                }
            }else{
                return false;
            }
            //System.out.println("Valid\n");
            return true;
        }
        return false;
    }
}
