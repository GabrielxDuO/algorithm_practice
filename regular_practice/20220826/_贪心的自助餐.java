import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _贪心的自助餐 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int C = (int) in.nval;
        List<Cuisine> cuisines = new ArrayList<>();
        while (n-- > 0) {
            in.nextToken();
            double v = in.nval;
            in.nextToken();
            int w = (int) in.nval;
            cuisines.add(new Cuisine(v, w));
        }
        Collections.sort(cuisines);
        double maxValue = 0.0;
        for (Cuisine cuisine : cuisines) {
            if (C >= cuisine.weight) {
                C -= cuisine.weight;
                maxValue += cuisine.price;
            } else {
                maxValue += cuisine.unitPrice * C;
                break;
            }
        }
        System.out.printf("%.3f", maxValue);
    }

    static class Cuisine implements Comparable<Cuisine> {
        double unitPrice, price;
        int weight;

        public Cuisine(double price, int weight) {
            unitPrice = price / weight;
            this.price = price;
            this.weight = weight;
        }

        @Override
        public int compareTo(Cuisine c) {
            return Double.compare(c.unitPrice, this.unitPrice);
        }
    }
}
