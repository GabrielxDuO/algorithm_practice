import java.util.*;
import java.io.*;

public class F_解谜游戏 {
    static class State {
        char[] outer, mid, inner;

        State() {}

        State(String outer, String mid, String inner) {
            this.outer = outer.toCharArray();
            this.mid = mid.toCharArray();
            this.inner = inner.toCharArray();
        }

        State op1() {
            char[] o = outer.clone(), m = mid.clone(), i = inner.clone();
            spin(o); spin(m); spin(i);
            State ns = new State();
            ns.outer = o; ns.mid = m; ns.inner = i;
            return ns;
        }

        State op2() {
            char[] o = outer.clone(), m = mid.clone(), i = inner.clone();
            spin(o, false); spin(m, false); spin(i, false);
            State ns = new State();
            ns.outer = o; ns.mid = m; ns.inner = i;
            return ns;
        }

        State op3() {
            char[] o = outer.clone(), m = mid.clone(), i = inner.clone();
            char t = i[0];
            i[0] = o[0];
            o[0] = m[0];
            m[0] = t;
            State ns = new State();
            ns.outer = o; ns.mid = m; ns.inner = i;
            return ns;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof State) {
                State s = (State) o;
                return Arrays.equals(this.outer, s.outer) && Arrays.equals(this.mid, s.mid) && 
                    Arrays.equals(this.inner, s.inner);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(1L * Arrays.hashCode(outer) + Arrays.hashCode(mid) + Arrays.hashCode(inner));
        }

        @Override public String toString() {
            return '{' + Arrays.toString(outer) + ",\n" + Arrays.toString(mid) + ",\n" + Arrays.toString(inner) + '}'; 
        }
    }
    static Set<State> vis = new HashSet<>();

    static void spin(char[] arr) {
        char t = arr[0];
        for (int i = 1; i < arr.length; ++i) arr[i - 1] = arr[i];
        arr[arr.length - 1] = t;
    }

    static void spin(char[] arr, boolean flag) {
        char t = arr[arr.length - 1];
        for (int i = 1; i < arr.length; ++i) arr[i] = arr[i - 1];
        arr[0] = t;
    }

    static State dest = new State("GGGGGGGGGGGG", "RRRRRRRR", "YYYY");

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); in.nextLine();
        Queue<State> que = new LinkedList<>();
        outer: while (t-- > 0) {
            String a = in.nextLine(), b = in.nextLine(), c = in.nextLine();
            State s = new State(a, b, c);
            que.clear();
            que.offer(s);
            vis.add(s);
            while (!que.isEmpty()) {
                State curr = que.poll();
                if (curr.equals(dest)) {
                    System.out.println("YES");
                    continue outer;
                }
                State ns = curr.op1();
                if (!vis.contains(ns)) {
                    que.offer(ns);
                    vis.add(ns);
                }
                ns = curr.op2();
                if (!vis.contains(ns)) {
                    que.offer(ns);
                    vis.add(ns);
                }
                ns = curr.op3();
                if (!vis.contains(ns)) {
                    que.offer(ns);
                    vis.add(ns);
                }
            }
            System.out.println("NO");
        }
    }
}
