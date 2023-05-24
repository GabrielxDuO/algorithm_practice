import java.io.*;
import java.util.*;

public class _排座椅 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int M = (int) in.nval;
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int K = (int) in.nval;
        in.nextToken();
        int L = (int) in.nval;
        in.nextToken();
        int D = (int) in.nval;
        int[] rowCnts = new int[M];
        int[] colCnts = new int[N];
        while (D-- > 0) {
            in.nextToken();
            int X = (int) in.nval;
            in.nextToken();
            int Y = (int) in.nval;
            in.nextToken();
            int P = (int) in.nval;
            in.nextToken();
            int Q = (int) in.nval;
            if (X == P) ++colCnts[Math.min(Y, Q)];
            else ++rowCnts[Math.min(X, P)];
        }
        Set<Integer> partions = new TreeSet<>();
        for (int i = 0; i < K; ++i) {
            int maxIdx = 1;
            for (int j = 2; j < M; ++j) {
                if (rowCnts[j] > rowCnts[maxIdx]) maxIdx = j;
            }
            partions.add(maxIdx);
            rowCnts[maxIdx] = 0;
        }
        boolean isFirst = true;
        for (int row : partions) {
            if (isFirst) isFirst = false;
            else System.out.print(" ");
            System.out.print(row);
        }
        System.out.print("\n");
        partions.clear();
        for (int i = 0; i < L; ++i) {
            int maxIdx = 1;
            for (int j = 2; j < N; ++j) {
                if (colCnts[j] > colCnts[maxIdx]) maxIdx = j;
            }
            partions.add(maxIdx);
            colCnts[maxIdx] = 0;
        }
        isFirst = true;
        for (int col : partions) {
            if (isFirst) isFirst = false;
            else System.out.print(" ");
            System.out.print(col);
        }
    }
}
