import java.io.*;
import java.util.*;

public class _用杂志拼接信件 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String a = in.readLine(), b = in.readLine();
        Map<Character, Integer> cnts = new HashMap<>();
        for (char c : a.toCharArray()) {
            cnts.put(c, cnts.getOrDefault(c, 0) + 1);
        }
        for (char c : b.toCharArray()) {
            int cnt = cnts.getOrDefault(c, 0) - 1;
            if (cnt < 0) {
                System.out.println("NO");
                return;
            }
            cnts.put(c, cnt);
        }
        System.out.println("YES");
    }
}