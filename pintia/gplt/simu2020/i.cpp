#include <cstdio>
#include <stack>

using namespace std;

int m, n, k;

int main() {
    scanf("%d%d%d", &m, &n, &k);
    while (k--) {
        stack<int> stk;
        int u, x = 1;
        bool is_valid = true;
        for (int i = 0; i < n; ++i) {
            scanf("%d", &u);
            while (x <= u) stk.push(x++);
            if (stk.empty() || stk.size() > m || u != stk.top()) is_valid = false;
            else stk.pop();
        }
        puts(is_valid ? "YES" : "NO");
    }

    return 0;
}