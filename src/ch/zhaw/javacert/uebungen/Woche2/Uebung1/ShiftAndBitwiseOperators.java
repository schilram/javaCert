package ch.zhaw.javacert.uebungen.Woche2.Uebung1;

/**
 * @author rschilling
 */
public class ShiftAndBitwiseOperators {

    public static void main(final String [] args) {
        final int operand = 3;
        final int zahl1 = -100;
        final int zahl2 = 100;

        int t1;
        int t2;

        System.out.println("Shift Operators:");

        t1 = zahl1 >> operand;
        t2 = zahl2 >> operand;
        System.out.println(zahl1 + " >> " + operand + " = " + t1);
        System.out.println(zahl2 + " >> " + operand + " = " + t2);
        System.out.println();

        t1 = zahl1 << operand;
        t2 = zahl2 << operand;
        System.out.println(zahl1 + " << " + operand + " = " + t1);
        System.out.println(zahl2 + " << " + operand + " = " + t2);
        System.out.println();

        t1 = zahl1 >>> operand;
        t2 = zahl2 >>> operand;
        System.out.println(zahl1 + " >>> " + operand + " = " + t1);
        System.out.println(zahl2 + " >>> " + operand + " = " + t2);
        System.out.println();

        System.out.println("Bitwise Operators:");
        t1 = zahl1 & zahl2;
        System.out.println(zahl1 + " & " + zahl2 + " = " + t1);
        System.out.println(Integer.toBinaryString(zahl1) + " & " + Integer.toBinaryString(zahl2) + " = " + Integer.toBinaryString(t1));
        System.out.println();

        t1 = zahl1 ^ zahl2;
        System.out.println(zahl1 + " ^ " + zahl2 + " = " + t1);
        System.out.println(Integer.toBinaryString(zahl1) + " ^ " + Integer.toBinaryString(zahl2) + " = " + Integer.toBinaryString(t1));
        System.out.println();

        t1 = zahl1 | zahl2;
        System.out.println(zahl1 + " | " + zahl2 + " = " + t1);
        System.out.println(Integer.toBinaryString(zahl1) + " | " + Integer.toBinaryString(zahl2) + " = " + Integer.toBinaryString(t1));
        System.out.println();

    }
}
