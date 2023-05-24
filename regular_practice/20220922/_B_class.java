import java.util.*;
import java.io.*;

public class _B_class {
    static class State {
        char[] cups;
        int step, emptyPos = -1;

        State(char[] cups, int step) {
            this.cups = cups;
            this.step = step;
            for (int i = 0; i < cups.length; ++i) {
                if (cups[i] == '*') {
                    this.emptyPos = i;
                    break;
                }
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof State)) return false;
            State s = (State) obj;
            int n = this.cups.length;
            for (int i = 0; i < n; ++i) {
                if (this.cups[i] != s.cups[i]) return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(this.cups);
        }

        State newFrom(int pos) {
            char[] newCups = Arrays.copyOf(cups, cups.length);
            newCups[emptyPos] = cups[pos];
            newCups[pos] = cups[emptyPos];
            return new State(newCups, step + 1);
        }
    }

    static State origin, target;
    static Queue<State> que = new LinkedList<>();
    static Set<State> set = new HashSet<>();
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        origin = new State(in.readLine().toCharArray(), 0);
        target = new State(in.readLine().toCharArray(), 0);
        n = target.cups.length;
        System.out.println(bfs());
    }

    static int bfs() {
        que.offer(origin);
        while (!que.isEmpty()) {
            State state = que.poll();
            if (state.equals(target)) return state.step;
            for (int offset = -3; offset <= 3; ++offset) {
                if (offset == 0) continue;
                int targetPos = state.emptyPos + offset;
                if (targetPos >= 0 && targetPos < n) {
                    State newState = state.newFrom(targetPos);
                    if (!set.contains(newState)) {
                        set.add(newState);
                        que.add(newState);
                    }
                }
            }
        }
        return -1;
    }
}
