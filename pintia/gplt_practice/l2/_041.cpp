#include <cstdio>
#include <stack>
#include <queue>
#include <vector>

using namespace std;

const int N = 1e3 + 10, INF = 0x3f3f3f3f;
int n, m, k;
queue<int> que;
stack<int> box;

int main() {
    scanf("%d%d%d", &n, &m, &k);
    for (int i = 0; i < n; ++i) {
        int x; scanf("%d", &x);
        que.push(x);
    }
    while (!box.empty() || !que.empty()) {
        int prev = INF;
        for (int i = 0; i < k; ++i) {
            if (!box.empty() && box.top() <= prev) {
                if (i != 0) printf(" ");
                prev = box.top();
                printf("%d", box.top());
                box.pop();
            } else if (!que.empty() && que.front() <= prev) {
                if (i != 0) printf(" ");
                prev = que.front();
                printf("%d", que.front());
                que.pop();
            } else if (!que.empty() && box.size() < m) {
                box.push(que.front());
                que.pop();
                --i;
            } else break;
        }
        puts("");
    }

    return 0;
}