#include <cstdio>

using namespace std;

const int N = 1e3 + 10;
int n, m, k;
int stk[N], tt;

int main() {
    scanf("%d%d%d", &n, &m, &k);
    while (k--) {
        bool flag = false;
        tt = 0;
        int curr = 1;
        for (int i = 1; i <= n; ++i) {
            int x; scanf("%d", &x);
            if (curr == x) {
                ++curr;
                while (curr == stk[tt]) ++curr, --tt;
            } else stk[++tt] = x;
            if (tt > m) flag = true;
        }
        puts(flag || tt ? "NO" : "YES");
    }

    return 0;
}