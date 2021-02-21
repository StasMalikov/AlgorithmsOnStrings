package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] line = in.nextLine().toCharArray();
        int result = 0;
        if(line.length != 2) {
            for (int i = line.length - 1; i > 0; i--) {
                if(find(i, line)){
                    result = i;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    public static boolean find(int size, char[] line) {
        for (int i = 0; i < size; i++) {
            if(line[i] != line[line.length - size + i]) {
                return false;
            }
        }

        return true;
    }
}