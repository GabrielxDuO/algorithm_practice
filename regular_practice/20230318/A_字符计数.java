import java.util.*;
import java.io.*;

public class A_字符计数 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        char[] s = in.nextLine().toCharArray();
        int cnt1 = 0, cnt2 = 0;
        for (char c : s) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ++cnt1;
            else ++cnt2;
        }
        System.out.println(cnt1 + "\n" + cnt2);
    }
}
