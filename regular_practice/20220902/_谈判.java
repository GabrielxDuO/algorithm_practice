import java.io.*;
import java.util.*;

public class _谈判 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        Queue<Integer> priQueue = new PriorityQueue<>();
        while (n-- > 0) {
            in.nextToken();
            priQueue.offer((int) in.nval);
        }
        int minCost = 0;
        while (!priQueue.isEmpty()) {
            int sum = priQueue.poll();
            if (priQueue.isEmpty()) {
                System.out.println(minCost);
                break;
            }
            sum += priQueue.poll();
            minCost += sum;
            priQueue.offer(sum);
        }
    }
}