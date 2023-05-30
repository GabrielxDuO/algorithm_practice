import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BitSet bs = new BitSet();
        bs.set(100000, true);
        System.out.println(bs);
        System.out.println(bs.size());
        System.out.println(bs.length());
        System.out.println(bs.cardinality());
    }
}
