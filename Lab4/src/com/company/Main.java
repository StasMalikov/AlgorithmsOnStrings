package com.company;

import java.util.Arrays;
import java.util.Scanner;

//AABCAABXAAZ
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] arr = in.nextLine().toCharArray();
        int[] zValues = new int[arr.length];

        zValues[0] = 0;
        int j;
        for (int i = 1; i < arr.length; i++) {
            j = i;
            while (j < arr.length && arr[j] == arr[j - i]) {
                j++;
            }
            zValues[i] = j - i;
        }

        System.out.println(Arrays.toString(zValues));
    }
}