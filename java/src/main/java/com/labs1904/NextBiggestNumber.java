package com.labs1904;

import java.util.Arrays;
import java.util.Collections;

public class NextBiggestNumber {

    public static void main(String[] args) {
        Integer input = Integer.parseInt(args[0]);
        int nextBiggestNumber = getNextBiggestNumber(input);
        System.out.println("Input: " + input);
        System.out.println("Next biggest number: " + nextBiggestNumber);
    }

    public static int getNextBiggestNumber(Integer i) {

        //Break apart Integer.
        //Run a loop to compare relative values of different configurations.
        //nBN > i, but < all other orientations.
        //Focus on last two digits, then last three digits, the last four digits. etc...
        //Return out of loop, once nBN is found.

        String iString = i.toString();
        int arrLength = iString.length();
        int[] buildArray = new int[arrLength];
        int[] compBuildArray = new int[arrLength];

        for (int l=0; l < arrLength; l++) {
            buildArray[l] = iString.charAt(l) - '0';
//            System.out.println(buildArray[l]);
        }

        // Now that the array is created, we need to make a method that juggles the indeces, eliminates the
        // values less than the original number, and narrows down the remaining numbers to find the one that is
        // "just greater than" the given input.

        // Values of each index, inverted into alphabetical order.
        int a = buildArray[arrLength - 1];
        int b = buildArray[arrLength - 2];
        int c = buildArray[arrLength - 3];
        if (arrLength == 3) {
             compBuildArray = threeFer(buildArray);
        }
        if (arrLength == 4) {
            int d = buildArray[arrLength - 4];
            compBuildArray = int[] fourFer(buildArray);
        } else if (arrLength == 5) {
            int d = buildArray[arrLength - 4];
            int e = buildArray[arrLength - 5];
            compBuildArray = int[] fiveFer(buildArray);
        }

//        First attempt... aw no.
//        if (b < a) {
//            int temp1 = a;
//            buildArray[arrLength - 1] = b;
//            buildArray[arrLength - 2] = temp1;
//        } else if (c < b){
//            int temp2 = b;
//            buildArray[arrLength - 1] = a;
//            buildArray[arrLength - 2] = c;
//            buildArray[arrLength - 3] = temp2;
//        } else if (d < c){
//            int temp3 = c;
//            buildArray[arrLength - 1] = a;
//            buildArray[arrLength - 2] = b;
//            buildArray[arrLength - 3] = d;
//            buildArray[arrLength - 4]= temp3;
//        } else {
//            return -1;
//        }

//        Integer rebuiltInt = null;
//        rebuiltInt.parseInt(buildArray.toString());

        // 2nd attempt


        // This rebuilds the appropriate array into an Integer to return.
        Integer rebuiltInt = 0;
        for( int k=0; k < arrLength; k++) {
            rebuiltInt *= 10;
            rebuiltInt += buildArray[k];
        }

        return rebuiltInt;
    }
}

    public static int threeFer(int[] bld3Arr) {

    }

    public static int fourFer(int[] bld4Arr) {

    }

    public static int fiverFer(int[] bld5Arr) {

    }