import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class _找零问题 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int money = (int) in.nval;
        System.out.printf("100:%d\n", money / 100);
        money %= 100;
        System.out.printf("50:%d\n", money / 50);
        money %= 50;
        System.out.printf("20:%d\n", money / 20);
        money %= 20;
        System.out.printf("5:%d\n", money / 5);
        money %= 5;
        System.out.printf("1:%d\n", money);
    }
}
