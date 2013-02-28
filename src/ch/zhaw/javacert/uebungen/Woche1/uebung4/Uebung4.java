package ch.zhaw.javacert.uebungen.Woche1.uebung4;
/**
 Schreiben Sie ein kleines Programm bestehend aus einer Klasse, definieren Sie in der Klasse ein Datenfeld vom Typ StringBuilder
 und ein Datenfeld vom Typ String.
 Überprüfen Sie in Ihrer Anwendung die Funktionsweise der Methoden der Klassen StringBuilder und String.
 Führen Sie in einem Loop Konkatenierungs-Operationen aus für StringBuilder und String und vergleichen Sie die Performance der beiden Klassen.
 **/

/**
 * @author rschilling
 */
public class Uebung4 {

    final static int LOOPS = 100000;

    public static void main(String [] args) {

        Long start;
        Long stop;

        StringBuilder sb = new StringBuilder("Hello");
        String s = new String("Hello");


        start = System.currentTimeMillis();
        for (int i = 0; i < LOOPS; i ++) {
            sb.append("Hello");
        }
        stop = System.currentTimeMillis();
        System.out.println("sb.append(sb) -" + LOOPS + " Loops: " + diff(start, stop) + "ms");


        start = System.currentTimeMillis();
        for (int i = 0; i < LOOPS; i ++) {
            s = s + "Hello";
        }
        stop = System.currentTimeMillis();
        System.out.println("s + s " + LOOPS + " Loops: " + diff(start, stop) + "ms");


        start = System.currentTimeMillis();
        for (int i = 0; i < LOOPS; i ++) {
            s = s.concat("Hello");
        }
        stop = System.currentTimeMillis();
        System.out.println("s.concat(s) -" + LOOPS + " Loops: " + diff(start, stop) + "ms");

    }

    private static long diff(Long start, Long end) {
        return (end - start);
    }


}
