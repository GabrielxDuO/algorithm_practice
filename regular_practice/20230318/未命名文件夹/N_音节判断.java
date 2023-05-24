import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        String[] ss = (word + 'b').split("[aeiou]+");
        if (ss.length != 3 || ss.length > 0 && ss[ss.length - 1].length() != 1) {
            System.out.println("no");
            return;
        }
        for (String s : ss) {
            if (s.isEmpty()) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}
