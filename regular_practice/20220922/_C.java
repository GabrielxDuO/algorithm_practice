import java.io.*;
import java.util.*;

public class _C {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String A = in.readLine();
        String B = in.readLine();
        Queue<Character> queueA = new LinkedList<>();
        for (char ch : A.toCharArray()) queueA.offer(ch);
        Queue<Character> queueB = new LinkedList<>();
        for (char ch : B.toCharArray()) queueB.offer(ch);
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Boolean> has = new HashMap<>();
        boolean flag = true;
        int cnt = 0;
        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            Queue<Character> curr = flag ? queueA : queueB;
            char currPoke = curr.poll();
            stack.push(currPoke);
            while (has.getOrDefault(currPoke, false)) {
                curr.offer(stack.pop());
                has.put(currPoke, false);
                while (stack.peek() != currPoke) {
                    char poke = stack.pop();
                    has.put(poke, false);
                    curr.offer(poke);
                }
                curr.offer(stack.pop());
                currPoke = curr.poll();
                stack.push(currPoke);
            }
            has.put(currPoke, true);
            flag = !flag;
            if (++cnt > 1e5) {
                System.out.println(-1);
                return;
            }
        }
        Queue<Character> winner = queueA.isEmpty() ? queueB : queueA;
        int sz = winner.size();
        char[] ans = new char[sz];
        for (int i = 0; i < sz; ++i) ans[i] = winner.poll();
        System.out.println(String.valueOf(ans));
    }
}
