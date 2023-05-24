import java.util.*;
import java.io.*;

public class _二进制中1的个数 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int cnt = 0;
        while (n != 0) {
            n &= n - 1;
            ++cnt;
        }
        System.out.println(cnt);
    }
}
