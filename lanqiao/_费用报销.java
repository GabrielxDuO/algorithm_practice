import java.util.*;
import java.io.*;

public class _费用报销 {
    static final int[] M = {0, 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static {
        for (int i = 2; i <= 12; ++i) M[i] += M[i - 1];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            int a = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            in.nextToken();
            int v = (int) in.nval;
            int d = M[a] + b;
            
        }
    }
}
