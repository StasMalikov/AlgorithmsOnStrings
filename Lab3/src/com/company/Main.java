package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//ABAABABAABAAB
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> subStrings =  generateSubStrings(in.nextLine());

        List<String> bordersList = new ArrayList<>();

        for (int i = 0; i < subStrings.size(); i++) {
            String result = findBorder(subStrings.get(i));

            if ( !result.equals("") ) {
                bordersList.add(result);
            }
        }

        System.out.println("Массив подстрок: " + subStrings.toString());

        System.out.println("Массив граней: " + bordersList.toString());
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
        for (int i = 0; i < arr.length; i++) {
            String subStr = "";
            for (int j = i; j < arr.length; j++) {
                if (j == i)
                    continue;
                for (int k = i; k <= j; k++) {
                    subStr += arr[k];
                }
                result.add(subStr);
                subStr = "";
            }
        }

        return result;
    }
}