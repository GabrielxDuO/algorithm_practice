import java.util.*;
import java.io.*;

public class _青蛙跳杯子 {
    static State origin, target;
    static int N;

    static class State {
        char[] cups;
        int step = 0, emptyPos = 0;

        State(String str) { this(str.toCharArray()); }

        State(char[] cups) { this(cups, 0); }

        State(char[] cups, int step) {
            this.cups = cups;
            this.step = step;
            for (int i = 0; i < cups.length; ++i) {
                if (cups[i] == '*') emptyPos = i;
            }
        }

        @Override
        public int hashCode() { return Arrays.hashCode(this.cups); }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof State) {
                State s = (State) obj;
                for (int i = 0; i < N; ++i) {
                    if (this.cups[i] != s.cups[i]) return false;
                }
                return true;
            }
            return false;
        }

        State newState(int pos) {
            char[] newCups = Arrays.copyOf(cups, N);
            newCups[emptyPos] = cups[pos];
            newCups[pos] = cups[emptyPos];
            return new State(newCups, step + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        origin = new State(in.readLine());
        target = new State(in.readLine());
        N = origin.cups.length;
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<State> que = new LinkedList<>();
        Set<State> set = new HashSet<>();
        que.add(origin);
        while (!que.isEmpty()) {
            State s = que.poll();
            if (s.equals(target)) return s.step;
            for (int offset = -3; offset <= 3; ++offset) {
                if (offset == 0) continue;
                int targetPos = s.emptyPos + offset;
                if (targetPos >= 0 && targetPos < N) {
                    State newState = s.newState(targetPos);
                    if (!set.contains(newState)) {
                        set.add(newState);
                        que.offer(newState);
                    }
                }
            }
        }
        return -1;
    }
}
