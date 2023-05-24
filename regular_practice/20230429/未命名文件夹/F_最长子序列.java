import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] s = in.readLine().toCharArray();
        char[] t = in.readLine().toCharArray();
        int i = 0, j = 0;
        for (; i < s.length && j < t.length; ++i) {
            if (s[i] == t[j]) ++j;
        }
        System.out.println(j);
    }
}
