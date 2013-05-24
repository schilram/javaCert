package ch.zhaw.javacert.uebungen;

/**
 * @author rschilling
 */
public class Test {


    public static void main(String args[]) {
        int i=3;
        int j=0;
        int result=1;
        result += (i-- * --j);

        final String s = "";

        String[] strings = s.split("/");

        try {
            int start = Integer.parseInt(strings[0].trim());
        } catch (Exception e) {

        }

        int end = Integer.parseInt(strings[1]);

    }

}
