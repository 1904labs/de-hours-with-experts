package com.labs1904;

import java.util.Arrays;

public class NextBiggestNumber {

    public static void main(String[] args) {
        Integer input = Integer.parseInt(args[0]);
        Integer nextBiggestNumber = getNextBiggestNumber(input);
//        Integer newInt = nextBiggestNumber;
        System.out.println("Input: " + input);
        System.out.println( "Next biggest number: " + nextBiggestNumber );
    }

    public static int getNextBiggestNumber(Integer integ) {

        //Break apart Integer.
        //Run a loop to compare relative values of different configurations.
        //nBN > i, but < all other orientations.
        //Focus on last two digits, then last three digits, the last four digits. etc...
        //Return out of loop, once nBN is found.

        String iString = integ.toString();
        int arrLength = iString.length();
        int[] buildArray = new int[arrLength];
        int[] compBuildArray = new int[arrLength];

        for (int i=0; i < arrLength; i++) {
            buildArray[i] = iString.charAt(i) - '0';
//            System.out.println(buildArray[i]);
        }

        // Now that the array is created, we need to make a method that juggles the indeces, eliminates the
        // values less than the original number, and narrows down the remaining numbers to find the one that is
        // "just greater than" the given input.

        // Values of each index, inverted into alphabetical order.
        if (arrLength == 2) {
            compBuildArray = twoFer(buildArray);
        }
        if (arrLength == 3) {
            compBuildArray = threeFer(buildArray);
        }
        if (arrLength == 4) {
            compBuildArray = fourFer(buildArray);
        }
        if (arrLength == 5) {
            compBuildArray = fiveFer(buildArray);
        }

// This rebuilds the appropriate array into an Integer to return.
        Integer rebuiltInt = 0;
        for( int k=0; k < arrLength; k++) {
            rebuiltInt *= 10;
            rebuiltInt += compBuildArray[k];
        }

        if (rebuiltInt <= integ) {
            rebuiltInt = -1;
        }
        return rebuiltInt;
    }

    public static int[] twoFer(int[] bld2Arr) {
        // Method for 2 digit integer.

        int a2Length = bld2Arr.length;
        int a = bld2Arr[a2Length - 1];
        int b = bld2Arr[a2Length - 2];

        if (a > b) {
            bld2Arr[0] = a;
            bld2Arr[1] = b;
        }
        return bld2Arr;
    }

    public static int[] threeFer(int[] bld3Arr) {
        //Simple method for 3 digit integer.

        int aLength = bld3Arr.length;
        int a = bld3Arr[aLength - 1];
        int b = bld3Arr[aLength - 2];
        int c = bld3Arr[aLength - 3];

        if (a > b) {
            bld3Arr[1] = a;
            bld3Arr[2] = b;
        } else if (b > c){
            bld3Arr[0] = b;
            bld3Arr[1] = a;
            bld3Arr[2] = c;
        }

        return bld3Arr;
    }

    public static int[] fourFer(int[] bld4Arr) {
        // Method for 4 digit integer. Requires a sub array to order the remaining
        // digits, below the digit swapped.
        //
        // There should be a way to build in recursion.

        int aLength = bld4Arr.length;
        int a = bld4Arr[aLength - 1];
        int b = bld4Arr[aLength - 2];
        int c = bld4Arr[aLength - 3];
        int d = bld4Arr[aLength - 4];

        if (a > b) {
            bld4Arr[2] = a;
            bld4Arr[3] = b;
        } else if (a > c) {
            bld4Arr[1] = a;
            bld4Arr[2] = c;
            bld4Arr[3] = b;
        } else if (b > c) {
            bld4Arr[1] = b;
            bld4Arr[2] = a;
            bld4Arr[3] = c;
        } else if (a > d) {
            bld4Arr[0] = a;
            int[] ordArr = {b, c, d};
            Arrays.sort(ordArr);
            bld4Arr[1] = ordArr[0];
            bld4Arr[2] = ordArr[1];
            bld4Arr[3] = ordArr[2];
        } else if (b > d) {
            bld4Arr[0] = b;
            int[] ordArr = {a, c, d};
            Arrays.sort(ordArr);
            bld4Arr[1] = ordArr[0];
            bld4Arr[2] = ordArr[1];
            bld4Arr[3] = ordArr[2];
        } else if (c > d) {
            bld4Arr[0] = c;
            int[] ordArr = {a, b, d};
            Arrays.sort(ordArr);
            bld4Arr[1] = ordArr[0];
            bld4Arr[2] = ordArr[1];
            bld4Arr[3] = ordArr[2];
        }

        return bld4Arr;
    }

    public static int[] fiveFer(int[] bld5Arr) {
        // Method for 5 digit integer. Requires a sub array to order the remaining
        // digits, below the digit swapped.
        //
        // There should be a way to build in recursion.

        int aLength = bld5Arr.length;
        int a = bld5Arr[aLength - 1];
        int b = bld5Arr[aLength - 2];
        int c = bld5Arr[aLength - 3];
        int d = bld5Arr[aLength - 4];
        int e = bld5Arr[aLength - 5];

        if (a > b) {
            bld5Arr[3] = a;
            bld5Arr[4] = b;
        } else if (a > c) {
            bld5Arr[2] = a;
            bld5Arr[3] = c;
            bld5Arr[4] = b;
        } else if (b > c) {
            bld5Arr[2] = b;
            bld5Arr[3] = a;
            bld5Arr[4] = c;
        } else if (a > d) {
            bld5Arr[1] = a;
            int[] ordArr = {b, c, d};
            Arrays.sort(ordArr);
            bld5Arr[2] = ordArr[0];
            bld5Arr[3] = ordArr[1];
            bld5Arr[4] = ordArr[2];
        } else if (b > d) {
            bld5Arr[1] = b;
            int[] ordArr = {a, c, d};
            Arrays.sort(ordArr);
            bld5Arr[2] = ordArr[0];
            bld5Arr[3] = ordArr[1];
            bld5Arr[4] = ordArr[2];
        } else if (c > d) {
            bld5Arr[1] = c;
            int[] ordArr = {b, a, d};
            Arrays.sort(ordArr);
            bld5Arr[2] = ordArr[0];
            bld5Arr[3] = ordArr[1];
            bld5Arr[4] = ordArr[2];
        } else if (a > e) {
            bld5Arr[0] = a;
            int[] ordArr = {b, c, d, e};
            Arrays.sort(ordArr);
            bld5Arr[1] = ordArr[0];
            bld5Arr[2] = ordArr[1];
            bld5Arr[3] = ordArr[2];
            bld5Arr[4] = ordArr[3];
        } else if (b > e) {
            bld5Arr[0] = b;
            int[] ordArr = {a, c, d, e};
            Arrays.sort(ordArr);
            bld5Arr[1] = ordArr[0];
            bld5Arr[2] = ordArr[1];
            bld5Arr[3] = ordArr[2];
            bld5Arr[4] = ordArr[3];
        } else if (c > e) {
            bld5Arr[0] = c;
            int[] ordArr = {a, b, d, e};
            Arrays.sort(ordArr);
            bld5Arr[1] = ordArr[0];
            bld5Arr[2] = ordArr[1];
            bld5Arr[3] = ordArr[2];
            bld5Arr[4] = ordArr[3];
        } else if (d > e) {
            bld5Arr[0] = d;
            int[] ordArr = {b, c, a, e};
            Arrays.sort(ordArr);
            bld5Arr[1] = ordArr[0];
            bld5Arr[2] = ordArr[1];
            bld5Arr[3] = ordArr[2];
            bld5Arr[4] = ordArr[3];
        }

        return bld5Arr;
    }
}
