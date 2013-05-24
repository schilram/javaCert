package ch.zhaw.javacert.uebungen.Woche2.Uebung4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: rschilling
 */
public class Uebung4 {

    public static void main (final String[] args) {

        final ArrayList<String> list = new ArrayList<String>();

        list.add("Apfel");
        list.add("Birne");
        list.add("Banane");
        list.add("Ananas");
        list.add("Kiwi");
        list.add(0, "Mango");
        System.out.println(list.toString());

        /* some ArrayList functions */
        list.addAll(list);
        System.out.println(list.toString());

        Integer i = 3;
        int ii = 3;
        list.remove(i.intValue());
        list.remove(ii);


        System.out.println(list.contains("Apfel"));

        System.out.println(list.indexOf("Mango"));

        list.remove(0);
        System.out.println(list.toString());

        list.remove("Apfel");
        System.out.println(list.toString());

        System.out.println(list.subList(3,6).toString());

        /* System.arraycopy() function */
        System.arraycopy(list,0, list, 0, 2);
        System.out.println(list.toString());


        /* some Collections functions */
        Collections.sort(list);
        System.out.println(list.toString());

        Collections.reverse(list);
        System.out.println(list.toString());

        Collections.shuffle(list);
        System.out.println(list.toString());

        Collections.shuffle(list);
        System.out.println(list.toString());

        Collections.swap(list, 0, 1);
        System.out.println(list.toString());

        Collections.replaceAll(list, "Apfel", "Orange");
        System.out.println(list.toString());

        Collections.fill(list, "Frucht");
        System.out.println(list.toString());
    }

}
