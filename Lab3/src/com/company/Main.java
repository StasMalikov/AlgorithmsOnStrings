package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//ABAABABAABAAB
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        char[] arr = input.toCharArray();

        int n = arr.length;
        int[] borders = new int[n];

        borders[0] = 0;

        int bordersRight;
        for (int i = 1; i < n ; i++) {
            bordersRight = borders[i - 1];
            while (bordersRight > 0 && (arr[i] != arr[bordersRight])) {
                bordersRight = borders[bordersRight - 1];
            }

            if (arr[i] == arr[bordersRight]) {
                borders[i] = bordersRight + 1;
            } else {
                borders[i] = 0;
            }
        }

        System.out.println(Arrays.toString(borders));

        List<String> subStrings =  generateSubStrings(input);

        List<String> bordersList = new ArrayList<>();
        bordersList.add("");

        for (int i = 0; i < subStrings.size(); i++) {
            bordersList.add(findBorder(subStrings.get(i)));
        }

        System.out.println("Массив подстрок: " + subStrings.toString());

        System.out.println("Массив граней  : " + bordersList.toString());
    }

    public static String findBorder(String string) {
        char[] arr = string.toCharArray();

        int result = 0;
        if(arr.length != 2) {
            for (int i = arr.length - 1; i > 0; i--) {
                if(find(i, arr)){
                    result = i;
                    break;
                }
            }
        }

        return string.substring(0, result);
    }

    public static boolean find(int size, char[] line) {
        for (int i = 0; i < size; i++) {
            if(line[i] != line[line.length - size + i]) {
                return false;
            }
        }

        return true;
    }

    public static List<String> generateSubStrings(String source) {
        List<String> result = new ArrayList<>();

        char[] arr = source.toCharArray();
        String subStr = "";
        for (int j = 0; j < arr.length; j++) {
            if (j == 0)
                continue;
            for (int k = 0; k <= j; k++) {
                subStr += arr[k];
            }
            result.add(subStr);
            subStr = "";
        }

        return result;
    }
}