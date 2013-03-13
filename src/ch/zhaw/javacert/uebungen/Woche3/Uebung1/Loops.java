package ch.zhaw.javacert.uebungen.Woche3.Uebung1;

/**
 * @author rschilling
 */
public class Loops {

    public static void main(String[] args) {


        System.out.println("before: for(int i = 0; i < 5; i++");
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }
        System.out.println();

        int i = 0;
        System.out.println("i = " + i);
        System.out.println("before: while (i < 5)");
        while (i < 5) {
            System.out.println("i = " + i);
            i++;
        }
        System.out.println();


    }
}
