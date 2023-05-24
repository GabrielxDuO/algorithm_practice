import java.util.*;
import java.io.*;

public class _删除字符 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        StringBuilder s = new StringBuilder(in.nextLine());
        int t = in.nextInt();
        while (t-- > 0) {
            int i = 0;
            for (; i < s.length() - 1; ++i) {
                if (s.charAt(i) > s.charAt(i + 1)) break;
            }
            s.deleteCharAt(i);
        }
        System.out.println(s);
    }
}
