import java.io.*;

public class _最大化股票交易的利润 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        while (N-- > 0) {
            in.nextToken();
            int price = (int) in.nval;
            if (price < minPrice) minPrice = price;
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        System.out.println(maxProfit);
    }
}
