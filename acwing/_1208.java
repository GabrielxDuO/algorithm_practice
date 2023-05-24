import java.util.*;
import java.io.*;

public class _1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] begin = in.readLine().toCharArray();
        char[] target = in.readLine().toCharArray();
        int n = begin.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (begin[i] != target[i]) {
                ++cnt;
                begin[i + 1] = begin[i + 1] == '*' ? 'o' : '*';
            }
        }
        System.out.println(cnt);
    }
}
