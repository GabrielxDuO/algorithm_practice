#include <cstdio>
#include <stack>
#include <vector>

using namespace std;

const int N = 1e3 + 10, INF = 0x3f3f3f3f;
int n, m, k;
int a[N], idx;
stack<int> box;

int main() {
    scanf("%d%d%d", &n, &m, &k);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    while (true) {
        int prev = INF;
        for (int i = 0; i < k && idx < n; ++i) {
            while ((box.empty() || box.top() > prev) && box.size() < m && idx < n) {
                box.push(a[idx++]);
            }
            if (box.top() > prev || box.empty()) break;
            if (prev != INF) printf(" ");
            printf("%d", box.top());
            prev = box.top();
            box.pop();
        }
        if (idx >= n) break;
        puts("");
    }

    return 0;
}