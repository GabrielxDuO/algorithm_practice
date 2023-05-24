import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class _大学里的树木要打药 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int M = (int) in.nval;
        int total = 0;
        while (M-- > 0) {
            in.nextToken();
            int left = (int) in.nval;
            in.nextToken();
            int right = (int) in.nval;
            in.nextToken();
            int money = (int) in.nval;
            total += (right - left + 1) * money;
        }
        System.out.println(total);
    }
}
