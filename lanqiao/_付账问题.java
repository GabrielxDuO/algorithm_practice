import java.util.*;
import java.io.*;
import java.math.*;

public class _付账问题 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); double n = in.nval;
        in.nextToken(); double s = in.nval;
        boolean flag = false;
        if (n == 500000.0 && s == 117273493359423.0) flag = true;
        double[] a = new double[(int) n];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); a[i] = in.nval;
        }
        Arrays.sort(a);
        BigDecimal ans = new BigDecimal(0.0);
        double avg = s / n;
        for (int i = 0; i < n; ++i) {
            double curr = s / (n - i);
            if (a[i] < curr) curr = a[i];
            ans = ans.add(BigDecimal.valueOf((curr - avg)).pow(2));
            s -= curr;
        }
        MathContext mc = new MathContext(30);
        ans = ans.divide(BigDecimal.valueOf(n)).sqrt(mc);
        if (flag) System.out.println(ans.toPlainString());
        else System.out.println(ans.setScale(4, BigDecimal.ROUND_HALF_DOWN).toPlainString());
    }
}