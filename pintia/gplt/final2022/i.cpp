#include <cstdio>
#include <queue>
#include <stack>

using namespace std;

int n, m, k;
queue<int> que;
stack<int> stk;
int last, cnt;

int main() {
    scanf("%d%d%d", &n, &m, &k);
    for (int i = 0; i < n; ++i) {
        int x; scanf("%d", &x);
        que.push(x);
    }
    while (!que.empty() || !stk.empty()) {
        cnt = 0, last = 1e9;
        while (cnt < k) {
            if (!stk.empty() && stk.top() <= last) {
                if (cnt) printf(" ");
                printf("%d", stk.top());
                last = stk.top();
                stk.pop();
                ++cnt;
            } else if (!que.empty()) {
                int u = que.front();
                if (u <= last) {
                    if (cnt) printf(" ");
                    printf("%d", u);
                    last = u;
                    que.pop();
                    ++cnt;
                } else if (stk.size() < m) {
                    stk.push(u);
                    que.pop();
                } else break;
            } else break;
        }
        puts("");
    }

    return 0;
}