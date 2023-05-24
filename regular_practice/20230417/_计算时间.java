import java.util.*;
import java.io.*;

public class _计算时间 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int T = (int) in.nval;
        while (T-- > 0) {
            in.nextToken(); int t = (int) in.nval;
            System.out.printf("%02d:%02d:%02d\n", t / 3600 % 24, t / 60 % 60, t % 60);
        }
    }
}
