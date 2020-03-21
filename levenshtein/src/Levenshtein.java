/**
 *
 * @author madlen96
 */
import java.util.*;
import java.io.*;

public class Levenshtein {
    private String testString;
    private Scanner scanner;
    private File file;
    private int len;
    private int[][] matrix;

    public Levenshtein(File file, String testString) {
        this.testString = testString;
        this.len = testString.length();
        this.file = file;
        try {
            this.scanner = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            System.out.println("provided filepath not found");
            System.exit(-1);
        }
    }

    public int calculate() {
        int minLen = Integer.MAX_VALUE;
        int cost;
        int resultLineNumber = 0;
        char[] testStringArray = this.testString.toCharArray();
        for (int lineNum = 1; this.scanner.hasNext(); lineNum++) {
            String currentStr = this.scanner.nextLine();
            char[] currentStrArray = currentStr.toCharArray();
            int currentStrLen = currentStr.length();
            int N = currentStrLen + 1;
            int M = this.len + 1;
            this.matrix = newMatrix(N, M);
            for (int i = 1; i < N; i++) {
                this.matrix[i][0] = i;
            }
            for (int j = 1; j < M; j++) {
                this.matrix[0][j] = j;
            }
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    if (currentStrArray[i - 1] == testStringArray[j - 1]) {
                        cost = 0;
                    } else {
                        cost = 1;
                    }
                    this.matrix[i][j] = getMin(this.matrix[i - 1][j] + 1, this.matrix[i][j - 1] + 1, this.matrix[i - 1][j - 1] + cost);
                }
            }
            if (this.matrix[N - 1][M - 1] < minLen) {
                minLen = this.matrix[N - 1][M - 1];
                resultLineNumber = lineNum;
            }
        }
        scanner.close();
        return resultLineNumber;
    }


    private int[][] newMatrix(int row, int column) {
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    private int getMin(int a, int b, int c) {
        int minimum;
        if (a < b) {
            minimum = a;
        } else {
            minimum = b;
        }
        if (c < minimum) {
            minimum = c;
        }
        return minimum;
    }
}
