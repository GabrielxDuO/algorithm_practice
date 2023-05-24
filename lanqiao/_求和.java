import java.util.*;
import java.io.*;

public class _求和 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        long sum = 0L, squSum = 0L;
        while (n-- > 0) {
            in.nextToken();
            int x = (int) in.nval;
            sum += x;
            squSum += (long) x * x;
        }
        System.out.println(sum * sum - squSum >> 1);
    }
}
