import java.io.*;

public class _B {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int w = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int n = (int) in.nval;
        --m;
        --n;
        int mx = m / w;
        int my = (mx & 1) == 0 ? m % w : w - m % w - 1;
        int nx = n / w;
        int ny = (nx & 1) == 0 ? n % w : w - n % w - 1;
        System.out.println(Math.abs(mx - nx) + Math.abs(my - ny));
    }
}
