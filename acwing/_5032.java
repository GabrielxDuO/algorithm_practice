import java.util.*;
import java.io.*;

public class _5032 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        char[] s = ('\0' + in.next()).toCharArray();
        while (m-- > 0) {
            int l = in.nextInt(), r = in.nextInt();
            char a = in.next().charAt(0), b = in.next().charAt(0);
            for (int i = l; i <= r; ++i) {
                if (s[i] == a) s[i] = b;
            }
        }
        System.out.println(String.valueOf(s).substring(1));
    }
}
