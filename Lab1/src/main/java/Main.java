import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] line = in.nextLine().toCharArray();
        char[] subLine = in.nextLine().toCharArray();
        String result = "";
        for (int i = 0; i <= line.length - subLine.length; i++) {
            for (int j = 0; j < subLine.length; j++) {
                if(line[i+j] != subLine[j]) {
                    break;
                }

                if(j == subLine.length -1) {
                    result += "" + i + " ";
                }
            }
        }

        System.out.println(result);
    }
}
