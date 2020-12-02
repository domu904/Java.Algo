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

        List<Integer> list = new ArrayList<Integer>();
        list.add(13);
        list.add(10);
        list.add(21);
        list.add(20);

        int result = Result.moves(list);
        System.out.println("The result is " + result);
    }
}

class Result {

    public static int moves(List<Integer> arr) {
        //System.out.println("In moves");

        boolean isSwap = false;
        int sum = 0;
        int ptr1 = 0;
        int ptr2 = 0;
        int[] midPoint = findMidPoint(arr);
        int midIndex = 0;
        if(midPoint.length == 1){
            midIndex = midPoint[0];
        }
        else {
            midIndex = midPoint[1];
        }


        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) % 2 != 0 && i != midIndex ) {
                System.out.println("In if1 : " + midIndex);
                ptr1 = i;
            
                for (int j = arr.size() - 1; j >= midIndex; j--) {
                    if (arr.get(j) % 2 == 0 ) {
                        System.out.println("In if2 : " + j);
                        ptr2 = j;
                        isSwap = true;
                    }

                    if (isSwap) {
                        swap(arr, ptr1, ptr2);
                        isSwap = false;
                        sum++;
                        break;

                    }
                }
            }
            
        }

        return sum;
    }

    public static int[] findMidPoint(List<Integer> arr) {
        int[] a;
        if (arr.size() % 2 == 0) {
            // even-length array (two middle elements)
            a = new int[2];
            a[0] = (arr.size() / 2) - 1;
            a[1] = arr.size() / 2;

            // System.out.println("In findMidPoint: " + ((arr.size() / 2)));
        } else {
            // odd-length array (only one middle element)
            a = new int[1];
            a[0] = arr.size() / 2;
        }
        return a;
    }

    public static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static boolean sortedChecker(List<Integer> arr) {
        boolean isSorted = false;
        int[] midPoint = findMidPoint(arr);

        for (int i = 0; i < arr.size(); i++) {

        }

        return isSorted;
    }
    

}
