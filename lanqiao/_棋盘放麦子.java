import java.util.*;
import java.io.*;
import java.math.*;

public class _棋盘放麦子 {
    public static void main(String[] args) {
        BigInteger x = new BigInteger("1"), sum = new BigInteger("0");
        for (int i = 1; i <= 64; ++i) {
            sum = sum.add(x);
            x = x.shiftLeft(1);
        }
        System.out.println(sum);
    }
}
