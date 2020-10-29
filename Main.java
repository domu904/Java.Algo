import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Main {
        
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<String> serialNumber = new ArrayList<String>();
        serialNumber.add("AVG190420T");
        serialNumber.add("RTF20001000Z");
        serialNumber.add("QWER201850G");
        serialNumber.add("AFA199620E");
        

        int result = Result.countCounterfeit(serialNumber);
        System.out.println("The result is " + result);
    }
}

class Result {

    public static int countCounterfeit(List<String> serialNumber) {
        System.out.println("In Counterfeit");
        ArrayList<Integer> currDenomination = new ArrayList<>(Arrays.asList(10, 20, 50, 100, 200, 500, 1000));

        // for (Integer cd : currDenomination) {
        //     //System.out.println("Currency Denomination: " + cd);
        // }


        int sum = 0;

        for (String sn : serialNumber) {
            if (sn.length() >= 10 && sn.length() <= 12) {
                // System.out.println("Lenght match: "+ sn.length());
                // System.out.println("Substring: "+ sn.substring(3, 7));
                // System.out.println("Last Letter is: "+ sn.substring(sn.length()-1));
                
                if (sn.substring(0, 3).matches("[A-Z]+") && isLetterDistinct(sn.substring(0,3)) && sn.substring(sn.length() - 1).matches("[A-Z]+") && sn
                        .substring(3, 7).matches("\\d+") ) {
                    String value = sn.substring(7, sn.length() -1); 
                    System.out.println("match found: " + value);
                    sum += Integer.parseInt(value);
                }
                else {
                    System.out.println("match NOT found");
                }
            }
        }

        return sum;
    }

    public static boolean isLetterDistinct(String str) {
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j))
                    return false;

        return true;
    }

    public static boolean isInclusiveYear(String str) {
        
        return false;
    }

    public static boolean isValidCurrency(String str) {

        return false;
    }

}
