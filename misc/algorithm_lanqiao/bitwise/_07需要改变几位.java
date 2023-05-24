import java.util.*;
import java.io.*;

public class _07需要改变几位 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int a = (int) in.nval;
        in.nextToken();
        int b = (int) in.nval;
        int cnt = 0;
        for (int xor = a ^ b; xor != 0; xor &= (xor - 1)) ++cnt;
        System.out.println(cnt);
    }
}
