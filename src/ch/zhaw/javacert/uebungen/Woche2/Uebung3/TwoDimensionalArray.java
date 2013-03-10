package ch.zhaw.javacert.uebungen.Woche2.Uebung3;

/**
 * @author: rschilling
 */
public class TwoDimensionalArray {

    public static void main(final String args[]) {

        int[][] twoDimensionalArray1;
        twoDimensionalArray1 = new int[3][4];

        int[][] twoDimensionalArray2;
        twoDimensionalArray2 = new int[10][];
        for (int i = 0; i < twoDimensionalArray2.length; i++) {
            twoDimensionalArray2[i] = new int[i];
        }

    }
}
