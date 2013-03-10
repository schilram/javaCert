package ch.zhaw.javacert.uebungen.Woche1.Uebung3;

/**
 * @author: rschilling
 */
public class Uebung3 {

    Character c1 = 'a';

    Integer i1 = new Integer(5);
    Integer i2 = 5;

    Long l1 = new Long(Long.valueOf("5"));

    public static void main(String[] args) {

        Uebung3 u = new Uebung3();

        System.out.println(u.c1.equals('a'));
        System.out.println(u.c1.toString());
        System.out.println(u.c1.charValue());

        System.out.println(u.i1.byteValue());
        System.out.println(u.i1.compareTo(u.i2));

        System.out.println(u.l1.byteValue());
    }

}
